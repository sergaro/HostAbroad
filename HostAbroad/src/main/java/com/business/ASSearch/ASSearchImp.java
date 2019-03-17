package com.business.ASSearch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ASSearchImp implements ASSearch {
	
	

	@Override
	public TUser searchHost(String nickname) {
		TUser tUser = new TUser();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		try {
			String queryString = "SELECT user FROM User user WHERE user.nickname = :nickname";
			Query query = em.createQuery(queryString);
			query.setParameter("nickname", nickname);
			User user = null;
			try {
				user =  (User) query.getSingleResult();
			}
			catch (NoResultException ex) {
				System.out.println(e.getMessage());
			}
			if(user != null){
				tUser.setNickName(user.getNickname());
				tUser.setRating(user.getRating());
				tUser.setDescription(user.getDescription());
				tUser.setHost(user.getHost());
			}
		}
		catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
			
		return tUser;
	}

}
