package com.springbootsecurity.projectSBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springbootsecurity.projectSBS.model.User;
import com.springbootsecurity.projectSBS.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public String user (Model model, HttpServletRequest request) {
		User authUser = (User) request.getSession().getAttribute("user");
		String forRole = "With roles: ";
		model.addAttribute("name", authUser.getName());
		model.addAttribute("string", forRole);
		model.addAttribute("roles", authUser.getRoles());
		model.addAttribute("user", authUser);

		return "user";
	}
}