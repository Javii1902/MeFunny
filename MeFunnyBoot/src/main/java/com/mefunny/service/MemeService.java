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
	
	public void save(Meme meme) {
		this.memeRepository.save(meme);
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

	public void updateCaption(int id, String caption) {
		this.memeRepository.updateCaption(id, caption);
	}
	
//	public void incrementLikes(int id, int likes) {
//		this.memeRepository.incrementLikes(id, likes);
//	}
}
