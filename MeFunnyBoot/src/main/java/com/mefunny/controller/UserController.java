package com.mefunny.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mefunny.model.User;
import com.mefunny.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("userController")
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
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
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody User user) {
		this.userService.save(user);
	}
	
	
	@PutMapping(path = "/password", produces = MediaType.APPLICATION_JSON_VALUE) 
		public void updatePassword(@RequestBody User user) {
		
		this.userService.updatePassword(user.getUserId(), user.getPassword());
	}

}