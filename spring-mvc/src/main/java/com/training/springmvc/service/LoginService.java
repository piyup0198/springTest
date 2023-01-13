package com.training.springmvc.service;

import org.springframework.stereotype.Service;


public interface LoginService {
	boolean isValidUser_det(String username, String password);

}