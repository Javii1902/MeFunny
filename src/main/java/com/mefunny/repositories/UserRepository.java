package com.mefunny.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mefunny.models.User;
import com.mefunny.utils.HibernateSessionFactory;

import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepository {

	public void save(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public User findByID(int userID)
	{
		User foundUser = null; 
		Session session = null;
		Transaction tx = null;
		try {
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("userID"), userID));
			
			
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return foundUser;
	}
	
	public void editPassword(int userID, String newPassword)
	{
		User currentUser = findByID(userID);
		currentUser.setPassword(newPassword);
		save(currentUser);
	}
}
