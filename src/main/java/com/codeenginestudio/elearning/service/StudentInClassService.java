package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.StudentInClassDTO;

public interface StudentInClassService {

	void saveTeachersToClass(Long classId, Long userId);

	List<StudentInClassDTO> getAllStudentInClass();

	void deleteStudentInClass(Long id);
}
