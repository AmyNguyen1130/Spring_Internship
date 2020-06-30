package com.codeenginestudio.elearning.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String showListClass(ModelMap model) {

		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}

	@GetMapping("/admin/class/addClass")
	public String addClass(ModelMap model) {

		model.addAttribute("data", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
		return PREFIX + "addClass";
	}

	@GetMapping("/admin/class/deleteClass")
	public String deleteClass(ModelMap model, @ModelAttribute("id") Long id) {

		classService.deleteClass(id);
		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}

	@GetMapping("/admin/class/editClass")
	public String editClass(ModelMap model, @ModelAttribute("id") Long id) {

		model.addAttribute("data", classService.showEditClass(id));
		model.addAttribute("user", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
		return PREFIX + "editClass";
	}

	@PostMapping("/admin/class/saveAddClass")
	public String saveAddClass(ModelMap model, @Valid ClassDTO classDTO) {

		List<String> errors = validationClass(classDTO);
		if(errors.size() > 0) {
			model.addAttribute("data", userService.getUsersByRoleid(RoleConstant.ROLE_TEACHER));
			model.addAttribute("errors", errors);
			return PREFIX + "addClass";
		}

		classService.saveClass(classDTO);
		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}
	
	public List<String> validationClass(ClassDTO classDTO) {
		List<String> errors = new ArrayList<>();
		
		if (!ClassValidation.checkEmpty(classDTO.getClassname())) {
			errors.add(ClassValidation.errClassname);
		}
		if (ClassValidation.checkEmpty(classDTO.getClassname())) {
			if (!ClassValidation.checkClassnameExisted(classDTO.getClassname(), classService)) {
				errors.add(ClassValidation.errClassname);
			}
		}
		
		return errors;
	}

	@PostMapping("/admin/class/saveEditClass")
	public String saveEditClass(ModelMap model, ClassDTO classDTO) {

		classService.saveClass(classDTO);
		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}

	private static final String PREFIX = "/admin/class/";

}
