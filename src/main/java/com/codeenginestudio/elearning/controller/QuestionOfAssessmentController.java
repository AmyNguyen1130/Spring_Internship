package com.codeenginestudio.elearning.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.service.QuestionTypeService;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.codeenginestudio.elearning.validation.QuestionValidator;
import com.codeenginestudio.elearning.validation.SubmitAssessmentValidation;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class QuestionOfAssessmentController {

	@Autowired
	private QuestionOfAssessmentService questionOfAssessmentService;

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private ClassService classService;

	@Autowired
	private QuestionTypeService questionTypeService;

	@Autowired
	private ResultService resultService;

	QuestionValidator questionValidator = new QuestionValidator();

	// Teacher

	@GetMapping("/teacher/questionOfAssessment")
	public String getListQuestion(Model model, @ModelAttribute("assessmentid") Long assessmentid) {

		AssessmentDTO assessmentDTO = assessmentService.getAssessmentByAssessmentid(assessmentid);
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
		model.addAttribute("assessment", assessmentDTO);
		if(assessmentDTO.getClassForeign() == null) {
			model.addAttribute("classNull","Haven't assigned to any class yet");
		}else {
			model.addAttribute("class", classService.getClassByClassid(assessmentDTO.getClassForeign().getClassid()));
		}
		return PREFIX_TEACHER + "listQuestionOfAssessment";
	}

	@GetMapping("/teacher/questionOfAssessment/addQuestionOfAssessment/{assessmentid}")
	public String addQuestionOfAssignment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());

		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
	}

	@PostMapping("teacher/questionOfAssessment/saveAddQuestionOfAssessment/{assessmentid}")
	public String saveAddQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO, Model model,
			@PathVariable(name = "assessmentid") Long assessmentid, RedirectAttributes redirectAttributes) throws JsonProcessingException {

		QuestionValidator invalid = questionValidator.validateQuestion(questionOfAssessmentDTO);

		if (invalid.noError()) {
			questionOfAssessmentService.addQuestionOfAssessment(questionOfAssessmentDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", "Add question Successfully!!! ");
			return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
		}

		model.addAttribute("error", invalid);
		model.addAttribute("questionInf", questionOfAssessmentDTO);
		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());

		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";

	}

	@GetMapping("/teacher/questionOfAssessment/deleteQuestionOfAssessment/{assessmentid}/{questionId}")
	public String deleteQuestionOfAssessment(@PathVariable(name = "assessmentid") Long assessmentid,
			@PathVariable(name = "questionId") Long questionId, RedirectAttributes redirectAttributes) {

		questionOfAssessmentService.deleteQuestionOfAssessment(questionId);
		redirectAttributes.addFlashAttribute("messageSuccess", "Delete question Successfully!!! ");
		return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
	}

	@GetMapping("/teacher/questionOfAssessment/editQuestionOfAssessment/{assessmentid}/{questionId}")
	public String editQuestionOfAssessment(@PathVariable(name = "questionId") Long questionId,
			@PathVariable(name = "assessmentid") Long assessmentid, Model model) {

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

		QuestionValidator invalid = questionValidator.validateQuestion(questionOfAssessmentDTO);

		if (invalid.noError()) {
			questionOfAssessmentService.editQuestionOfAssessment(questionOfAssessmentDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", "Edit question Successfully!!! ");
			return "redirect:/teacher/questionOfAssessment?assessmentid=" + assessmentid;
		}

		model.addAttribute("error", invalid);
		model.addAttribute("questionInf", questionOfAssessmentDTO);
		model.addAttribute("assessmentid", assessmentid);
		model.addAttribute("url", "/teacher/questionOfAssessment/saveAddQuestionOfAssessment/" + assessmentid);
		model.addAttribute("listQuestionType", questionTypeService.getListQuestionType());

		return PREFIX_TEACHER + "addAndEditQuestionOfAssessment";
	}

	// Student role

	@GetMapping("/student/questionOfAssessment/{assessmentid}")
	public String viewListQuestion(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
		model.addAttribute("assessment", assessmentService.getAssessmentByAssessmentid(assessmentid));
		model.addAttribute("listSubmitEdit", resultService.findByAssessmentAndStudent(assessmentid, userId));
		model.addAttribute("url", "/student/submitAssessment/" + assessmentid);

		return PREFIX_STUDENT + "assessmentForm";
	}

	@GetMapping("/student/editSubmitAssessment/{assessmentid}")
	public String editSubmitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		model.addAttribute("url", "/student/saveEditSubmitAssessment/" + assessmentid);
		AssessmentDTO assessment = assessmentService.getAssessmentByAssessmentid(assessmentid);
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
		model.addAttribute("assessment", assessment);
		model.addAttribute("listSubmitEdit", resultService.findByAssessmentAndStudent(assessmentid, userId));

		return PREFIX_STUDENT + "assessmentForm";
	}

	@PostMapping("student/submitAssessment/{assessmentid}")
	public String submitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid,
			@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes)
			throws JsonProcessingException {

		List<String> errors = validationSubmitAssessment(allParams, assessmentid);
		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		Long questionId = 0L;
		String answerChoice = "";
		final LocalDate startDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();

		if (allParams != null) {
			for (Map.Entry<String, String> answer : allParams.entrySet()) {

				questionId = Long.parseLong(answer.getKey());
				String[] StrValue = answer.getValue().split("_", 2);
				answerChoice = StrValue[0];

				if (errors.size() > 0) {

					model.addAttribute("listQuestionOfAssessment",
							questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
					model.addAttribute("assessment", assessmentService.getAssessmentByAssessmentid(assessmentid));
					model.addAttribute("url", "/student/submitAssessment/" + assessmentid);
					model.addAttribute("errors", errors);

					return PREFIX_STUDENT + "assessmentForm";
				} else {
					resultService.saveSubmitAssessment(userId, assessmentid, questionId, answerChoice, startDate,
							updateDate);
					redirectAttributes.addFlashAttribute("messageSuccess", "Submit Assessment Successfully!!! ");
				}

			}
		}

		return "redirect:/student/assessment";
	}

	@PostMapping("student/saveEditSubmitAssessment/{assessmentid}")
	public String editSubmitAssessment(Model model, @RequestParam Map<String, String> allParams,
			@PathVariable(name = "assessmentid") Long assessmentid, RedirectAttributes redirectAttributes)
			throws JsonProcessingException {

		List<String> errors = validationSubmitAssessment(allParams, assessmentid);
		Long questionId = 0L;
		String answerChoice = "";
		Long idEdit = 0L;
		LocalDate updateDate = LocalDate.now();

		for (Map.Entry<String, String> answer : allParams.entrySet()) {

			questionId = Long.parseLong(answer.getKey());
			String[] StrValue = answer.getValue().split("_", 2);
			answerChoice = StrValue[0];
			idEdit = Long.parseLong(StrValue[1]);

			if (errors.size() > 0) {

				model.addAttribute("listQuestionOfAssessment",
						questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
				model.addAttribute("assessment", assessmentService.getAssessmentByAssessmentid(assessmentid));
				model.addAttribute("url", "/student/submitAssessment/" + assessmentid);
				model.addAttribute("errors", errors);

				return PREFIX_STUDENT + "assessmentForm";
			} else {
				resultService.saveEditSubmitAssessment(idEdit, questionId, answerChoice, updateDate);
				redirectAttributes.addFlashAttribute("messageSuccess", "Submit Assessment Successfully!!! ");
			}
		}
		return "redirect:/student/assessment";
	}

	public List<String> validationSubmitAssessment(Map<String, String> allParams, Long assessmentid) {
		List<String> errors = new ArrayList<>();

		if (!SubmitAssessmentValidation.checkQuantityQuestionSubmit(allParams, assessmentid,
				questionOfAssessmentService)) {
			errors.add(SubmitAssessmentValidation.errQuestion);
		}

		return errors;
	}

	private final String PREFIX_TEACHER = "/teacher/questionOfAssessment/";
	private final String PREFIX_STUDENT = "/student/questionOfAssignment/";
}
