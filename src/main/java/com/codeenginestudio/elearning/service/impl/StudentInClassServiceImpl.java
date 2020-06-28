package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.StudentInClassDAO;
import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.service.StudentInClassService;
//import com.codeenginestudio.elearning.util.StudentInClassUtil;

@Service
public class StudentInClassServiceImpl implements StudentInClassService {

	@Autowired
	private StudentInClassDAO studentInClassDAO;

	@Override
	public List<StudentInClassDTO> getAllStudentInClass() {

		List<StudentInClassEntity> studentInClassEntity = (List<StudentInClassEntity>) studentInClassDAO.findAll();

		List<StudentInClassDTO> studentInClassDTO = new ArrayList<>();
		for (StudentInClassEntity word : studentInClassEntity) {
//			studentInClassDTO.add(StudentInClassUtil.parseToDTO(word));
		}
		return studentInClassDTO;
	}

	@Override
	public void saveTeachersToClass(Long classId, Long userId) {
		StudentInClassEntity studentInClassEntity = new StudentInClassEntity();
		studentInClassEntity.setClassId(classId);
		studentInClassEntity.setStudentId(userId);
		studentInClassDAO.save(studentInClassEntity);

	}

	@Override
	public void deleteStudentInClass(Long id) {
		studentInClassDAO.deleteById(id);
	}

}
