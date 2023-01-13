package com.training.springmvc.controllar.dao;

import java.util.List;

import com.training.springmvc.controllar.model.Cart;
import com.training.springmvc.controllar.model.Product;

public interface ProductDao {

	//this method will fetch me a product of given id
	Product getProductById(int id);
	
	//this method will fetch all the products in the database
	List<Product> getProducts();
	
	//this method will create new product in database
	boolean createProduct(Product product);
	
	boolean deleteProduct(int prodId);
	
	boolean updateProduct(Product product);
	
	List<Cart> getCart();
	
	
	
	
	
}
