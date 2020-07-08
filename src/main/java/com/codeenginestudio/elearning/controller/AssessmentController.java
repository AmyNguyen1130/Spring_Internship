package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping("/teacher/assessment")
	public String showListAssessment(ModelMap model, @RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("assessmentPage", assessmentService.getPageListAssessment(page));
		return PREFIX + "listAssessment";
	}

	@GetMapping("/teacher/assessment/addAssessment")
	public String addAssessment(ModelMap model) {

		model.addAttribute("listClass", classService.getAllClass());
		return PREFIX + "addAssessment";
	}

	@GetMapping("/teacher/assessment/deleteAssessment")
	public String deleteAssessment(@ModelAttribute("assessmentid") Long assessmentid) {

		assessmentService.deleteById(assessmentid);
		return "redirect:/teacher/assessment";
	}

	@GetMapping("/teacher/class/editClassStatus")
	public String editStatusClass(@ModelAttribute("classid") Long classid) {
		classService.editStatusClass(classid);
		return "redirect:/teacher/class";
	}

	@GetMapping("/teacher/assessment/editAssessment")
	public String editAssessment(ModelMap model, @ModelAttribute("assessmentid") Long assessmentid) {
		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("assessmentEdit", assessmentService.showEditAssessment(assessmentid));
		return PREFIX + "editAssessment";
	}

	@GetMapping("/teacher/assessment/search")
	public String SearchByAssessmentName(ModelMap model, @ModelAttribute("inputSearch") String inputSearch,
			Integer page) {

		Page<AssessmentDTO> SearchResult = assessmentService.findAssessmentPageByAssessmentname(inputSearch, page);
		if (SearchResult.getTotalElements() == 0) {
			model.addAttribute("noResult", "Don't have any class with:  " + inputSearch);
			return PREFIX + "listAssessment";
		}
		model.addAttribute("listClass", classService.getAllClass());
		model.addAttribute("assessmentPage", SearchResult);
		return PREFIX + "listAssessment";
	}

	@PostMapping("/teacher/assessment/saveAddAssessment")
	public String saveAddAssessment(ModelMap model, AssessmentDTO assessmentDTO) {

		AssessmentValidation inValid = assessmentValidation.validateAddAssessment(assessmentDTO, assessmentService);
		if (inValid.getErrAssessmentName() == "" && inValid.getErrExpiredDate() == "") {
			assessmentService.saveAssessment(assessmentDTO);
			return "redirect:/teacher/assessment";
		} else {
			model.addAttribute("error", inValid);
			model.addAttribute("listClass", classService.getAllClass());
			return PREFIX + "addAssessment";
		}
	}

	@PostMapping("/teacher/assessment/saveEditAssessment")
	public String saveEditAssessment(ModelMap model, AssessmentDTO assessmentDTO) {

		AssessmentValidation inValid = assessmentValidation.validateAddAssessment(assessmentDTO, assessmentService);
		if (inValid.getErrAssessmentName() == "" && inValid.getErrExpiredDate() == "") {
			assessmentService.saveAssessment(assessmentDTO);
			return "redirect:/teacher/assessment";
		} else {
			model.addAttribute("error", inValid);
			model.addAttribute("listClass", classService.getAllClass());
			model.addAttribute("assessmentEdit", assessmentService.showEditAssessment(assessmentDTO.getAssessmentid()));
			return PREFIX + "editAssessment";
		}
	}

	private static final String PREFIX = "/teacher/assessment/";
}
