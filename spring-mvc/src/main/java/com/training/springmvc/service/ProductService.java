package com.training.springmvc.service;

import java.util.List;

import com.training.springmvc.controllar.model.Cart;
import com.training.springmvc.controllar.model.Product;

public interface ProductService {

	public Product getProduct();
	
	public List<Product> getAllProducts();
	
	public boolean addProduct(Product product);
	
	public boolean deleteProduct(int prodId);
	
	public boolean updateProduct(Product product);
	
	public List<Cart> getAllCarts();

	
}
