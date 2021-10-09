package com.mefunny.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mefunny.model.User;

@Repository("userRepository")
public class UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	public User logIn(String userName) {
//		
//        Session s = null;
//        Transaction tx = null;
//        User user = null;
//
//        try {
//            s = HibernateSessionFactory.getSession();
//            tx = s.beginTransaction();
//
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<User> cq = cb.createQuery(User.class);
//            Root<User> root = cq.from(User.class);
//            cq.select(root).where(cb.equal(root.get("userName"), userName));
//            Query<User> query = s.createQuery(cq);
//            user = query.getSingleResult();       
//        	 tx.commit();
//        }catch(HibernateException e) {
//            tx.rollback();
//            e.printStackTrace();
//        }
//        return user;
//    }
	
	
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
	
	public User findById(int userId)
	{
		TypedQuery<User> query = 
				this.entityManager.createQuery("FROM User where userName = :userName", User.class);
				query.setParameter("userID", userId);
				return query.getSingleResult();
	}	
	
//	public void editPassword(int userId, String newPassword)
//	{
//		User currentUser = findByID(userID);
//		currentUser.setPassword(newPassword);
//		save(currentUser);
//	}
	
	
	
}
