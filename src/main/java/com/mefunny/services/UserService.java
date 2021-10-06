package com.mefunny.services;

import com.mefunny.models.User;
import com.mefunny.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}
	public void save(User user) {
		this.userRepository.save(user);
	}
}
