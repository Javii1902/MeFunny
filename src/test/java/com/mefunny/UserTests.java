package com.mefunny;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mefunny.model.User;
import com.mefunny.repository.UserRepository;
import com.mefunny.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void testFindByUserName() {
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(new User(5,"Edward","Elric"));
		User testUser = userService.findByUserName(Mockito.anyString());
		assertThat(testUser).isNotNull();
	}
	
	@Test public void testSaveUser() {
		Mockito.when(userRepository.saveUser(new User(6, "Alphonse", "Elric"))).thenReturn(new User(6, "Alphonse", "Elric"));
		User testUser = userService.saveUser(new User(6, "Alphonse", "Elric"));
		assertThat(testUser).isNotNull();
	}
	
	@Test
	public void testFindAll() {
		Mockito.when(userRepository.findAll()).thenReturn(				
				Arrays.asList(
				new User(1,"",""),
				new User(2,"",""),
				new User(3,"",""),
				new User(4,"","")						
				));
		List<User> userList = userService.findAll();
		assertThat(userList).isNotNull();
	}
	
	@Test
	public void testFindByUserID() {
		Mockito.when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(new User(7,"Winry","Rockbell"));
		User testUser = userService.findByUserId(Mockito.anyInt());
		assertThat(testUser).isNotNull();
	}
	
	@Test
	public void testUpdatePassword() {
		Mockito.when(userRepository.updatePassword(Mockito.anyInt(), Mockito.anyString())).thenReturn("Password updated");
		String testMessage = userService.updatePassword(Mockito.anyInt(), Mockito.anyString());
		assertThat(testMessage).isNotNull();
		
	}
}
