package com.mefunny.controllers;

import com.mefunny.models.User;
import com.mefunny.service.UserService;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController {
	private UserService userService;
	
	public UserController(Javalin app){
		this.userService = new UserService();
		app.routes(()-> {
			path("/new",() -> {
				post(saveUser);
			});
		});
	}
	
	private Handler saveUser = ctx -> {
		User user = new User(1,
				ctx.req.getParameter("username"),
				ctx.req.getParameter("password")
				);
		this.userService.save(user);
	};
	
}
