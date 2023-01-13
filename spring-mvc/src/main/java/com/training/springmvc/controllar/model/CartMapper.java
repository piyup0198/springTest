package com.training.springmvc.controllar.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CartMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cart cart =  new Cart();
		cart.setProdId(rs.getInt("prod_id"));
		cart.setProdName(rs.getString("prod_name"));
		cart.setProdDesc(rs.getString("prod_desc"));
		cart.setPrice(rs.getInt("price"));
		return cart;
	}

}