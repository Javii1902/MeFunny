package com.mefunny.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mefunny.model.User;
import com.mefunny.repository.UserRepository;

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
	
	public User findByUserId(int userId) {
		return this.userRepository.findByUserId(userId);
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public void updatePassword(int id, String newPassword) {
		this.userRepository.updatePassword(id, newPassword);
	}
	
	public User findByUserNameAndPassword(String userName, String password) {
		return this.userRepository.findByUserNameAndPassword(userName, password);
	}
}
