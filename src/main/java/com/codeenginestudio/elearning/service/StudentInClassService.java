package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.dto.UserDTO;

public interface StudentInClassService {

	void saveStudentInClass(ClassDTO classId, UserDTO UserId);

	List<StudentInClassDTO> getListByClassid(Long classid);

}
