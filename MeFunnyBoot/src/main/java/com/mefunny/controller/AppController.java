package com.mefunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mefunny.repository.UserRepository;

@Controller
public class AppController {

	@Autowired
    private UserRepository userRepository;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
	
}