package com.codeenginestudio.elearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeenginestudio.elearning.constant.RoleConstant;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.service.UserService;

@Controller
public class StudentIntoClassController {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentInClassService studentInClassService;

	@GetMapping("/admin/getTeacherAddToClass")
	public String getTeacherAddToClass(ModelMap model, @ModelAttribute("classid") Long classid) {

		model.addAttribute("classid", classid);
		model.addAttribute("listUser", userService.getUsersByRoleid(RoleConstant.ROLE_STUDENT));
		model.addAttribute("studentChecked", listCheckId());

		return PREFIX + "addStudentIntoClass";
	}

	@GetMapping("/admin/deleteStudentInClass")
	public String deleteStudentInClass(ModelMap model, @ModelAttribute("idrow") Long id) {

		studentInClassService.deleteStudentInClass(id);
		model.addAttribute("data", studentInClassService.getAllStudentInClass());

		return PREFIX + "listStudentInClass";
	}

	@PostMapping("/admin/saveTeacherAddToClass")
	public String saveTeacherAddToClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(required=false, name="checkSelected") List<Long> listUserId) {

		if (listUserId != null) {
			for (Long userid : listUserId) {

				if (!listCheckId().contains(userid)) {
					studentInClassService.saveTeachersToClass(classid, userid);
				}
			}
			for (Long checkedId : listCheckId()) {

				if (!listUserId.contains(checkedId)) {
					Long id = studentInClassService.findIdByValue(studentInClassService.getAllStudentInClass(),
							checkedId);
					studentInClassService.deleteStudentInClass(id);
				}
			}
		}
		if (listUserId == null) {
			studentInClassService.deleteAll();
		}

		model.addAttribute("data", studentInClassService.getAllStudentInClass());
		return PREFIX + "listStudentInClass";
	}

	public List<Long> listCheckId() {
		List<StudentInClassDTO> listChecked = studentInClassService.getAllStudentInClass();
		List<Long> listCheckedId = new ArrayList<>();

		for (int i = 0; i < listChecked.size(); i++) {
			listCheckedId.add(listChecked.get(i).getStudentid());

		}
		return listCheckedId;
	}

	private static final String PREFIX = "/admin/studentIntoClass/";

}
