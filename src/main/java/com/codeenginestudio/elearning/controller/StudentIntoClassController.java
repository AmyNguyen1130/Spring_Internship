package com.codeenginestudio.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class StudentIntoClassController {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentInClassService studentInClassService;

	@GetMapping("/admin/getTeacherAddToClass")
	public String getTeacherAddToClass(ModelMap model, @ModelAttribute("classId") Long classId) {

		model.addAttribute("classId", classId);
		model.addAttribute("listUser", userService.getListUser());

		return PREFIX + "addStudentIntoClass";
	}

	@PostMapping("/admin/saveTeacherAddToClass")
	public String saveTeacherAddToClass(ModelMap model, @ModelAttribute("classId") Long classId,
			@RequestParam("checkSelected") List<Long> listUserId) {

		if (listUserId != null) {
			for (Long userId : listUserId) {
				studentInClassService.saveTeachersToClass(classId, userId);
			}
		}
		model.addAttribute("data", studentInClassService.getAllStudentInClass());
		return PREFIX + "listStudentInClass";
	}

	private static final String PREFIX = "/admin/studentIntoClass/";

}
