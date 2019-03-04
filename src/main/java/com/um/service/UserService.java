package com.um.service;

import java.util.List;

import com.um.model.User;

public interface UserService {

	public String testDaoPattern();
	
	public List<User> findAll();
}