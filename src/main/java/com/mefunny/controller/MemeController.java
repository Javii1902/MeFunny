package com.mefunny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mefunny.model.Meme;
import com.mefunny.service.MemeService;

@CrossOrigin(origins = "*")
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
		this.memeService.saveMeme(meme);
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Meme> findAll(){
		return this.memeService.findAll();
	}
	
	@GetMapping(path = "/userName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Meme> findByUserName(@PathVariable String userName) {
		return this.memeService.findByUserName(userName);
	}
	
	@GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Meme findByName(@PathVariable String name) {
		return this.memeService.findByName(name);
	}
	
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Meme findById(@PathVariable int id) {
		return this.memeService.findById(id);
	}
	
	@PostMapping(path = "/like", produces = MediaType.APPLICATION_JSON_VALUE)
	public void incrementLikes(@RequestParam int id) {
		 this.memeService.incrementLikes(id);
	}
	
	@PostMapping(path = "/dislike", produces = MediaType.APPLICATION_JSON_VALUE)
	public void incrementDislikes(@RequestParam int id) {
		 this.memeService.incrementDislikes(id);
	}	
	
	@DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteMeme(@RequestParam int id) {
		this.memeService.deleteMeme(id);
	}
	
	
	
	@PutMapping(path = "/caption", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCaption(@RequestBody Meme meme) {
		return this.memeService.updateCaption(meme.getId(), meme.getCaption());
	}
	
}
