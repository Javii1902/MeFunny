package com.mefunny.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mefunny.model.Meme;

@Repository("memeRepository")
public class MemeRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Meme meme) {
		this.entityManager.persist(meme);
	}
	
}
