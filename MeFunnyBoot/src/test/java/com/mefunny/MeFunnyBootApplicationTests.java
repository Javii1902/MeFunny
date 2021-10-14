package com.mefunny;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mefunny.controller.MemeController;
import com.mefunny.controller.UserController;
import com.mefunny.model.Meme;
import com.mefunny.model.User;
import com.mefunny.repository.MemeRepository;
import com.mefunny.repository.UserRepository;
import com.mefunny.service.MemeService;
import com.mefunny.service.UserService;

@SpringBootTest
class MeFunnyBootApplicationTests {

	@InjectMocks
	private static UserService userService;
	
	@InjectMocks
	private static MemeService memeService;
	
	@Mock
	private static MemeRepository memeRepository;
	
	@Mock
	private static UserRepository userRepository;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private MemeController memeController;
	
	@BeforeAll
	public static void setUp() {
		userService = new UserService(userRepository);
	}
	
	@Test
	public void contenxtLoads() throws Exception{
		assertThat(userController).isNotNull();
		assertThat(memeController).isNotNull();
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
		//Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(new User());
	}
	
	@Test
	public void testFindByUserId() {
		//User user = new User();
		
		//Mockito.when(userService.findByUserId(Mockito.any(Integer.class))).thenReturn(new User());
		//User user = userService.findByUserId(Mockito.any(Integer.class));
		//assertThat(user).isNotNull();
	}
	
	public void testFindByUserName() {
		Mockito.when(userService.findByUserName(Mockito.any(String.class))).thenReturn(new User());
		User user = userService.findByUserName(Mockito.any(String.class));
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testFindAllMemes() {
		//Meme memes = new Meme();
		Mockito.when(memeService.findAll()).thenReturn(
				Arrays.asList(
						new Meme(1,"","",1,1,""),
						new Meme(2,"","",2,2,""),
						new Meme(3,"","",3,3,""),
						new Meme(4,"","",4,4,"")
						)
				);
		List<Meme> memes = memeService.findAll();
		assertThat(memes).isNotNull();
	}
	public void testMemeSave() {
		//Mockito.when(memeService.save(Mockito.any(Meme.class))).thenAnswer(new Meme());
	}
	
	public void testFindMemeByID() {
		Mockito.when(memeService.findById(Mockito.any(Integer.class))).thenReturn(new Meme());
		Meme meme = memeService.findById(Mockito.any(Integer.class));
		assertThat(meme).isNotNull();
	}
	public void testFindMemeByName() {
		Mockito.when(memeService.findByName(Mockito.any(String.class))).thenReturn(new Meme());
		Meme meme = memeService.findByName(Mockito.any(String.class));
		assertThat(meme).isNotNull();
	}
	
}
