package com.cretasom.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cretasom.hotel.entity.User;
import com.cretasom.hotel.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	public UserController() {
		System.out.println("Creating bean of User controller");
	}

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		System.out.println(user);
		return userService.addUser(user);
	}

	@GetMapping("/get-all")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
}
