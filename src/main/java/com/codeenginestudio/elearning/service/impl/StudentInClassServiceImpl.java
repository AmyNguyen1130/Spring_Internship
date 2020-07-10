package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.StudentInClassDAO;
import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;
import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.util.ClassUtil;
import com.codeenginestudio.elearning.util.StudentInClassUtil;
import com.codeenginestudio.elearning.util.UserUtil;

@Service
public class StudentInClassServiceImpl implements StudentInClassService {

	@Autowired
	private StudentInClassDAO studentInClassDAO;

	@Override
	public void saveStudentInClass(ClassDTO classid, UserDTO userid) {
		StudentInClassEntity studentInClassEntity = new StudentInClassEntity();
		studentInClassEntity.setClassid(ClassUtil.parseToEntity(classid));
		studentInClassEntity.setStudent(UserUtil.parseToUserEntity(userid));
		studentInClassDAO.save(studentInClassEntity);

	}

	public List<Long> listStudentByClassid(ClassDTO classDTO) {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findAll();

		List<Long> listChecked = new ArrayList<>();

		for (StudentInClassEntity word : studentInClassEntity) {
			if (classDTO.getClassid() == word.getClassid().getClassid()) {
				listChecked.add(word.getClassid().getClassid());
			}

		}
		return listChecked;
	}

	@Override
	public List<StudentInClassDTO> getListByClassid(Long classid) {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.getListByClassid(classid);

		List<StudentInClassDTO> studentInClassDTO = new ArrayList<>();
		for (StudentInClassEntity word : studentInClassEntity) {

			studentInClassDTO.add(StudentInClassUtil.parseToDTO(word));
		}
		return studentInClassDTO;
	}

}
