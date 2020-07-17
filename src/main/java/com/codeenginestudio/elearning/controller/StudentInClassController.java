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
import com.codeenginestudio.elearning.service.RoleService;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class StudentInClassController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;


	@Autowired
	private StudentInClassService studentInClassService;

	// Admin role
	@GetMapping("/admin/getStudentInClass")
	public String getStudentInClass(ModelMap model, @ModelAttribute("classid") Long classid) {

		model.addAttribute("classid", classid);
		model.addAttribute("userPage",
				userService.getUserByRole(roleService.getRoleIdByRolename(RoleConstant.STUDENT)));
		model.addAttribute("studentChecked", studentInClassService.getListStudentByClassid(classid));

		return PREFIX + "addStudentInClass";
	}

	@PostMapping("/admin/saveStudentInClass")
	public String saveStudentsInClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(required = false, name = "checkSelected") List<Long> listCheckedId) {

		List<Long> listStudentIdInClass = studentInClassService.getListStudentByClassid(classid);
		if (listCheckedId != null) {

			for (Long userid : listCheckedId) {
				if (!checkDuplicateStudentInClass(userid, classid)) {
					studentInClassService.saveStudentInClass(classid, userid);
				}
			}

			for (Long check : listStudentIdInClass) {

				if (!listCheckedId.contains(check)) {
					Long id = studentInClassService.findIdByValue(studentInClassService.getAllStudentInClass(), check);
					studentInClassService.deleteStudentInClass(id);
				}
			}

		}
		if(listCheckedId == null) {
			studentInClassService.deleteAllByClass(classid);
		}
		return "redirect:/admin/class";
	}

	public Boolean checkDuplicateStudentInClass(Long check, Long classid) {

		List<Long> list = studentInClassService.getListStudentByClassid(classid);
		if (list.contains(check)) {
			return true;
		}
		return false;
	}

	// Teacher role
	@GetMapping("/teacher/getStudentInClass")
	public String getStudentInClassWithTeacherRole(ModelMap model, @ModelAttribute("classid") Long classid) {

		model.addAttribute("classid", classid);
		model.addAttribute("userPage",
				userService.getUserByRole(roleService.getRoleIdByRolename(RoleConstant.STUDENT)));
		model.addAttribute("studentChecked", studentInClassService.getListStudentByClassid(classid));

		return "/teacher/class/listStudentInClass";
	}

	private static final String PREFIX = "/admin/studentInClass/";

}
