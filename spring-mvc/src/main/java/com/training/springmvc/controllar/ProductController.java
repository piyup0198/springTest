package com.training.springmvc.controllar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.springmvc.controllar.model.Cart;
import com.training.springmvc.controllar.model.Product;
import com.training.springmvc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllProduct(ModelMap map) {
		 Product p1 = service.getProduct();
		 
		 System.out.print(p1.getProdName());
		 map.addAttribute(p1);
		 
		 return "index";
	}

	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String getAllProducts(ModelMap map) {
		
		List<Product> prdList = service.getAllProducts();
		
		map.addAttribute("productList", prdList);
		
		return "product";
		
	}
/*	
	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String addProduct(ModelMap map, @ModelAttribute("product") Product product) {
		
		boolean flag = service.addProduct(product);
		
		if(flag) {
			map.addAttribute("msg", "Product Added Successfully!!");
			return "addProduct";
		}
		else {
			map.addAttribute("msg", "Error in Adding new Product!!");
			return "addProduct";
		}
		
		
	} */
	
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProductPage() {
		
			return "addProduct";
		
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap map,@PathVariable("id") Integer id) {
		
		if(service.deleteProduct(id)) {
			map.addAttribute("delMsg", "Product Deleted Successfully!!");
			return "product";
		}else {
			map.addAttribute("delMsg", "Product not Deleted Successfully!!");
			return "addProduct";
		}
	}
	
	@RequestMapping(value="update/{id}/{name}/{desc}/{price}", method = RequestMethod.GET)
	public String update(ModelMap map,@PathVariable("id") Integer id, @PathVariable("name") String name,  @PathVariable("desc") String desc,  @PathVariable("price") Integer price) {
		
		map.addAttribute("id",id);
		map.addAttribute("name",name);
		map.addAttribute("desc",desc);
		map.addAttribute("price",price);
		
		return "update";
	}
	
	@RequestMapping(value="updateProduct", method = RequestMethod.GET)
	public String updateProduct(ModelMap map, @ModelAttribute("product") Product product) {
		if(service.updateProduct(product)) {
			//map.addAttribute("updateMsg", "Product Updated Successfully!!");
			map.addAttribute("updateMsg", "Added To Cart!!");
			return "update";
		}else {
			//map.addAttribute("updateMsg", "Product not Updated Successfully!!");
			map.addAttribute("updateMsg", "Not Added To Cart!!");
			return "addProduct";
		}
		
	}
	

	
	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String addProduct(ModelMap map, @ModelAttribute("product") Product product) {
		
		boolean flag = service.addProduct(product);
		
		if(flag) {
			map.addAttribute("msg", "Product Added Successfully!!");
			return "addProduct";
		}
		else {
			map.addAttribute("msg", "Error in Adding new Product!!");
			return "addProduct";
		}
		
	}	
	
	
	
}
