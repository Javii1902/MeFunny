package com.mefunny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mefunny.model.Meme;
import com.mefunny.model.User;

@Repository("memeRepository")
public interface MemeRepository extends JpaRepository<Meme, Integer> {
	
	public List<Meme> findAll();
	
	public default Meme saveMeme(Meme meme) {
		
		return save(meme);
	}
	
	public List<Meme> findByUserName(String userName);
	
	public Meme findByName(String name);
	
	public Meme findById(int id);
	
	public default void incrementLikes(int id) {
		Meme updatememe = this.findById(id);
		int likes = updatememe.getLikes();
		updatememe.setLikes(++likes);
		
	}
	
	public default void incrementDislikes(int id) {
		Meme updatememe = this.findById(id);;
		int dislikes = updatememe.getDislikes();
		updatememe.setDislikes(++dislikes);
		
	}	
	
	public void deleteById(int id);
	
	public default String updateCaption(int id, String caption) {
		Meme describeMeme = findById(id);
		describeMeme.setCaption(caption);
		return "Updated caption.";
	}
}
