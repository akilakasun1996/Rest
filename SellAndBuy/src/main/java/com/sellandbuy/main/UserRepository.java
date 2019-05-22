package com.sellandbuy.main;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sellandbuy.main.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByUserId(String userId);
	public User findByEmail(String email);
	
	
	
}
