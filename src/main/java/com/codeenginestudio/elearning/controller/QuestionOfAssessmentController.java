package com.codeenginestudio.elearning.controller;

import java.util.Map;

import java.util.List;

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
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.codeenginestudio.elearning.validation.QuestionValidator;
import com.codeenginestudio.elearning.util.OptionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class QuestionOfAssessmentController {

	@Autowired
	private QuestionOfAssessmentService questionOfAssessmentService;

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private QuestionTypeService questionTypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private ResultService resultService;

	QuestionValidator questionValidator = new QuestionValidator();

	// Teacher

	@GetMapping("/teacher/questionOfAssessment")
	public String getListQuestion(Model model, @ModelAttribute("assessmentid") Long assessmentid) {

		AssessmentDTO assessment = assessmentService.getAssessmentByAssessmentid(assessmentid);
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessment));
		model.addAttribute("assessmentid", assessmentid);

		return PREFIX_TEACHER + "listQuestionOfAssessment";
	}

	@GetMapping("/teacher/questionOfAssessment/addQuestionOfAssessment/{assessmentid}")
	public String addQuestionOfAssignment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		model.addAttribute("numericalorder", questionOfAssessmentService.generateNumericalOrder(assessmentid));
		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());

		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
	}

	@PostMapping("teacher/questionOfAssessment/saveAddQuestionOfAssessment/{assessmentid}")
	public String saveAddQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model,
			@PathVariable(name = "assessmentid") Long assessmentid) throws JsonProcessingException {

		questionOfAssessmentDTO.setNumericalorder(questionOfAssessmentService.generateNumericalOrder(assessmentid));
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

		model.addAttribute("numericalorder",
				questionOfAssessmentService.getOneQuestionOfAssessment(questionId).getNumericalorder());
		model.addAttribute("questionInf", questionOfAssessmentService.getOneQuestionOfAssessment(questionId));
		model.addAttribute("listAssessment", assessmentService.getListAssessment());
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		model.addAttribute("url", "/teacher/questionOfAssessment/saveEditQuestionOfAssessment/" + assessmentid);

		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
	}

	@PostMapping("/teacher/questionOfAssessment/saveEditQuestionOfAssessment/{assessmentid}")
	public String saveEditQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model,
			@PathVariable(name = "assessmentid") Long assessmentid, @ModelAttribute("questionid") Long questionId)
			throws JsonProcessingException {

		int numericalOrder = questionOfAssessmentService.getOneQuestionOfAssessment(questionId).getNumericalorder();
		questionOfAssessmentDTO.setNumericalorder(numericalOrder);
		questionOfAssessmentService.editQuestionOfAssessment(questionOfAssessmentDTO);

		return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
	}

	// Student

	@GetMapping("/student/questionOfAssessment")
	public String viewListQuestion(Model model, @ModelAttribute("assessmentid") Long assessmentid) {

		AssessmentDTO assessment = assessmentService.getAssessmentByAssessmentid(assessmentid);
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessment));
		model.addAttribute("assessment", assessment);

		return PREFIX_STUDENT + "listQuestionOfAssignment";
	}

	@PostMapping("student/submitAssessment/{assessmentid}")
	public String submitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid,
			@RequestParam Map<String, String> allParams) throws JsonProcessingException {

		String username = SecurityUtil.getUserPrincipal().getUsername();

		Long questionid = 0L;
		String answerChoice = "";

		for (Map.Entry<String, String> answer : allParams.entrySet()) {
			questionid = Long.parseLong(answer.getKey());
			answerChoice = answer.getValue();

			resultService.saveSubmitAssessment(userService.getUserByUsername(username),
					assessmentService.getAssessmentByAssessmentid(assessmentid),
					questionOfAssessmentService.getOneQuestionOfAssessment(questionid), answerChoice);
		}

		return PREFIX_STUDENT + "listQuestionOfAssignment";
	}

	private final String PREFIX_TEACHER = "/teacher/questionOfAssessment/";
	private final String PREFIX_STUDENT = "/student/questionOfAssignment/";
}
