package com.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.controllar.dao.BookRepository;
import com.training.springmvc.controllar.model.Book;
import com.training.springmvc.controllar.model.Product;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository repo;
	
	@Override
	public boolean createBook(Book book) {
		// TODO Auto-generated method stub
		
		Book b1 = repo.save(book);
		if(b1 != null)
		   return true;
		else {
			return false;
		}
	}


}
