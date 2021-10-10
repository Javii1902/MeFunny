package com.mefunny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mefunny.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
		
	
	public User findByUserName(String userName);

	public <S extends User> S save(User user);
	
	public List<User> findAll();
	
	public User findByUserId(int userId);
	
	
//	public void editPassword(int userId, String newPassword)
//	{
//		User currentUser = findById(userId);
//		currentUser.setPassword(newPassword);
//		save(currentUser);
//	}
	
	
	
}
