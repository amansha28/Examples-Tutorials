package com.springcrudproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrudproduct.dao.ProductDao;
import com.springcrudproduct.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	public void createOrUpdateProduct(Product product) {
		productDao.createOrUpdateProduct(product);
		
	}

	public void deleteProduct(int ProductId) {
		productDao.deleteProduct(ProductId);
		
	}

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Product getSingleProduct(int ProductId) {
		return productDao.getSingleProduct(ProductId);
	}

}
