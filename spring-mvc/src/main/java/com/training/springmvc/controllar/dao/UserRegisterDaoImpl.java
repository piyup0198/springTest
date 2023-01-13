package com.training.springmvc.controllar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.springmvc.controllar.model.User;

public class UserRegisterDaoImpl implements UserRegisterDao{
	public List<User> getUsers(String userN,String pasw){
		List<User> userList = new ArrayList<>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "priyanka@1";
	        con = DriverManager.getConnection(url,user,pass);
	        PreparedStatement ps=con.prepareStatement(  
                    "insert into user_info(user_name,pass_word) values (?,?)");  
        
       ps.setString(1,userN);
       ps.setString(2,pasw);
       ps.executeUpdate();  
	          	
	        	
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
