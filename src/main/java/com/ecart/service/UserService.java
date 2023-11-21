package com.ecart.service;

import com.ecart.repository.models.User;

public interface UserService {

	public void saveUser(User user);
	
	public User findByEmailAndPassword(String email, String password);
	
}
