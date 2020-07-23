package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.SecurityUtil;

@Controller
public class ResultController {

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private ResultService resultService;

	@Autowired
	private QuestionOfAssessmentService questionOfAssessmentService;

	@GetMapping("/student/assessment/history/viewResult/{assessmentid}")
	public String getResultWithStudentRole(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
		model.addAttribute("assessment", assessmentService.getAssessmentByAssessmentid(assessmentid));

		model.addAttribute("listSubmitEdit", resultService.findByAssessmentAndStudent(assessmentid, userId));

		return PREFIX_STUDENT + "history/viewResultAssessment";
	}

	private static final String PREFIX_STUDENT = "/student/assessment/";

}
