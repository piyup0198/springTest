package com.training.springmvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.springmvc.controllar.dao.UserDao;
import com.training.springmvc.controllar.dao.UserDaoImpl;
import com.training.springmvc.controllar.dao.UserRegisterDao;
import com.training.springmvc.controllar.dao.UserRegisterDaoImpl;
import com.training.springmvc.controllar.model.User;
@Service
public class RegisterServiceImpl{
	public boolean isUser_Registered(String username, String password) {

		boolean isValid1 = false;

		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "priyanka@1";
	        con = DriverManager.getConnection(url,user,pass);
	        PreparedStatement ps=con.prepareStatement(  
                    "insert into user_info(user_name,pass_word) values (?,?)");  
        ps.setString(1,username);
        ps.setString(2,password);
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
		return isValid1;
	}

}
