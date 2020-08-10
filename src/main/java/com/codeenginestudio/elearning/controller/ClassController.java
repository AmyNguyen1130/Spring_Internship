package com.codeenginestudio.elearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeenginestudio.elearning.constant.RoleConstant;
import com.codeenginestudio.elearning.dto.ClassDTO;

import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.codeenginestudio.elearning.validation.ClassValidation;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;

	@Autowired
	private UserService userService;

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private StudentInClassService studentInClassService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/admin/class")
	public String showListClass(Model model, @RequestParam(name = "page", required = false) Integer page) {
		Page<ClassDTO> classess = classService.getClassPage(page);
		for (ClassDTO classDTO : classess) {
			classDTO.setTotalStudents(studentInClassService.getListStudenIdtByClassid(classDTO.getClassid()).size());
			classDTO.setTotalAssessments(assessmentService.getListAssessmentByClassid(classDTO.getClassid()).size());
			if (classDTO.getTotalAssessments() == 0 && classDTO.getTotalStudents() == 0) {
				classDTO.setIsDelete(true);
			}
		}
		model.addAttribute("classPage", classess);

		return PREFIX + "listClass";
	}

	@GetMapping("/admin/class/addClass")
	public String addClass(Model model) {
		model.addAttribute("url", "/admin/class/saveAddClass");
		model.addAttribute("users", userService.getUserByRoleAndStatus(RoleConstant.TEACHER, true));

		return PREFIX + "addAndEditClass";
	}

	@GetMapping("/admin/class/deleteClass")
	public String deleteClass(@ModelAttribute("classid") Long classId, RedirectAttributes redirectAttributes) {

		classService.deleteClass(classId);

		redirectAttributes.addFlashAttribute("messageSuccess",
				messageSource.getMessage("message-delete-class-success", null, LocaleContextHolder.getLocale()));
		return "redirect:/admin/class";
	}

	@GetMapping("/admin/class/editClass/{classid}")
	public String editClass(Model model, @PathVariable(name = "classid") Long classid) {

		model.addAttribute("url", "/admin/class/saveEditClass");
		model.addAttribute("editClass", classService.getClassByClassid(classid));
		model.addAttribute("users", userService.getUserByRoleAndStatus(RoleConstant.TEACHER, true));

		return PREFIX + "addAndEditClass";
	}

	@GetMapping("/admin/class/editClassStatus/{classid}")
	public String editStatusClass(@PathVariable(name = "classid") Long classid, RedirectAttributes redirectAttributes) {

		ClassDTO classDTO = classService.getClassByClassid(classid);
		List<Long> listUsers = userService.getUserIdByRoleAndStatus(RoleConstant.TEACHER, true);

		// if parents object disable users cannot change status of child object
		if (listUsers.contains(classDTO.getUser().getUserid())) {
			classService.editStatusClass(classid);
			redirectAttributes.addFlashAttribute("messageSuccess", messageSource.getMessage("message-edit-status-success", null, LocaleContextHolder.getLocale()));
		} else {
			redirectAttributes.addFlashAttribute("messageDanger", messageSource.getMessage("message-edit-status-unsuccess", null, LocaleContextHolder.getLocale()));
		}

		return "redirect:/admin/class";
	}

	@PostMapping("/admin/class/saveAddClass")
	public String saveAddClass(Model model, ClassDTO classDTO, RedirectAttributes redirectAttributes) {

		List<String> errors = validationClass(classDTO);
		if (errors.size() > 0) {
			model.addAttribute("url", "/admin/class/saveAddClass");
			model.addAttribute("errors", errors);
			model.addAttribute("users", userService.getUserByRoleAndStatus(RoleConstant.TEACHER, true));

			return PREFIX + "addAndEditClass";
		} else {
			classService.saveAddClass(classDTO);
			redirectAttributes.addFlashAttribute("messageSuccess",messageSource.getMessage("message-add-class-success", null, LocaleContextHolder.getLocale()));

		}

		return "redirect:/admin/class";
	}

	@PostMapping("/admin/class/saveEditClass")
	public String saveEditClass(Model model, ClassDTO classDTO, RedirectAttributes redirectAttributes) {

		List<String> errors = validationClass(classDTO);
		if (errors.size() > 0) {

			model.addAttribute("url", "/admin/class/saveEditClass");
			model.addAttribute("errors", errors);
			model.addAttribute("editClass", classService.getClassByClassid(classDTO.getClassid()));
			model.addAttribute("users", userService.getUserByRoleAndStatus(RoleConstant.TEACHER, true));

			return PREFIX + "addAndEditClass";
		} else {
			classService.saveEditClass(classDTO);
			redirectAttributes.addFlashAttribute("messageSuccess", messageSource.getMessage("message-edit-class-success", null, LocaleContextHolder.getLocale()));
		}

		return "redirect:/admin/class";
	}

	// Teacher role

	@GetMapping("/teacher/class")
	public String showListClassWithTeacherRole(Model model,
			@RequestParam(name = "page", required = false) Integer page) {

		Long teacherId = SecurityUtil.getUserPrincipal().getUserid();
		Page<ClassDTO> classess = classService.getClassPageByTeacherId(page, teacherId);
		for (ClassDTO classDTO : classess) {
			classDTO.setTotalStudents(studentInClassService.getListStudenIdtByClassid(classDTO.getClassid()).size());
		}

		model.addAttribute("listClassEnable", classService.getListIdByStatus(true));
		model.addAttribute("classPage", classess);

		return "teacher/class/listClass";
	}

	public List<String> validationClass(ClassDTO classDTO) {
		List<String> errors = new ArrayList<>();

		if (!ClassValidation.checkEmpty(classDTO.getClassname())) {
			errors.add(ClassValidation.errClassname);
		}
		if (ClassValidation.checkEmpty(classDTO.getClassname())) {
			if (!ClassValidation.checkClassnameExisted(classDTO.getClassid(), classDTO.getClassname(), classService)) {
				errors.add(ClassValidation.errClassname);
			}
		}
		return errors;
	}

	private static final String PREFIX = "/admin/class/";

}
