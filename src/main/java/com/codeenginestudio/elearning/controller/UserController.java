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
	public String goToListUser(Model model) {

		model.addAttribute("listUser", userService.getListUser());
		return "/admin/user/listUser";
	}

	@GetMapping("admin/user/addUser")
	public String goToAddStudent(Model model) {

		model.addAttribute("url", "admin/user/saveAddUser");
		return "admin/user/addUser";
	}

	@PostMapping("admin/user/saveAddUser")
	public String saveAddUser(UserDTO userDTO, Model model) {

		userService.addUser(userDTO);
		return "redirect: /";
	}

	@GetMapping("admin/user/deleteUser/{userId}")
	public String deleteProduct(@PathVariable(name = "userId") Long userId) {

		userService.deleteUser(userId);
		return "redirect:/";
	}

}
