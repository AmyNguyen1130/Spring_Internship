package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showListUser(Model model) {

		model.addAttribute("listUser", userService.getListUser());
		return PRE_FIX + "listUser";
	}

	@GetMapping("admin/user/addUser")
	public String addUser(Model model) {

		model.addAttribute("url", "/admin/user/saveAddUser");
		return PRE_FIX + "addUser";
	}

	@PostMapping("admin/user/saveAddUser")
	public String saveAddUser(UserDTO userDTO, Model model) {

		userService.addUser(userDTO);
		model.addAttribute("listUser", userService.getListUser());
		return PRE_FIX + "listUser";
	}

	@GetMapping("admin/user/deleteUser/{userId}")
	public String deleteUser(@PathVariable(name = "userId") Long userId, Model model) {

		userService.deleteUser(userId);
		model.addAttribute("listUser", userService.getListUser());
		return PRE_FIX + "listUser";
	}

	private final String PRE_FIX = "admin/user/";

}
