package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.dto.UserDTO;

public interface StudentInClassService {

	void saveStudentInClass(ClassDTO classId, UserDTO UserId);

	void deleteStudentInClass(Long id);

	void deleteAllByClass(ClassDTO classDTO);

	Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long check);

	List<Long> getListStudentByClassid(ClassDTO classDTO);

	List<StudentInClassDTO> getAllStudentInClass();

	List<Long> getClassIdByStudentname(UserDTO userDTO);

}
