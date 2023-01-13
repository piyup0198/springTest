package com.training.springmvc.controllar.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product =  new Product();
		product.setProdId(rs.getInt("prod_id"));
		product.setProdName(rs.getString("prod_name"));
		product.setProdDesc(rs.getString("prod_desc"));
		product.setPrice(rs.getInt("price"));
		return product;
	}

}


//JPA : Java Persistence API
//Hibernate : ORM framework