package com.springcrudproduct.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.springcrudproduct.model.Product;
import com.springcrudproduct.service.DefaultProductCreationServiceImpl;
import com.springcrudproduct.service.ProductServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private DefaultProductCreationServiceImpl defaultProductCreationServiceImpl;
	
	// To add few entries in the Products Table as its using H2 DB.
	@PostConstruct
	public void init()
	{
		System.out.println("#### defaultProductCreationServiceImpl.getIsCreated() :: "+defaultProductCreationServiceImpl.getIsCreated());
		if(defaultProductCreationServiceImpl.getIsCreated()!=true)
		{
			Product product1 = new Product();
			product1.setProductName("Nokia 1100");
			product1.setProductDescription("Most popular phone by Nokia.");
			product1.setProductPrice("1500");
			
			productServiceImpl.createOrUpdateProduct(product1);
			
			Product product2 = new Product();
			product2.setProductName("Sony Bravia");
			product2.setProductDescription("TV with great picture and sound quality.");
			product2.setProductPrice("58000");
			
			productServiceImpl.createOrUpdateProduct(product2);
			
			Product product3 = new Product();
			
			product3.setProductName("LG CoolerMaster");
			product3.setProductDescription("AC with adjustable cooling capacity");
			product3.setProductPrice("30000");
			
			productServiceImpl.createOrUpdateProduct(product3);
			
			defaultProductCreationServiceImpl.setDefaultFlag(true);
		}
		
	}

	@GetMapping("/home")
	public String homePageHandler(Model m) {

		List<Product> lop = productServiceImpl.getAllProducts();
		m.addAttribute("products", lop);
		return "home";
	}

	@GetMapping("/add-product")
	public String addProductPage(Model m) {
		m.addAttribute("title", "Add Product");
		return "add-product-form";
	}

	/**
	 * DO NOT use return type as String instead of RedirectView as we want to
	 * redirect to /home page after adding new product.
	 * If we use String to as return type, newly added products will not be loaded on home page.
	 **/
	// Handler to add the product from the page with user inputs.
	@PostMapping(path = "/handle-product")
	public RedirectView addProducthandler(@ModelAttribute Product product, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		System.out.println("Adding 1 new product : " + product);
		productServiceImpl.createOrUpdateProduct(product);
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}
	
	
	
	// Handler to delete a single selected device from the table.
	@GetMapping(path="/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request )
	{
		System.out.println("Deleting the product with Id : "+productId);
		RedirectView redirectView = new RedirectView();
		productServiceImpl.deleteProduct(productId);
		redirectView.setUrl(request.getContextPath()+"/home");
		return redirectView;
	}
	
	//Handler to direct to device details update page.
	@GetMapping(path="update/{productId}")
	public String editproductDetails(@PathVariable("productId") int productId, Model m)
	{
		Product product = productServiceImpl.getSingleProduct(productId);
		System.out.println("Product read from DB : "+ product);
		m.addAttribute("product2BEdited", product);
		m.addAttribute("title", "Update Product");
		return "update-product-form";
	}
	
	//Handler to update the details of the selected device.
	@PostMapping(path="/update-product")
	public RedirectView editProducthandler(@ModelAttribute Product product, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		System.out.println("Editing 1  product : " + product);
		productServiceImpl.createOrUpdateProduct(product);
		System.out.println("Context Path : "+request.getContextPath());
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}
	
}
