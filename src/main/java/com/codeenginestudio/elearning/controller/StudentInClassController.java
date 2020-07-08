package com.codeenginestudio.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.constant.RoleConstant;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class StudentInClassController {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentInClassService studentInClassService;

	@GetMapping("/admin/getTeacherAddToClass")
	public String getTeacherAddToClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("classid", classid);
		model.addAttribute("userPage", userService.getUserPageByRoleid(RoleConstant.ROLE_STUDENT, page));
		model.addAttribute("studentChecked", studentInClassService.listStudentCheckedByClass(classid));

		return PREFIX + "addStudentIntoClass";
	}

	@GetMapping("/teacher/getTeacherInClass")
	public String getTeacherInClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("userPage", userService.getUserPageByRoleid(RoleConstant.ROLE_STUDENT, page));
		model.addAttribute("studentChecked", studentInClassService.listStudentCheckedByClass(classid));

		return "teacher/class/listStudentInClass";
	}

	@PostMapping("/admin/saveStudentsToClass")
	public String saveStudentsToClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(required = false, name = "checkSelected") List<Long> listUserId) {

		studentInClassService.deleteByClassid(classid);

		if (listUserId != null) {

			for (Long userid : listUserId) {

				studentInClassService.saveTeachersToClass(classid, userid);
			}
		}

		return "redirect:/admin/class";
	}

	private static final String PREFIX = "/admin/studentIntoClass/";

}
