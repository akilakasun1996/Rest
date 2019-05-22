package com.sellandbuy.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellandbuy.main.UserRepository;
import com.sellandbuy.main.models.User;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepo;

	public User createUser(String name, String email, String password, String mobile, String address, boolean isAdmin, String type) {
		return userRepo.save(new User(name, email, password, mobile, address, isAdmin,type));
		
	}
	
	public User getUserByEmail(String email) {		
		return userRepo.findByEmail(email);		
	}
	
	public boolean isValidUser(String email, String password) {
		
		User u = getUserByEmail(email);
		if(u != null) {
			if(u.getPassword().equals(password)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	

}

