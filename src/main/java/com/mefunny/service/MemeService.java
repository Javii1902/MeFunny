package com.mefunny.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mefunny.model.Meme;
import com.mefunny.repository.MemeRepository;

@Transactional
@Service("memeService")
public class MemeService {
	
	private MemeRepository memeRepository;
	
	@Autowired
	public MemeService(MemeRepository memeRepository) {
		this.memeRepository = memeRepository;
	}
	
	public Meme saveMeme (Meme meme) {
		return this.memeRepository.saveMeme(meme);
	}
			
	public List<Meme> findAll(){
		return this.memeRepository.findAll();
	}	
	
	public List<Meme> findByUserName(String userName) {
		return this.memeRepository.findByUserName(userName);
	}
	
	public Meme findByName(String name) {
		return this.memeRepository.findByName(name);
	}
	
	public Meme findById(int id) {
		return this.memeRepository.findById(id);
	}
	
	public void incrementLikes(int id, int likes) {
		this.memeRepository.incrementLikes(id);
	}
	
	public String updateCaption(int id, String caption) {
		return this.memeRepository.updateCaption(id, caption);
	}
	
	public void incrementLikes(int id) {
		this.memeRepository.incrementLikes(id);
	}
	
	public void incrementDislikes(int id) {
		this.memeRepository.incrementDislikes(id);
	}
	
	public void deleteMeme(int id) {
		this.memeRepository.deleteById(id);
	}

}
