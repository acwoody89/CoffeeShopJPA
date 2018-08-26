package com.coffeeshop.CoffeeShop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShop.entity.Users;

@Repository
@Transactional
public class UsersDao {
	// Use this annotation to have Spring inject the Hibernate entity manager
		@PersistenceContext
		private EntityManager em1;
		
		
		public Users findById(Long id) {
			return em1.find(Users.class, id);
		}
		
		public List<Users> findAll(){
			// The select clause is optional in HQL. If ommitted, it's basically like
			// using SELECT * 
			// when creating the query we must specify the type of results, (Food.class in this instance)
			return em1.createQuery("FROM users", Users.class).getResultList();
		}
}
