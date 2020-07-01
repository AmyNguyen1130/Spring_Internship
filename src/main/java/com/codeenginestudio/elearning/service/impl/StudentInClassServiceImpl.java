package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.StudentInClassDAO;
import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.util.StudentInClassUtil;

import org.springframework.data.domain.Sort;

@Service
public class StudentInClassServiceImpl implements StudentInClassService {

	@Autowired
	private StudentInClassDAO studentInClassDAO;

	@Override
	public List<StudentInClassDTO> getAllStudentInClass() {

		List<StudentInClassEntity> studentInClassEntity = (List<StudentInClassEntity>) studentInClassDAO
				.findAll(Sort.by("studentid"));

		List<StudentInClassDTO> studentInClassDTO = new ArrayList<>();
		for (StudentInClassEntity word : studentInClassEntity) {
			studentInClassDTO.add(StudentInClassUtil.parseToDTO(word));
		}
		return studentInClassDTO;

	}

	@Override
	public void saveTeachersToClass(Long classid, Long userid) {

		StudentInClassEntity studentInClassEntity = new StudentInClassEntity();
		studentInClassEntity.setClassid(classid);
		studentInClassEntity.setStudentid(userid);
		studentInClassDAO.save(studentInClassEntity);

	}

	@Override
	public Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long userid) {

		for (StudentInClassDTO student : studentInClassDTO) {
			if (student.getStudentid().equals(userid)) {
				return student.getIdrow();
			}
		}
		return null;

	}

	@Override
	public void deleteByClassid(Long classid) {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findByClassid(classid);

		studentInClassDAO.deleteAll(studentInClassEntity);
	}

	@Override
	public List<StudentInClassDTO> getAllStudentInClassByClassid(Long classid) {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findByClassid(classid);

		List<StudentInClassDTO> studentInClassDTO = new ArrayList<>();
		for (StudentInClassEntity word : studentInClassEntity) {

			studentInClassDTO.add(StudentInClassUtil.parseToDTO(word));
		}
		return studentInClassDTO;
	}

	@Override
	public void deleteStudentInClass(Long id) {
		studentInClassDAO.deleteById(id);
		
	}

}
