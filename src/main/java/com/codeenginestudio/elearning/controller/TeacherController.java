package com.codeenginestudio.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.constant.RoleConstant;
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class TeacherController {
	@Autowired
	private ClassService classService;

	@Autowired
	private UserService userService;

	@Autowired
	private StudentInClassService studentInClassService;

	@GetMapping("/teacher/class")
	public String showListClassWithTeacherRole(ModelMap model,
			@RequestParam(name = "page", required = false) Integer page) {

//		model.addAttribute("totalStudent",  studentInClassService.listStudentCheckedByClass(classid).size());
		model.addAttribute("classPage", classService.getClassPage(page));
		return "teacher/class/listClass";
	}

	@GetMapping("/teacher/getTeacherAddToClass")
	public String getTeacherInClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("userPage", userService.getUserPageByRoleid(RoleConstant.ROLE_STUDENT, page));
		model.addAttribute("studentChecked", studentInClassService.listStudentCheckedByClass(classid));

		return "teacher/class/listStudentInClass";
	}
}
