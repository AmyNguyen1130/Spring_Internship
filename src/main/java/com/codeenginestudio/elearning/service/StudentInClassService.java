package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.StudentInClassDTO;

public interface StudentInClassService {

	void saveTeachersToClass(Long classid, Long userid);

	List<StudentInClassDTO> getAllStudentInClass();

	Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long userid);

	void deleteAll();

	void deleteStudentInClass(Long id);
}
