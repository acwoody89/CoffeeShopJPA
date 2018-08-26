package com.coffeeshop.CoffeeShop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.CoffeeShop.entity.Items;

// By extending JpaRepository we atuomatically get all the basic CRUD methods
// we don't need to annotate this interface
public interface ItemRepository extends JpaRepository<Items, Long>{
	
	// we can add specific queries if needed
	// use the nameing conventions for Jpa (variable names should match and be in camel_case)
	List<Items> findByItemNameContaining(String keyword);
	
	//List<Items> findByCategory(String category);
	
	// using this to show the difference using Entity manager and
	// a sorted TreeSet later
	//Set<String> findAllCategories(String categories);
}
