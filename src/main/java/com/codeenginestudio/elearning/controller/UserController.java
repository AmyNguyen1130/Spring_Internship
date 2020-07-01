package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.RoleService;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/admin/user")
	public String showListUser(Model model, @RequestParam(name = "page", required = false) Integer page) {
		model.addAttribute("userPage", userService.getUserPage(page));
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "listUser";
	}

	@GetMapping("/admin/user/editUserEnabled/{userId}")
	public String editStatusUser(@PathVariable(name = "userId") Long userId) {
		userService.editUserStatus(userId);
		return "redirect:/admin/user";
	}

	@GetMapping("admin/user/addUser")
	public String addUser(Model model) {

		model.addAttribute("url", "/admin/user/saveAddUser");
		model.addAttribute("listRole", roleService.getListRole());

		return PREFIX + "addUser";
	}

	@PostMapping("admin/user/saveAddUser")
	public String saveAddUser(UserDTO userDTO) {

		userService.addUser(userDTO);
		return "redirect:/admin/user";
	}

	@GetMapping("admin/user/deleteUser/{userId}")
	public String deleteUser(@PathVariable(name = "userId") Long userId) {

		userService.deleteUser(userId);
		return "redirect:/admin/user";
	}

	@GetMapping("admin/user/editUser/{userId}")
	public String editUser(@PathVariable(name = "userId") Long userId, Model model) {

		model.addAttribute("userInf", userService.getOneUser(userId));
		model.addAttribute("url", "/admin/user/saveEditUser");
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "addUser";
	}

	@PostMapping("admin/user/saveEditUser")
	public String saveEditUser(UserDTO userDTO, Model model) {

		userService.editUser(userDTO);
		model.addAttribute("listRole", roleService.getListRole());
		return "redirect:/admin/user";
	}

	@GetMapping("/admin/user/getUserByEnabledAndRoleid")
	public String getUserByEnabledAndRoleid(Model model,
			@ModelAttribute("enabled") Boolean enabled,
			@ModelAttribute("roleid") Long roleid,
			@RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("listUser", userService.getUserByEnabledAndRoleid(enabled, roleid, page));
		model.addAttribute("listRole", roleService.getListRole());
		return PREFIX + "listUser";
	}

	private final String PREFIX = "/admin/user/";

}
