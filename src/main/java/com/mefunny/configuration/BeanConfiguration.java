package com.mefunny.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mefunny.repositories.UserRepository;

@Configuration
public class BeanConfiguration {
	
	@Bean(name = "userRepository")
	@Scope("singleton") //defines how the bean is created (prototype - new instance every time the bean is 
						//requested)
	public UserRepository userRepository() {
		return new UserRepository();
	}

}
