package com.um.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.um.model.Role;
import com.um.model.User;
import com.um.service.UserService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class MainController {

	@Autowired
	private UserService userRepository;

	@GetMapping("/allusers")
	public @ResponseBody List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String email,
			@RequestParam String password, @RequestParam int roleId) {
		userRepository.add(username, password, email, roleId);
		return "Saved";
	}

	@PostMapping("/addRole")
	public @ResponseBody String addRole(@RequestParam String name) {
		Role role = new Role();
		role.setName(name);
		userRepository.addRole(name);
		return "Saved";
	}
}
