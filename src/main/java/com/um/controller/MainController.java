package com.um.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.um.model.User;
import com.um.service.UserService;

@CrossOrigin(maxAge = 3600)
@RestController
public class MainController {

	@Autowired
	private UserService userRepository;

	@GetMapping("/test")
	public @ResponseBody String test() {
		return userRepository.testDaoPattern();
	}

	@GetMapping("/allusers")
	public @ResponseBody List<User> getAllUsers() {
		return userRepository.findAll();
	}

//	@GetMapping("/alluserswithrolename")
//	public @ResponseBody List<User> getAllUsersWithRoleName() {
//		return userRepository.findAllUserWithRolename();
//	}

//	@PostMapping("/add")
//	public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String email,
//			@RequestParam String password, @RequestParam int roleId) {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setEmail(email);
//		userRepository.save(user);
//		return "Saved";
//	}
//
//	@DeleteMapping("/delete")
//	public @ResponseBody String deleteUser(@RequestParam String username) {
//		userRepository.deleteById(username);
//		return "Deleted";
//	}
}
