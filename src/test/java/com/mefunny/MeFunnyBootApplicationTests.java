package com.mefunny;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mefunny.controller.UserController;
import com.mefunny.model.User;
import com.mefunny.repository.UserRepository;
import com.mefunny.service.UserService;

@SpringBootTest
class MeFunnyBootApplicationTests {

	@InjectMocks
	private static UserService userService;
	
	@Mock
	private static UserRepository userRepository;
	
	@Autowired
	private UserController userController;
	
	@BeforeAll
	public static void setUp() {
		userService = new UserService(userRepository);
	}
	
	@Test
	public void contenxtLoads() throws Exception{
		assertThat(userController).isNotNull();
	}
	
	@Test
	public void testFindAllUsers() {
		Mockito.when(userRepository.findAll()).thenReturn(
				Arrays.asList(
						new User(1,"",""),
						new User(2,"",""),
						new User(3,"",""),
						new User(4,"","")						
						)
				);
		
		List<User> users = userService.findAll();
		assertThat(users).isNotNull();
	}
	
	@Test
	public void testUserSave() {
		User user = new User(1,"","");
		
		//Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(user);
	}
	
	@Test
	public void testFindByUserId() {
		User user = new User();
		
		Mockito.when(userService.findByUserId(Mockito.any(Integer.class))).thenReturn(user);
	}
}
