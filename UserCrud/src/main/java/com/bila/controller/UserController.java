package com.bila.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bila.model.Users;
import com.bila.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping ("/list")
	   
	public String showUser(Model model,@Param("keyword")String keyword) {
		//String keyword="MOZ";
		List<Users> listusers=service.listAll(keyword);
		model.addAttribute("listusers",listusers);
		model.addAttribute("keyword", keyword);
		return  "users";
	}
	

	
	@GetMapping ("/new")
	public String showNewForm(Model model,RedirectAttributes ra) {
		model.addAttribute("user", new Users());
		model.addAttribute("pageTitle"," Add New User");
		
		return "user-form";
	}
	
	@PostMapping("/save")
	public String  save(Users user,RedirectAttributes ra) {
		service.save(user);
		ra.addFlashAttribute("msg","The user has been saved successfully");
		return "redirect:list";
	}
	
	
	@GetMapping("/edit{id}")
	public String showEditForm(@PathVariable("id") int id,Model model,RedirectAttributes ra) {
		Optional<Users> user=service.get(id);
		model.addAttribute("user",user);
		model.addAttribute("pageTitle","Edit User");
		ra.addFlashAttribute("msg", "The user has been updated successfully");
	
		return "user-form";
	}
	
	@GetMapping("/delete{id}")
	public String  deleteUser(@PathVariable("id") int id,RedirectAttributes ra) {
		service.delete(id);
		ra.addFlashAttribute("msg","The user has been deleted successfully");
		return "redirect:list";
	}
	
}
