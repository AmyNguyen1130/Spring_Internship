package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;

	@RequestMapping("/admin/")
	public String welcome(ModelMap model) {

		model.addAttribute("data", classService.getAllClass());

		return "listClassPage";
	}

	@GetMapping("/admin/addClass")
	public String showAddClass() {

		return "addClassPage";
	}

	@PostMapping("/admin/addClass")
	public String addClass(ModelMap model, ClassDTO classDTO) {

		classService.saveClass(classDTO);
		model.addAttribute("data", classService.getAllClass());

		return "listClassPage";
	}

	@GetMapping("/admin/editClass")
	public String showEditStudent(ModelMap model, @ModelAttribute("id") int id) {

		model.addAttribute("data", classService.showEditClass(id));

		return "editClassPage";
	}

	@PostMapping("/admin/editClass")
	public String editStudent(ModelMap model, ClassDTO classDTO) {

		classService.saveClass(classDTO);
		model.addAttribute("data", classService.getAllClass());

		return "listClassPage";
	}

	@GetMapping("/admin/deleteClass")
	public String deleteStudent(ModelMap model, @ModelAttribute("id") int id) {

		classService.deleteClass(id);
		model.addAttribute("data", classService.getAllClass());

		return "listClassPage";
	}

}
