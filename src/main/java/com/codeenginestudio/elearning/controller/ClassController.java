package com.codeenginestudio.elearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.constant.RoleConstant;
import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.validation.ClassValidation;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;

	@Autowired
	private UserService userService;

	@GetMapping("/admin/class")
	public String showListClass(ModelMap model, @RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("classPage", classService.getClassPage(page));

		return PREFIX + "listClass";
	}

	@GetMapping("/admin/class/addClass")
	public String addClass(ModelMap model) {

		model.addAttribute("data", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
		return PREFIX + "addClass";
	}

	@GetMapping("/admin/class/deleteClass")
	public String deleteClass(@ModelAttribute("classid") Long id) {

		classService.deleteClass(id);
		return "redirect:/admin/class";
	}

	@GetMapping("/admin/class/editClass")
	public String editClass(ModelMap model, @ModelAttribute("classid") Long id) {

		model.addAttribute("data", classService.showEditClass(id));
		model.addAttribute("user", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
		return PREFIX + "editClass";
	}

	@PostMapping("/admin/class/saveAddClass")
	public String saveAddClass(ModelMap model, ClassDTO classDTO) {

		List<String> errors = validationClass(classDTO);
		if (errors.size() > 0) {

			model.addAttribute("errors", errors);
			model.addAttribute("data", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
			return PREFIX + "addClass";
		}
		classService.saveClass(classDTO);
		return "redirect:/admin/class";
	}

	@PostMapping("/admin/class/saveEditClass")
	public String saveEditClass(ModelMap model, ClassDTO classDTO) {

		List<String> errors = validationClass(classDTO);
		if (errors.size() > 0) {

			model.addAttribute("errors", errors);
			model.addAttribute("data", classService.showEditClass(classDTO.getClassid()));
			model.addAttribute("user", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
			return PREFIX + "editClass";
		}
		classService.saveClass(classDTO);
		return "redirect:/admin/class";
	}

	public List<String> validationClass(ClassDTO classDTO) {
		List<String> errors = new ArrayList<>();

		if (!ClassValidation.checkEmpty(classDTO.getClassname())) {
			errors.add(ClassValidation.errClassname);
		}
		if (ClassValidation.checkEmpty(classDTO.getClassname())) {
			if (!ClassValidation.checkClassnameExisted(classDTO.getClassid(), classDTO.getClassname(), classService)) {
				errors.add(ClassValidation.errClassname);
			}
		}
		return errors;
	}

	private static final String PREFIX = "/admin/class/";

}
