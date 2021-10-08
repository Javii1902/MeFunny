package com.mefunny.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mefunny.models.User;
import com.mefunny.services.UserService;
//import com.mefunny.exception.BusinessException;


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
	
	@GetMapping(path = "/userNameV2", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUserNameV2(@RequestParam String userName) {
		return this.userService.findByUserName(userName);
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user) {
		this.userService.save(user);
	}
	
//	@GetMapping(path = "/exception")
//	public void throwException() {
//			throw new RuntimeException();	
//	}
//	/*
//	 * proof for @ResponseStatus
//	 */
//	
//	@GetMapping(path = "/exception-handling")
//	public void throwBusinessException() throws BusinessException {
//		throw new BusinessException();
//	}
	
//	@GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//	private void LogIn(@PathVariable String userName){
//		
//		String userName = getPathVariable("userName");
//		String password = ctx.req.getParameter("password");
//		
//		User user = this.userService.findByUserName(userName);
//		
//		 if(user.getPassword().equals(password) {
//	            ctx.redirect("/userHome.html");
//		 }else {
//			 ctx.redirect("/Login.html");
//	            }
//	}
	
//	public UserController(Javalin app){
//		this.userService = new UserService();
//		app.routes(()-> {
//			path("/new",() -> {
//				post(saveUser);
//			});
//		});
//	}
//	
//	private Handler saveUser = ctx -> {
//		User user = new User(1,
//				ctx.req.getParameter("username"),
//				ctx.req.getParameter("password")
//				);
//		this.userService.save(user);
//	};
//	
}
