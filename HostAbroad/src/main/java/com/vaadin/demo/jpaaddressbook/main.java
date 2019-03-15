package com.vaadin.demo.jpaaddressbook;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.vaadin.demo.jpaaddressbook.domain.Name;

public class main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("addressbook");
		EntityManager em = emf.createEntityManager();
		

		List<Name> ar = em.createNativeQuery("SELECT * FROM Name", Name.class).getResultList();

		
		em.close();
		emf.close();
        
        for(Name n: ar) {
        	System.out.println(n.getName());
        }
	}
	

}
