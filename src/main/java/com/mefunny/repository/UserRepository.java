package com.mefunny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mefunny.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
		
	
	public User findByUserName(String userName);

	public default User saveUser(User user) {
		
		return save(user);
	}
	
	public List<User> findAll();
	
	public User findByUserId(int userId);
	
	public default String updatePassword(int id, String password) {
		User updateuser = findByUserId(id);
		updateuser.setPassword(password);
		
		return "Password updated.";
	}
	
//	public default User findByUserNameAndPassword(String userName, String password) {
//  User user = findByUserName(userName);
//  if (password == user.getPassword()) {
//      return user;
//  }else
//      return null;
//  }

	public User findByUserNameAndPassword(String userName, String password);

	public void deleteById(int id);
	
}
