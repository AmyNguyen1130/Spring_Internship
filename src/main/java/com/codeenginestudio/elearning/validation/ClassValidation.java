package com.codeenginestudio.elearning.validation;

import java.util.List;

import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.service.ClassService;

public class ClassValidation {

	public static String errClassname = "";

	public static boolean checkEmpty(String classname) {
		if (classname == "") {
			errClassname = "class name could not be null";
			return false;
		}
		return true;
	}

	public static boolean checkClassnameExisted(Long classid, String classname, ClassService classService) {
		List<ClassDTO> listClass = classService.getAllClass();

		if (listClass.size() == 0) {
			return true;
		}
		if (listClass.size() != 0) {
			for (ClassDTO existed : listClass) {
				if (classname.equals(existed.getClassname())) {
					if (classid == existed.getClassid()) {
						return true;
					} else {
						errClassname = "class name already exists !";
						return false;
					}
				}
			}
		}

		return true;
	}
}
