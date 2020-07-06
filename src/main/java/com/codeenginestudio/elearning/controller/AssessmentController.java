package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.validation.AssessmentValidation;

@Controller
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private ClassService classService;

	AssessmentValidation assessmentValidation = new AssessmentValidation();
	
	@GetMapping("/admin/assessment")
	public String showListAssessment(ModelMap model, @RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("assessmentPage", assessmentService.getPageListAssessment(page));
		return "/admin/assessment/listAssessment";
	}

	@GetMapping("/admin/assessment/addAssessment")
	public String addAssessment(ModelMap model) {

		model.addAttribute("listClass", classService.getAllClass());
		return "/admin/assessment/addAssessment";
	}

	@PostMapping("/admin/assessment/saveAddAssessment")
	public String saveAddAssessment(ModelMap model, AssessmentDTO assessmentDTO) {

		AssessmentValidation inValid = assessmentValidation.validateAddAssessment(assessmentDTO, assessmentService);
		if (inValid.getErrAssessmentName() == "" && inValid.getErrStartDate() == "" && inValid.getErrExpiredDate() == "") {
			assessmentService.saveAssessment(assessmentDTO);
			return "redirect:/admin/assessment";
		}else {
			model.addAttribute("error", inValid);
			model.addAttribute("listClass", classService.getAllClass());
			return "/admin/assessment/addAssessment";
		}
	}
	
	
}
