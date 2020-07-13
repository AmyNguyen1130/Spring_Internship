package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
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

	@GetMapping("/teacher/questionOfAssessment")
	public String showListQuestionPage(Model model, @RequestParam(name = "page", required = false) Integer page,
			@ModelAttribute("assessmentid") Long assessmentid) {

		AssessmentDTO assessment = assessmentService.getAssessmentById(assessmentid);
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(page, assessment));
		model.addAttribute("assessmentid", assessmentid);
		return PREFIX + "ListQuestionOfAssessment";
	}

	@GetMapping("/teacher/questionOfAssessment/addQuestionOfAssessment/{assessmentid}")
	public String addQuestionOfAssignment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		return PREFIX + "AddAndEditQuestionOfAssessment";
	}

	@PostMapping("teacher/questionOfAssessment/saveAddQuestionOfAssessment/{assessmentid}")
	public String saveAddQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model,
			@PathVariable(name = "assessmentid") Long assessmentid) {
		questionOfAssessmentService.addQuestionOfAssessment(questionOfAssessmentDTO);
		return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
	}

	@GetMapping("/teacher/questionOfAssessment/deleteQuestionOfAssessment/{assessmentid}/{questionId}")
	public String deleteQuestionOfAssessment(@PathVariable(name = "assessmentid") Long assessmentid,
			@PathVariable(name = "questionId") Long questionId) {
		questionOfAssessmentService.deleteQuestionOfAssessment(questionId);
		return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
	}

	@GetMapping("/teacher/questionOfAssessment/editQuestionOfAssessment/{assessmentid}/{questionId}")
	public String editQuestionOfAssessment(@PathVariable(name = "questionId") Long questionId,
			@PathVariable(name = "assessmentid") Long assessmentid, Model model) {

		model.addAttribute("questionInf", questionOfAssessmentService.getOneQuestionOfAssessment(questionId));
		model.addAttribute("listAssessment", assessmentService.getListAssessment());
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		model.addAttribute("url", "/teacher/questionOfAssessment/saveEditQuestionOfAssessment/" + assessmentid);
		return PREFIX + "AddAndEditQuestionOfAssessment";
	}

	@PostMapping("/teacher/questionOfAssessment/saveEditQuestionOfAssessment/{assessmentid}")
	public String saveEditQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model,
			@PathVariable(name = "assessmentid") Long assessmentid) {

		questionOfAssessmentService.editQuestionOfAssessment(questionOfAssessmentDTO);
		return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
	}

	private final String PREFIX = "/teacher/questionOfAssessment/";
}
