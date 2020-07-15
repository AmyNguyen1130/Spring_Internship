package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.service.QuestionTypeService;
import com.codeenginestudio.elearning.validation.QuestionValidator;

@Controller
public class QuestionOfAssessmentController {

	@Autowired
	private QuestionOfAssessmentService questionOfAssessmentService;

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private QuestionTypeService questionTypeService;

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

		model.addAttribute("numericalorder", questionOfAssessmentService.generateNumbericalOrder(assessmentid));
		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
	}

	@PostMapping("teacher/questionOfAssessment/saveAddQuestionOfAssessment/{assessmentid}")
	public String saveAddQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model,
			@PathVariable(name = "assessmentid") Long assessmentid) {

		questionOfAssessmentDTO.setNumericalorder(
				questionOfAssessmentService.generateNumbericalOrder(questionOfAssessmentDTO.getQuestionid()));
		QuestionValidator invalid = questionValidator.validateQuestion(questionOfAssessmentDTO);

		if (invalid.noError()) {
			questionOfAssessmentService.addQuestionOfAssessment(questionOfAssessmentDTO);
			return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
		}

		model.addAttribute("numericalorder", questionOfAssessmentService.generateNumbericalOrder(assessmentid));
		model.addAttribute("error", invalid);
		model.addAttribute("questionInf", questionOfAssessmentDTO);
		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
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
			@PathVariable(name = "assessmentid") Long assessmentid, @ModelAttribute("questionid") Long questionId) {

		QuestionValidator invalid = questionValidator.validateQuestion(questionOfAssessmentDTO);
		int numericalOrder = questionOfAssessmentService.getOneQuestionOfAssessment(questionId).getNumericalorder();

		if (invalid.noError()) {
			questionOfAssessmentDTO.setNumericalorder(numericalOrder);
			questionOfAssessmentService.editQuestionOfAssessment(questionOfAssessmentDTO);
			return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
		}

		model.addAttribute("numericalorder", numericalOrder);
		model.addAttribute("error", invalid);
		model.addAttribute("questionInf", questionOfAssessmentDTO);
		model.addAttribute("listAssessment", assessmentService.getListAssessment());
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());
		model.addAttribute("url", "/teacher/questionOfAssessment/saveEditQuestionOfAssessment/" + assessmentid);
		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
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

	private final String PREFIX_TEACHER = "/teacher/questionOfAssessment/";
	private final String PREFIX_STUDENT = "/student/questionOfAssignment/";
}
