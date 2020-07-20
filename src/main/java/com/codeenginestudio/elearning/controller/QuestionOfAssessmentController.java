package com.codeenginestudio.elearning.controller;

import java.util.Map;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.service.QuestionTypeService;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.codeenginestudio.elearning.validation.QuestionValidator;
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
			@PathVariable(name = "assessmentid") Long assessmentid, @ModelAttribute("questionid") Long questionId,
			RedirectAttributes redirectAttributes) throws JsonProcessingException {

		int numericalOrder = questionOfAssessmentService.getOneQuestionOfAssessment(questionId).getNumericalorder();
		questionOfAssessmentDTO.setNumericalorder(numericalOrder);
		questionOfAssessmentService.editQuestionOfAssessment(questionOfAssessmentDTO);
		redirectAttributes.addAttribute("msgSuccess", "");
		return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
	}

	// Student role

	@GetMapping("/student/questionOfAssessment/{assessmentid}")
	public String viewListQuestion(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		AssessmentDTO assessment = assessmentService.getAssessmentByAssessmentid(assessmentid);

		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessment));
		model.addAttribute("assessment", assessment);

		model.addAttribute("url", "/student/submitAssessment/" + assessmentid);
		return PREFIX_STUDENT + "listQuestionOfAssignment";
	}

	@GetMapping("/student/editSubmitAssessment/{assessmentid}")
	public String editAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();

		model.addAttribute("url", "/student/saveEditSubmitAssessment/" + assessmentid);

		AssessmentDTO assessment = assessmentService.getAssessmentByAssessmentid(assessmentid);

		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessment));

		model.addAttribute("assessment", assessment);

		model.addAttribute("listSubmitEdit", resultService.findByAssessmentAndStudent(assessmentid, userId));

		return PREFIX_STUDENT + "listQuestionOfAssignment";
	}

	@PostMapping("student/submitAssessment/{assessmentid}")
	public String submitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid,
			@RequestParam Map<String, String> allParams) throws JsonProcessingException {

		if (allParams != null) {
			Long userId = SecurityUtil.getUserPrincipal().getUserid();
			Long questionId = 0L;
			String answerChoice = "";
			final LocalDate currentDate = LocalDate.now();
			LocalDate updateDate = LocalDate.now();

			for (Map.Entry<String, String> answer : allParams.entrySet()) {
				if (!answer.getKey().equals("id")) {
					questionId = Long.parseLong(answer.getKey());

					String[] StrValue = answer.getValue().split("_", 2);

					answerChoice = StrValue[0];
					if (!resultService.checkDuplicateQuestionInAssessment(assessmentid, userId, questionId)) {
						resultService.saveSubmitAssessment(userId, assessmentid, questionId, answerChoice, currentDate,
								updateDate);
					} else {
						System.out.println("hello");
					}
				}
			}
		}
		if (allParams == null) {
			model.addAttribute("errors", "Errors");
			return PREFIX_STUDENT + "listQuestionOfAssignment";
		}
		return "redirect:/student/assessment";
	}

	@PostMapping("student/saveEditSubmitAssessment/{assessmentid}")
	public String editSubmitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid,
			@RequestParam Map<String, String> allParams) throws JsonProcessingException {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();

		Long questionId = 0L;
		String answerChoice = "";
		Long idEdit = 0L;
		final LocalDate currentDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();

		for (Map.Entry<String, String> answer : allParams.entrySet()) {

			if (!answer.getKey().equals("id")) {
				questionId = Long.parseLong(answer.getKey());
				answerChoice = answer.getValue();
				String[] StrValue = answer.getValue().split("_", 2);

				answerChoice = StrValue[0];
				idEdit = Long.parseLong(StrValue[1]);
			}
			resultService.saveEditSubmitAssessment(idEdit, userId, assessmentid, questionId, answerChoice, currentDate,
					updateDate);
		}
		return "redirect:/student/assessment";
	}

	private final String PREFIX_TEACHER = "/teacher/questionOfAssessment/";
	private final String PREFIX_STUDENT = "/student/questionOfAssignment/";
}
