package com.um.service;

import java.util.List;

import com.um.model.User;

public interface UserService {
	
	public List<User> findAll();
	
	public String add(String username, String password, String email, int roleId);
}