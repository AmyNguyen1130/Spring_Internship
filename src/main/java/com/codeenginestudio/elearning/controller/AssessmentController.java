package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.ClassService;

@Controller
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private ClassService classService;

	@GetMapping("/admin/assessment")
	public String showListAssessment(ModelMap model, @RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("assessmentPage", assessmentService.getPageListAssessment(page));
		return "/admin/assessment/listAssessment";
	}

	@GetMapping("/admin/class/addAssessment")
	public String addAssessment(ModelMap model) {

		model.addAttribute("listClass", classService.getAllClass());
		return "/admin/assessment/addAssessment";
	}
}
