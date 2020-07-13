package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.RoleService;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.validation.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	UserValidator userValidator = new UserValidator();

	@GetMapping("/admin/user")
	public String showListUser(Model model, @RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("userPage", userService.getUserPage(page));
		return PREFIX + "listUser";
	}

	@GetMapping("admin/user/addUser")
	public String addUser(Model model) {

		model.addAttribute("url", "/admin/user/saveAddUser");
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "addUser";
	}

	@GetMapping("/admin/user/editUserEnabled/{userId}")
	public String editStatusUser(@PathVariable(name = "userId") Long userId) {
		userService.editUserStatus(userId);
		return "redirect:/admin/user";
	}

	@PostMapping("admin/user/saveAddUser")
	public String saveAddUser(UserDTO userDTO, Model model) {

		UserValidator inValid = userValidator.validateAddUser(userDTO, userService);

		if (inValid.noError()) {
			userService.addUser(userDTO);
			return "redirect:/admin/user";
		}

		model.addAttribute("error", inValid);
		model.addAttribute("userInf", userDTO);
		model.addAttribute("url", "/admin/user/saveAddUser");
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "addUser";
	}

	@GetMapping("admin/user/deleteUser/{userId}")
	public String deleteUser(@PathVariable(name = "userId") Long userId) {

		userService.deleteUser(userId);
		return "redirect:/admin/user";
	}

	@GetMapping("admin/user/editUser/{userId}")
	public String editUser(@PathVariable(name = "userId") Long userId, Model model) {

		model.addAttribute("userInf", userService.showUserByUserId(userId));
		model.addAttribute("url", "/admin/user/saveEditUser");
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "addUser";
	}

	@PostMapping("admin/user/saveEditUser")
	public String saveEditUser(UserDTO userDTO, Model model) {

		UserValidator userInValid = userValidator.validateEditUser(userDTO, userService, userDTO.getUserid());

		if (userInValid.noError()) {
			userService.editUser(userDTO);
			return "redirect:/admin/user";
		}

		model.addAttribute("error", userInValid);
		model.addAttribute("userInf", userDTO);
		model.addAttribute("url", "/admin/user/saveEditUser");
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "addUser";
	}

	private final String PREFIX = "/admin/user/";
}
