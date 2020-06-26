package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;

public interface StudentInClassService {

	void saveTeachersToClass(Long classId, Long userId);

	List<StudentInClassEntity> getAllStudentInClass();
}
