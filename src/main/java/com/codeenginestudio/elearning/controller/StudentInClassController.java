package com.codeenginestudio.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveStudentsInClass(RedirectAttributes redirectAttributes, ModelMap model,
			@ModelAttribute("classid") Long classid,
			@RequestParam(required = false, name = "checkSelected") List<Long> listCheckedId) {

		List<Long> listStudentIdInClass = studentInClassService.getListStudentByClassid(classid);
		if (listCheckedId != null) {

			for (Long userid : listCheckedId) {
				if (!checkDuplicateStudentInClass(userid, classid)) {
					studentInClassService.saveStudentInClass(classid, userid);
					redirectAttributes.addFlashAttribute("messageSuccess", "Assign Students to Class Successfully!!! ");
				}
			}

			for (Long check : listStudentIdInClass) {

				if (!listCheckedId.contains(check)) {
					Long id = studentInClassService.findIdByValue(check);
					studentInClassService.deleteStudentInClass(id);
					redirectAttributes.addFlashAttribute("messageSuccess", "Delete Students to Class Successfully!!! ");
				}
			}

		}
		if (listCheckedId == null) {
			studentInClassService.deleteAllByClass(classid);
			redirectAttributes.addFlashAttribute("messageSuccess", "Delete Students to Class Successfully!!! ");
		}
		return "redirect:/admin/class";
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

	public Boolean checkDuplicateStudentInClass(Long check, Long classid) {

		List<Long> list = studentInClassService.getListStudentByClassid(classid);
		if (list.contains(check)) {
			return true;
		}
		return false;
	}

	private static final String PREFIX = "/admin/studentInClass/";

}
