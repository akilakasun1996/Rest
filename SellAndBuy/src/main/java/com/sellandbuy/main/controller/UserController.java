package com.sellandbuy.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sellandbuy.main.models.User;
import com.sellandbuy.main.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping("/createUser")
	public User createUser(@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam String mobile,@RequestParam String address,@RequestParam boolean isAdmin,@RequestParam String type) {
		return userService.createUser(name, email, password, mobile, address, isAdmin,type);
	}
	
	@RequestMapping("/getUserByEmail")
	public User getUserByEmail(@RequestParam String email) {
		return userService.getUserByEmail(email);
	}
	
	@RequestMapping("/isValidUser")
	public boolean isValidUser(@RequestParam String email,@RequestParam String password) {
		return userService.isValidUser(email, password);
	}
}
