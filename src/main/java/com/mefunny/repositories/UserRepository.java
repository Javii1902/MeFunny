package com.mefunny.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public User logIn(String userName) {
		
        Session s = null;
        Transaction tx = null;
        User user = null;

        try {
            s = HibernateSessionFactory.getSession();
            tx = s.beginTransaction();

            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> root = cq.from(User.class);
            cq.select(root).where(cb.equal(root.get("userName"), userName));
            Query<User> query = s.createQuery(cq);
            user = query.getSingleResult();       
        	 tx.commit();
        }catch(HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
        return user;
    }
	
	
	public User findByUserName(String userName) {
        
		TypedQuery<User> query = 
				this.entityManager.createQuery("FROM User where userName = :userName", User.class);
				query.setParameter("userName", userName);
				return query.getSingleResult();
	}	

	public void save(User user) {
		this.entityManager.persist(user);
	}
	
	public List<User> findAll(){
		
		return entityManager.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findByID(int userID)
	{
		TypedQuery<User> query = 
				this.entityManager.createQuery("FROM User where userName = :userName", User.class);
				query.setParameter("userID", userID);
				return query.getSingleResult();
	}	
	
	public void editPassword(int userID, String newPassword)
	{
		User currentUser = findByID(userID);
		currentUser.setPassword(newPassword);
		save(currentUser);
	}
	
	
	
}
