package com.coffeeshop.CoffeeShop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShop.entity.Items;

@Repository
@Transactional
public class ItemsDao {
	// Use this annotation to have Spring inject the Hibernate entity manager
		@PersistenceContext
		private EntityManager em2;
		
		
		public Items findById(Long id) {
			return em2.find(Items.class, id);
		}
		
		
		public List<Items> findAll(){
			// The select clause is optional in HQL. If ommitted, it's basically like
			// using SELECT * 
			// when creating the query we must specify the type of results, (Food.class in this instance)
			return em2.createQuery("FROM items", Items.class).getResultList();
		}
}
