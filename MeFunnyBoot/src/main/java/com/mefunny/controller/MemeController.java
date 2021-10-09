package com.mefunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mefunny.model.Meme;
import com.mefunny.service.MemeService;


@RestController("memeController")
@RequestMapping("/meme")
public class MemeController {

	
	private MemeService memeService;
	
	@Autowired
	public MemeController(MemeService memeService) {
		this.memeService = memeService;
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveMeme(@RequestBody Meme meme) {
		this.memeService.save(meme);
	}
	
}
