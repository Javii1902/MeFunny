package com.mefunny;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockitoSession;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mefunny.controller.UserController;
import com.mefunny.model.User;
import com.mefunny.service.UserService;

@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
@WebAppConfiguration

public class UserControllerTest {

	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void testGetAllUsersEndpoint() {
		Mockito.when(userService.findAll()).thenReturn(Arrays.asList(
				new User(1,"",""),
				new User(2,"","")
				));
	}
}
