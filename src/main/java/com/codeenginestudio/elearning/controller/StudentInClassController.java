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
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.service.ClassService;
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
	private ClassService classService;

	@Autowired
	private StudentInClassService studentInClassService;

	@GetMapping("/admin/getStudentInClass")
	public String getStudentInClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(name = "page", required = false) Integer page) {

		model.addAttribute("classid", classid);
		model.addAttribute("userPage",
				userService.getUserPageByRoleid(roleService.getUserIdByUsername(RoleConstant.STUDENT), page));

		return PREFIX + "addStudentInClass";
	}

	@PostMapping("/admin/saveStudentInClass")
	public String saveStudentsInClass(ModelMap model, @ModelAttribute("classid") Long classid,
			@RequestParam(required = false, name = "checkSelected") List<Long> listCheckedId) {

		if (listCheckedId != null) {

			for (Long userid : listCheckedId) {

				if (checkDuplicateInClass(classid, userid)) {

					studentInClassService.saveStudentInClass(classService.showClassByclassId(classid),
							userService.showUserByUserId(userid));
				} else {
					System.out.println("helllo");
				}
			}
		}
		return "redirect:/admin/class";
	}

	public Boolean checkDuplicateInClass(Long check, Long classid) {

		List<StudentInClassDTO> list = studentInClassService.getListByClassid(classid);
		for (StudentInClassDTO word : list) {
			if (word.getClassid().getClassid() == check) {
				return true;
			}
		}
		return false;
	}

	private static final String PREFIX = "/admin/studentInClass/";

}
