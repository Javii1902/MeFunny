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
	
	public default User updatePassword(int id, String password) {
		User updateuser = findByUserId(id);
		updateuser.setPassword(password);
		
		return updateuser;
	}
	public default User findByUserNameAndPassword(String userName, String password) {
        User user = this.findByUserName(userName);
        if (password == user.getPassword()) {
            return user;
        }else
            return null;
    }
	
	//public User findByUserNameAndPassword(String userName, String password);
	
}
