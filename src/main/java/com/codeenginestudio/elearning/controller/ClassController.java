package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;

	@GetMapping("/admin/class")
	public String showListClass(ModelMap model) {

		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}

	@GetMapping("/admin/class/addClass")
	public String addClass() {

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

		return PREFIX + "editClass";
	}

	@PostMapping("/admin/class/saveAddClass")
	public String saveAddClass(ModelMap model, ClassDTO classDTO) {

		classService.saveClass(classDTO);
		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}

	@PostMapping("/admin/class/saveEditClass")
	public String saveEditClass(ModelMap model, ClassDTO classDTO) {

		classService.saveClass(classDTO);
		model.addAttribute("data", classService.getAllClass());

		return PREFIX + "listClass";
	}

	private static final String PREFIX = "/admin/class/";

}
