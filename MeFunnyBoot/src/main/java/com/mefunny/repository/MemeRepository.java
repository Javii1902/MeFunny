package com.mefunny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mefunny.model.Meme;

@Repository("memeRepository")
public interface MemeRepository extends JpaRepository<Meme, Integer> {
	
	public List<Meme> findAll();
	
	public <S extends Meme> S save(Meme meme);
	
	public Meme findByUserName(String userName);
	
	public Meme findByName(String name);
	
	public Meme findById(int id);
	
}
