package com.mefunny.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mefunny.model.Meme;
import com.mefunny.repository.MemeRepository;
import com.mefunny.service.MemeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemeServiceTests {
	
	@Autowired
	private MemeService memeService;
	
	@MockBean
	private MemeRepository memeRepository;

	@Test
	public void testFindAll() {
		Mockito.when(memeRepository.findAll()).thenReturn(				
				Arrays.asList(
				new Meme(1,"","",2,3,"",""),
				new Meme(4,"","",5,6,"",""),
				new Meme(7,"","",8,9,"",""),
				new Meme(10,"","",11,12,"","")			
				));
		List<Meme> memeList = memeService.findAll();
		assertThat(memeList).isNotNull();
	}
	
	@Test public void testSaveMeme() {
		Mockito.when(memeRepository.saveMeme(new Meme(13,"","",14,15,"",""))).thenReturn(new Meme(13,"","",14,15,"",""));
		Meme testMeme = memeService.saveMeme(new Meme(13,"","",14,15,"",""));
		assertThat(testMeme).isNotNull();
	}
	
	@Test
	public void testFindByUserName() {
		Mockito.when(memeRepository.findByUserName(Mockito.anyString())).thenReturn(				
				Arrays.asList(
				new Meme(16,"","",17,18,"Username",""),
				new Meme(19,"","",20,21,"Username",""),
				new Meme(22,"","",23,24,"Username",""),
				new Meme(25,"","",26,27,"Username","")			
				));
		List<Meme> memeList = memeService.findByUserName(Mockito.anyString());
		assertThat(memeList).isNotNull();
	}
	
	@Test 
	public void testFindByName() {
		Mockito.when(memeRepository.findByName(Mockito.anyString())).thenReturn(new Meme(28,"","",29,30,"",""));
		Meme testMeme = memeService.findByName(Mockito.anyString());
		assertThat(testMeme).isNotNull();
	}
	
	@Test 
	public void testFindById() {
		Mockito.when(memeRepository.findById(Mockito.anyInt())).thenReturn(new Meme(31,"","",32,33,"",""));
		Meme testMeme = memeService.findById(Mockito.anyInt());
		assertThat(testMeme).isNotNull();
	}
	
	@Test
	public void testUpdateCaption() {
		Mockito.when(memeRepository.updateCaption(Mockito.anyInt(),Mockito.anyString())).thenReturn("Caption updated.");
		String testR = memeService.updateCaption(Mockito.anyInt(),Mockito.anyString());
	}

}
