package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.service.QuestionTypeService;

@Controller
public class QuestionOfAssessmentController {

	@Autowired
	private QuestionOfAssessmentService questionOfAssessmentService;

	@Autowired
	private AssessmentService assessmentService;
	
	@Autowired
	private QuestionTypeService questionTypeService;
	
	@GetMapping("/admin/questionOfAssessment")
	public String showListQuestionPage(Model model, @RequestParam(name = "page", required = false) Integer page,
			QuestionOfAssessmentDTO questionOfAssessmentDTO) {
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessmentid(page, 100L));
		model.addAttribute("listAssessment", assessmentService.getListAssessment());
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		return PREFIX + "ListQuestionOfAssessment";
	}

	@GetMapping("/admin/questionOfAssessment/addQuestionOfAssessment")
		public String addQuestionOfAssignment(Model model) {
			
			model.addAttribute("listAssessment", assessmentService.getListAssessment());
			model.addAttribute("url", "/admin/questionOfAssessment/saveAddQuestionOfAssessment");
			model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
			return PREFIX + "AddAndEditQuestionOfAssessment";
		}

	@PostMapping("admin/questionOfAssessment/saveAddQuestionOfAssessment")
	public String saveAddQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model) {
		questionOfAssessmentService.addQuestionOfAssessment(questionOfAssessmentDTO);
		return "redirect:/admin/questionOfAssessment";
	}

	@GetMapping("/admin/questionOfAssessment/deleteQuestionOfAssessment/{questionId}")
	public String deleteQuestionOfAssessment(@PathVariable(name = "questionId") Long questionId) {
		questionOfAssessmentService.deleteQuestionOfAssessment(questionId);
		return "redirect:/admin/questionOfAssessment";
	}
	
	@GetMapping("/admin/questionOfAssessment/editQuestionOfAssessment/{questionId}")
	public String editQuestionOfAssessment(@PathVariable(name = "questionId") Long questionId, Model model) {
				
		model.addAttribute("questionInf", questionOfAssessmentService.getOneQuestionOfAssessment(questionId));
		model.addAttribute("listAssessment", assessmentService.getListAssessment());
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		model.addAttribute("url", "/admin/questionOfAssessment/saveEditQuestionOfAssessment");
		return PREFIX + "AddAndEditQuestionOfAssessment";
	}
	
	@PostMapping("/admin/questionOfAssessment/saveEditQuestionOfAssessment")
	public String saveEditQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model) {
		
		questionOfAssessmentService.editQuestionOfAssessment(questionOfAssessmentDTO);
		return "redirect:/admin/questionOfAssessment";
	}
	
	private final String PREFIX = "/admin/questionOfAssessment/";
}
