package com.mefunny.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mefunny.models.User;
import com.mefunny.repositories.UserRepository;

@Transactional
@Service("userService")
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		
		return this.userRepository.findAll();
	}
	
	public User findByUserName(String userName) {
		return this.userRepository.findByUserName(userName);
	}
	
	public User LogIn(String userName) {
		return this.userRepository.findByUserName(userName);
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	
}
