package com.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.controllar.dao.ProductDao;
import com.training.springmvc.controllar.model.Cart;
import com.training.springmvc.controllar.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public Product getProduct() {
		
		Product p1 = productDao.getProductById(1);
		return p1;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productDao.getProducts();
		
		return productList;
	}

	@Override
	public boolean addProduct(Product product) {
		
		return productDao.createProduct(product);
	}

	@Override
	public boolean deleteProduct(int prodId) {
		
		return productDao.deleteProduct(prodId);
	}

	@Override
	public boolean updateProduct(Product product) {
		
		return productDao.updateProduct(product);
	}

	@Override
	public List<Cart> getAllCarts() {
        List<Cart> cartList = productDao.getCart();
		
		return cartList;
	}
}
