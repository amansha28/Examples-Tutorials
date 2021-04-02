package com.springcrudproduct.service;

import java.util.List;

import com.springcrudproduct.model.Product;

public interface ProductService {
	
	public void createOrUpdateProduct(Product product);
	
	public void deleteProduct(int ProductId);
	
	public List<Product> getAllProducts();
	
	public Product getSingleProduct(int ProductId);

}
