package com.um.dao;

import java.util.List;

import com.um.model.User;

public interface UserDAO {

	public String testDaoPattern();
	
	public List<User> findAll();
}