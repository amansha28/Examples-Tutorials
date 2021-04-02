package com.springcrudproduct.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcrudproduct.model.Product;

@Repository
public class ProductDao {

	@Autowired
	private HibernateTemplate template;
	
	// to create or update a product
	@Transactional
	public void createOrUpdateProduct(Product product)
	{
		System.out.println("1 Product is added/updated : "+product);
		template.saveOrUpdate(product);
	}
	
	// to delete a single product
	@Transactional
	public void deleteProduct(int id)
	{
		Product product = template.load(Product.class, id);
		System.out.println("Deleting 1 product : "+product);
		template.delete(product);
	}
	
	
	// to read all the products
	public List<Product> getAllProducts()
	{
		System.out.println("Getting all the products");
		List<Product> lop = template.loadAll(Product.class);
		return lop;
	}
	
	
	// to get a single product
	@Transactional
	public Product getSingleProduct(int id)
	{
		return template.get(Product.class, id);
	}
}
