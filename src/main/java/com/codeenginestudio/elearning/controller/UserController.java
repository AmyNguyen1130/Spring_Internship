package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.service.RoleService;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.validation.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private StudentInClassService studentInClassService;

	@Autowired
	private ClassService classService;

	UserValidator userValidator = new UserValidator();

	@GetMapping("/admin/user")
	public String showListUser(Model model, @RequestParam(name = "page", required = false) Integer page) {

		Page<UserDTO> listUsers = userService.getUserPage(page);

		for (UserDTO userDTO : listUsers) {
			userDTO.setTotalAssigned(studentInClassService.getClassIdByStudent(userDTO.getUserid()).size()
					+ classService.getClassByTeacherId(userDTO.getUserid()).size());
			if (userDTO.getTotalAssigned() == 0) {
				userDTO.setIsDelete(true);
			}
		}

		if(listUsers.getContent().size() == 1) {
			if(listUsers.getContent().get(0) .getRole().getRoleid() == 1){
				return PREFIX + "noUserFound";
			}
		}

		model.addAttribute("userPage", listUsers);

		return PREFIX + "listUser";
	}

	@GetMapping("admin/user/addUser")
	public String addUser(Model model, @ModelAttribute("role") Long roleId) {

		model.addAttribute("url", "/admin/user/saveAddUser");
		model.addAttribute("roleId", roleId);
		model.addAttribute("listRole", roleService.getListRole());

		return PREFIX + "addAndEditUser";
	}

	@GetMapping("/admin/user/editUserEnabled/{userId}")
	public String editStatusUser(@PathVariable(name = "userId") Long userId, RedirectAttributes redirectAttributes) {

		userService.editUserStatus(userId);
		redirectAttributes.addFlashAttribute("messageSuccess", "Edit Status Successfully!!!");

		return "redirect:/admin/user";
	}

	@PostMapping("admin/user/saveAddUser")
	public String saveAddUser(UserDTO userDTO, Model model, RedirectAttributes redirectAttributes) {

		UserValidator inValid = userValidator.validateAddUser(userDTO, userService);

		if (inValid.noError()) {
			userService.addUser(userDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", "Add User Successfully!!! ");
			return "redirect:/admin/user";
		}

		model.addAttribute("error", inValid);
		model.addAttribute("roleId", userDTO.getRole().getRoleid());
		model.addAttribute("userInf", userDTO);
		model.addAttribute("url", "/admin/user/saveAddUser");
		model.addAttribute("listRole", roleService.getListRole());

		return PREFIX + "addAndEditUser";
	}

	@GetMapping("admin/user/deleteUser/{userId}")
	public String deleteUser(@PathVariable(name = "userId") Long userId, RedirectAttributes redirectAttributes) {

		// TODO: move all to service
		UserDTO userDTO = userService.getUserByUserId(userId);
		
		if(userDTO.getRole().getRoleid() == 2) {
			classService.deleteClassByTeacherId(userId);
		}else if(userDTO.getRole().getRoleid() == 3) {
			studentInClassService.deleteStudentInClass(userId);
		}

		userService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("messageSuccess", "Delete User Successfully!!!");

		return "redirect:/admin/user";
	}

	@GetMapping("admin/user/editUser/{userId}")
	public String editUser(@PathVariable(name = "userId") Long userId, Model model) {

		model.addAttribute("userInf", userService.getUserByUserId(userId));
		model.addAttribute("url", "/admin/user/saveEditUser");
		model.addAttribute("listRole", roleService.getListRole());

		return PREFIX + "addAndEditUser";
	}

	@PostMapping("admin/user/saveEditUser")
	public String saveEditUser(UserDTO userDTO, Model model, RedirectAttributes redirectAttributes) {

		UserValidator userInValid = userValidator.validateEditUser(userDTO, userService, userDTO.getUserid());

		if (userInValid.noError()) {
			userService.editUser(userDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", "Edit User Successfully!!! ");
			return "redirect:/admin/user";
		}

		model.addAttribute("error", userInValid);
		model.addAttribute("userInf", userDTO);
		model.addAttribute("url", "/admin/user/saveEditUser");
		model.addAttribute("listRole", roleService.getListRole());

		return PREFIX + "addAndEditUser";
	}

	private final String PREFIX = "/admin/user/";
}
