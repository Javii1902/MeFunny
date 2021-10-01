package com.mefunny.service;

import com.mefunny.models.User;
import com.mefunny.repositories.UserRepository;

public class UserService {
	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}
	public void save(User user) {
		this.userRepository.save(user);
	}
}
