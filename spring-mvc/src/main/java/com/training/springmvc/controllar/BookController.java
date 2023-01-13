package com.training.springmvc.controllar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.springmvc.controllar.model.Book;
import com.training.springmvc.controllar.model.Product;
import com.training.springmvc.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping(value="/addBook", method = RequestMethod.GET)
	public String add() {
		System.out.print("hello");
			return "addBook";
		
	}
	
	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public String addBook(Model map, @ModelAttribute("book") Book book) {
		
		 if(service.createBook(book)) {
			 map.addAttribute("bookMsg", "Book Added Successfully");
			 return "addBook";
		 }else {
			 map.addAttribute("bookMsg", "Book not Added Successfully");
			 return "addBook";
		 }
			
		
	}
	

}
