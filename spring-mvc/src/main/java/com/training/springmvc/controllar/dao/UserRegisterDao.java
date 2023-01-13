package com.training.springmvc.controllar.dao;

import java.util.List;

import com.training.springmvc.controllar.model.User;
public interface UserRegisterDao {

	List<User> getUsers(String userN, String pasw);
}
