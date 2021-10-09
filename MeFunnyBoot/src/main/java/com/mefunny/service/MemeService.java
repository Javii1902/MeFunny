package com.mefunny.service;

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
	
	public void save (Meme meme) {
		this.memeRepository.save(meme);
	}
			
			

}
