package com.codeenginestudio.elearning.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.codeenginestudio.elearning.validation.AssessmentValidation;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private ClassService classService;

	@Autowired
	private ResultService resultService;

	@Autowired
	private StudentInClassService studentInClassService;

	@Autowired
	private QuestionOfAssessmentService questionOfAssessmentService;

	AssessmentValidation assessmentValidation = new AssessmentValidation();

	// Teacher role

	@GetMapping("/teacher/assessment")
	public String showListAssessment(Model model, @RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("listClass", classService.getAllClass());
		Page<AssessmentDTO> listAssessments = assessmentService.getPageListAssessment(page);
		for (AssessmentDTO assessmentDTO : listAssessments) {
			assessmentDTO.setTotalquestion(questionOfAssessmentService
					.getListQuestionOfAssessmentByAssessment(assessmentDTO.getAssessmentid()).size());
		}
		model.addAttribute("assessmentPage", listAssessments);
		return PREFIX_TEACHER + "listAssessment";
	}

	@GetMapping("/teacher/assessment/addAssessment")
	public String addAssessment(Model model) {

		model.addAttribute("url", "/teacher/assessment/saveAddAssessment");
		model.addAttribute("listClass", classService.getAllClass());
		return PREFIX_TEACHER + "addAndEditAssessment";
	}

	@GetMapping("/teacher/assessment/deleteAssessment")
	public String deleteAssessment(@ModelAttribute("assessmentid") Long assessmentid,
			RedirectAttributes redirectAttributes) {
		assessmentService.deleteById(assessmentid);

		redirectAttributes.addFlashAttribute("messageSuccess", "Delete Assessment Successfully!!! ");
		return "redirect:/teacher/assessment";
	}

	@GetMapping("/teacher/assessment/editAssessmentStatus/{assessmentid}")
	public String editAssessmentStatus(@PathVariable(name = "assessmentid") Long assessmentid,
			RedirectAttributes redirectAttributes) {
		assessmentService.editAssessmentStatus(assessmentid);

		redirectAttributes.addFlashAttribute("messageSuccess", "Edit Status Successfully!!! ");
		return "redirect:/teacher/assessment";
	}

	@GetMapping("/teacher/assessment/editAssessment/{assessmentid}")
	public String editAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		model.addAttribute("url", "/teacher/assessment/saveEditAssessment");
		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("assessmentEdit", assessmentService.getAssessmentByAssessmentid(assessmentid));
		return PREFIX_TEACHER + "addAndEditAssessment";
	}

	@PostMapping("/teacher/assessment/saveAddAssessment")
	public String saveAddAssessment(Model model, AssessmentDTO assessmentDTO, RedirectAttributes redirectAttributes) {

		AssessmentValidation inValid = assessmentValidation.validateAddAssessment(assessmentDTO, assessmentService);

		if (inValid.getErrAssessmentName() == "" && inValid.getErrExpiredDate() == "") {
			assessmentService.saveAddAssessment(assessmentDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", "Add Assessment Successfully!!! ");
			return "redirect:/teacher/assessment";
		} else {
			model.addAttribute("error", inValid);
			model.addAttribute("listClass", classService.getAllClass());
			return PREFIX_TEACHER + "addAndEditAssessment";
		}
	}

	@PostMapping("/teacher/assessment/saveEditAssessment")
	public String saveEditAssessment(Model model, AssessmentDTO assessmentDTO, RedirectAttributes redirectAttributes) {

		AssessmentValidation inValid = assessmentValidation.validateAddAssessment(assessmentDTO, assessmentService);
		if (inValid.getErrAssessmentName() == "" && inValid.getErrExpiredDate() == "") {
			assessmentService.saveEditAssessment(assessmentDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", "Edit Assessment Successfully!!! ");
			return "redirect:/teacher/assessment";
		} else {
			model.addAttribute("error", inValid);
			model.addAttribute("listClass", classService.getAllClass());
			model.addAttribute("assessmentEdit",
					assessmentService.getAssessmentByAssessmentid(assessmentDTO.getAssessmentid()));
			return PREFIX_TEACHER + "addAndEditAssessment";
		}
	}

	// Student role

	@GetMapping("/student/assessment")
	public String showListAssessmentWithStudentRole(Model model) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		List<Long> listClassid = studentInClassService.getClassIdByStudent(userId);

		List<AssessmentDTO> listAssessments = assessmentService.getListAssessmentByUnExpired(userId);
		for (AssessmentDTO assessmentDTO : listAssessments) {
			assessmentDTO.setTotalquestion(questionOfAssessmentService
					.getListQuestionOfAssessmentByAssessment(assessmentDTO.getAssessmentid()).size());

			assessmentDTO.setTotalscore(questionOfAssessmentService.getTotalScoreByAssessment(assessmentDTO.getAssessmentid()));

		}

		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("listClassAssigned", listClassid);
		model.addAttribute("assessmentPage", listAssessments);

		return PREFIX_STUDENT + "listAssessment";
	}

	@GetMapping("/student/addSubmitAssessment/{assessmentid}")
	public String addSubmitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
		model.addAttribute("assessment", assessmentService.getAssessmentByAssessmentid(assessmentid));
		model.addAttribute("listSubmitEdit", resultService.findByAssessmentAndStudent(assessmentid, userId));
		model.addAttribute("url", "/student/saveSubmitAssessment/" + assessmentid);

		return PREFIX_STUDENT + "assessmentForm";
	}

	@GetMapping("/student/editSubmitAssessment/{assessmentid}")
	public String editSubmitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		model.addAttribute("url", "/student/saveEditSubmitAssessment/" + assessmentid);
		model.addAttribute("listQuestionOfAssessment",
				questionOfAssessmentService.getListQuestionOfAssessmentByAssessment(assessmentid));
		model.addAttribute("assessment", assessmentService.getAssessmentByAssessmentid(assessmentid));
		model.addAttribute("listSubmitEdit", resultService.findByAssessmentAndStudent(assessmentid, userId));

		return PREFIX_STUDENT + "assessmentForm";
	}

	@PostMapping("student/saveSubmitAssessment/{assessmentid}")
	public String submitAssessment(Model model, @PathVariable(name = "assessmentid") Long assessmentid,
			@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes)
			throws JsonProcessingException {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		Long questionId = 0L;
		String answerChoice = "";
		final LocalDate startDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();
		Float score = (float) 0;

		if (allParams != null) {
			for (Map.Entry<String, String> answer : allParams.entrySet()) {

				questionId = Long.parseLong(answer.getKey());
				// TODO: why split in here
				String[] StrValue = answer.getValue().split("_", 2);
				answerChoice = StrValue[0];
				QuestionOfAssessmentDTO question = questionOfAssessmentService.getOneQuestionOfAssessment(questionId);
				if (answerChoice.equals(question.getCorrectanswer())) {
					score = question.getScore();
				} else {
					score = (float) 0;
				}

				resultService.saveSubmitAssessment(userId, assessmentid, questionId, answerChoice, score, startDate, updateDate);
			}
		}
		redirectAttributes.addFlashAttribute("messageSuccess", "Submit Assessment Successfully!!! ");
		return "redirect:/student/assessment";
	}

	@PostMapping("student/saveEditSubmitAssessment/{assessmentid}")
	public String editSubmitAssessment(Model model, @RequestParam Map<String, String> allParams,
			@PathVariable(name = "assessmentid") Long assessmentid, RedirectAttributes redirectAttributes)
			throws JsonProcessingException {

		Long idEdit = 0L;
		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		Long questionId = 0L;
		String answerChoice = "";
		final LocalDate startDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();
		Float score = (float) 0;

		for (Map.Entry<String, String> answer : allParams.entrySet()) {

			questionId = Long.parseLong(answer.getKey());
			String[] StrValue = answer.getValue().split("_", 2);
			answerChoice = StrValue[0];
			if (!StrValue[1].equals("")) {
				idEdit = Long.parseLong(StrValue[1]);
			} else {
				idEdit = 0L;
			}
			QuestionOfAssessmentDTO question = questionOfAssessmentService.getOneQuestionOfAssessment(questionId);
			if (answerChoice.equals(question.getCorrectanswer())) {
				score = question.getScore();
			} else {
				score = (float) 0;
			}

			resultService.saveEditSubmitAssessment(idEdit, userId, assessmentid, questionId, answerChoice, score,
					startDate, updateDate);
		}

		redirectAttributes.addFlashAttribute("messageSuccess", "Edit Assessment Successfully!!! ");
		return "redirect:/student/assessment";
	}

	@GetMapping("/student/assessment/history")
	public String showHistoryWithStudentRole(Model model) {

		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		List<Long> listClassid = studentInClassService.getClassIdByStudent(userId);

		List<AssessmentDTO> listAssessments = assessmentService.getListAssessmentByExpired(userId);

		for (AssessmentDTO assessmentDTO : listAssessments) {
			assessmentDTO.setTotalquestion(questionOfAssessmentService
					.getListQuestionOfAssessmentByAssessment(assessmentDTO.getAssessmentid()).size());

			assessmentDTO.setTotalscore(questionOfAssessmentService.getTotalScoreByAssessment(assessmentDTO.getAssessmentid()));
			assessmentDTO.setUserscore(resultService.getUserScoreByAssessment(assessmentDTO.getAssessmentid()));
		}
		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("listClassAssigned", listClassid);
		model.addAttribute("assessmentPage", listAssessments);

		return PREFIX_STUDENT + "history/listAssessmentExpired";
	}

	private static final String PREFIX_TEACHER = "/teacher/assessment/";
	private static final String PREFIX_STUDENT = "/student/assessment/";


}
