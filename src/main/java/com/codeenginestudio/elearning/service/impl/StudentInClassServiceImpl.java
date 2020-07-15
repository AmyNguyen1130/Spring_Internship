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
		studentInClassEntity.setClassForeign(ClassUtil.parseToEntity(classid));
		studentInClassEntity.setStudent(UserUtil.parseToUserEntity(userid));
		studentInClassDAO.save(studentInClassEntity);

	}

	@Override
	public List<Long> getListStudentByClassid(ClassDTO classDTO) {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findAll();
		List<Long> studentInClassDTO = new ArrayList<>();

		for (StudentInClassEntity word : studentInClassEntity) {
			if (word.getClassForeign().getClassid() == classDTO.getClassid()) {
				studentInClassDTO.add(word.getStudent().getUserid());
			}
		}
		return studentInClassDTO;
	}

	@Override
	public void deleteStudentInClass(Long id) {
		studentInClassDAO.deleteById(id);
	}

	@Override
	public List<StudentInClassDTO> getAllStudentInClass() {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findAll();
		List<StudentInClassDTO> studentInClassDTO = new ArrayList<>();

		for (StudentInClassEntity word : studentInClassEntity) {
			studentInClassDTO.add(StudentInClassUtil.parseToDTO(word));
		}
		return studentInClassDTO;
	}

	@Override
	public Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long userid) {

		for (StudentInClassDTO student : studentInClassDTO) {
			if (student.getStudent().getUserid().equals(userid)) {
				return student.getIdrow();
			}
		}
		return null;

	}

	@Override
	public void deleteAllByClass(ClassDTO classDTO) {

		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findByClassForeign(ClassUtil.parseToEntity(classDTO));
		studentInClassDAO.deleteAll(studentInClassEntity);

	}

	@Override
	public List<Long> getClassIdByStudentname(UserDTO userDTO) {

		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findByStudent(UserUtil.parseToUserEntity(userDTO));
		List<Long> listClass = new ArrayList<>();

		for (StudentInClassEntity word : studentInClassEntity) {
			listClass.add(word.getClassForeign().getClassid());
		}
		return listClass;
	}

}
