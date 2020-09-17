package com.springbootsecurity.projectSBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springbootsecurity.projectSBS.model.User;
import com.springbootsecurity.projectSBS.service.UserService;


@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public String user(@RequestParam String name, Model model) {
		User user = userService.getUserByName(name);
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		model.addAttribute("roles", user.getRoles());
		return "user";
	}
}