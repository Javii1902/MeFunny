package com.mefunny.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mefunny.model.User;
import com.mefunny.service.UserService;


@RestController("userController")
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user) {
		this.userService.saveUser(user);
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll(){
		return this.userService.findAll();
	}
	

	@GetMapping(path = "/userName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUserName(@PathVariable String userName) {
		return this.userService.findByUserName(userName);
	}
	
	
	@GetMapping(path = "/userId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUserId(@PathVariable int userId) {
		return this.userService.findByUserId(userId);
	}
	
	@GetMapping(path = "/userNameV2", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUserNameV2(@RequestParam String userName) {
		return this.userService.findByUserName(userName);
	}	
	
	@PutMapping(path = "/password", produces = MediaType.APPLICATION_JSON_VALUE) 
	public void updatePassword(@RequestBody User user) {
	
	this.userService.updatePassword(user.getUserId(), user.getPassword());
	}
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody User enteredUser)
	{
		return this.userService.login(enteredUser.getUserName(),enteredUser.getPassword());
	}

}