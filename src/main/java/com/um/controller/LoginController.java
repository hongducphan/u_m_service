package com.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.um.model.LoginForm;
import com.um.model.User;
import com.um.service.UserService;

@RestController
public class LoginController {
	@Autowired
	private UserService userRepository;

	@PostMapping("/login")
	public @ResponseBody String login(@RequestBody LoginForm form) {
		User user = userRepository.login(form.getUsername(), form.getPassword());
		if(user == null) {
			return "Invalid username or password!";
		}
		return user.getUsername();
	}
}
