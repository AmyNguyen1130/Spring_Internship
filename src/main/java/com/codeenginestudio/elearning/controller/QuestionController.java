package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codeenginestudio.elearning.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/teacher/question")
	public String showListQuestions(ModelMap model) {

		model.addAttribute("questionPage", questionService.getListQuestion());
		return "/teacher/question/listQuestion";
	}

	@GetMapping("/teacher/question/listQuestion")
	public String questionByAssessmentid(ModelMap model, @ModelAttribute("assessmentid") Long assessmentid) {

		model.addAttribute("questionPage", questionService.getListQuestionbyAssessmentid(assessmentid));
		return "/teacher/question/listQuestion";
	}
}
