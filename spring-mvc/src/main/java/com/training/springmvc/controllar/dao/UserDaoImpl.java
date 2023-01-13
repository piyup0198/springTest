package com.training.springmvc.controllar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.springmvc.controllar.model.User;
@Service
public class UserDaoImpl implements UserDao{
	public List<User> getUsers(){
		List<User> userList = new ArrayList<>();
Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "priyanka@1";
	        con = DriverManager.getConnection(url,user,pass);
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from user_info");
	        while(rs.next()) {
	          	userList.add(new User(rs.getString(1), rs.getString(2)));
	          	
	        	
	        }
	       
		 }  
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userList;
		
	}

}
