package com.coffeeshop.CoffeeShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coffeeshop.CoffeeShop.dao.ItemRepository;
import com.coffeeshop.CoffeeShop.dao.UserRepository;
import com.coffeeshop.CoffeeShop.entity.Items;
import com.coffeeshop.CoffeeShop.entity.Users;

@Controller
public class HomeController {

	
	@Autowired
	ItemRepository itemsDao;
	@Autowired
	UserRepository usersDao;
	
	@RequestMapping("/index")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/register")
	public ModelAndView listFood() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("items", itemsDao.findAll());
		
		return mv;
	}
	
	
	
	@RequestMapping("/list-items")
	public ModelAndView listItems() {
		ModelAndView mv = new ModelAndView("list-items");
		mv.addObject("items", itemsDao.findAll());
		
		return mv;
	}
	
	@RequestMapping("/items/add")
	public ModelAndView addItems() {
		ModelAndView mv = new ModelAndView("items2-form");
		mv.addObject("title", "Add Item");
		
		return mv;
	}
	
	@PostMapping("/items/add")
	public ModelAndView submitItemsAdd(Items items) {
		itemsDao.save(items);
		return new ModelAndView("redirect:/list-items");

	}
	
	@RequestMapping("/items2-form/{itemID}/update")
	public ModelAndView editItems(@PathVariable("itemID") Items items) {
		ModelAndView mv = new ModelAndView("items2-form");
		mv.addObject("title", "Edit Item");
		mv.addObject("items", items);
		
		return mv;
	}
	
	@RequestMapping("/items2-form/{itemID}/delete")
	public ModelAndView deleteItems(@PathVariable("itemID") long id) {
		itemsDao.deleteById(id);
		return new ModelAndView("redirect:/list-items");
	}
	
	@PostMapping("/items2-form/{itemID}/update")
	public ModelAndView submitItemsEditForm(Items items) {
		itemsDao.save(items);
		return new ModelAndView("redirect:/list-items");

	}
	
	@RequestMapping("/list-users")
	public ModelAndView listUsers() {
		ModelAndView mv = new ModelAndView("list-users");
		mv.addObject("users", usersDao.findAll());
		
		return mv;
	}
	
	@RequestMapping("/users2-form/{id}/update")
	public ModelAndView editUsers(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("users2-form");
		mv.addObject("title", "Edit User");
		mv.addObject("users", usersDao.findById(id).orElse(null));
		
		return mv;
	}
	
	@RequestMapping("/users2-form/{id}/delete")
	public ModelAndView deleteUsers(@PathVariable("id") long id) {
		usersDao.deleteById(id);
		return new ModelAndView("redirect:/list-users");
	}
	
	
	@PostMapping("/users2-form/{id}/update")
	public ModelAndView submitUsersEditForm(Users user, @PathVariable("id") long id) {
		user.setId(id);
		usersDao.save(user);
		return new ModelAndView("redirect:/list-users");
		
	}
	
	@RequestMapping("/users/add")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("users2-form");
		mv.addObject("title", "Add User");
		
		return mv;
	}
	
	@PostMapping("/users/add")
	public ModelAndView submitUsersAdd(Users users) {
		usersDao.save(users);
		return new ModelAndView("redirect:/list-users");

	}
}
