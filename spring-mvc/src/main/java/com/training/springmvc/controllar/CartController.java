package com.training.springmvc.controllar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.springmvc.controllar.model.Cart;
import com.training.springmvc.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String getAllCarts(ModelMap map) {
		
		List<Cart> cList = service.getAllCarts();
		
		map.addAttribute("cartList", cList);
		
		return "cart";
		
	}
}
