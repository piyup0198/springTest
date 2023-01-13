package com.training.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.springmvc.controllar.dao.UserDao;
import com.training.springmvc.controllar.dao.UserDaoImpl;
import com.training.springmvc.controllar.model.User;
@Service
public class LoginServiceImpl implements LoginService {
	
	public boolean isValidUser_det(String username, String password) {
		UserDao dao = new UserDaoImpl();
		boolean isValid1 = false;
		List<User> userList1 = dao.getUsers();
		for (User user : userList1) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				isValid1 = true;
			}
		}
		return isValid1;
	}

}