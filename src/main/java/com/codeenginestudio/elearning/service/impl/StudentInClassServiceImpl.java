package com.codeenginestudio.elearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.StudentInClassDAO;
import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;
import com.codeenginestudio.elearning.service.StudentInClassService;

@Service
public class StudentInClassServiceImpl implements StudentInClassService {

	@Autowired
	private StudentInClassDAO studentInClassDAO;

	@Override
	public List<StudentInClassEntity> getAllStudentInClass() {

		return studentInClassDAO.findAll();
	}

	@Override
	public void saveTeachersToClass(Long classId, Long userId) {
		StudentInClassEntity studentInClassEntity = new StudentInClassEntity();
		studentInClassEntity.setClassId(classId);
		studentInClassEntity.setStudentId(userId);
		studentInClassDAO.save(studentInClassEntity);

	}

}
