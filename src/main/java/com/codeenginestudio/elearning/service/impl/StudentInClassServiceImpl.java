package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.ClassDAO;
import com.codeenginestudio.elearning.dao.ResultDAO;
import com.codeenginestudio.elearning.dao.StudentInClassDAO;
import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;
import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.dto.ResultDTO;
import com.codeenginestudio.elearning.dto.StudentInClassDTO;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.service.StudentInClassService;
import com.codeenginestudio.elearning.util.ClassUtil;
import com.codeenginestudio.elearning.util.StudentInClassUtil;

@Service
public class StudentInClassServiceImpl implements StudentInClassService {

	@Autowired
	private StudentInClassDAO studentInClassDAO;

	@Autowired
	private ClassDAO classDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ResultService resultService;

	@Override
	public void saveStudentInClass(Long classid, Long userid) {
		StudentInClassEntity studentInClassEntity = new StudentInClassEntity();

		studentInClassEntity.setClassForeign(classDAO.getClassByClassid(classid));
		studentInClassEntity.setStudent(userDAO.getUserByUserid(userid));
		studentInClassDAO.save(studentInClassEntity);
	}

	@Override
	public List<Long> getListStudentByClassid(Long classid) {
		ClassDTO classDTO = ClassUtil.parseToDTO(classDAO.getClassByClassid(classid));
		// TODO: Why not query by classId
		List<StudentInClassEntity> studentInClassEntities = studentInClassDAO.findAll();
		List<Long> studentInClassDTOs = new ArrayList<>();

		for (StudentInClassEntity student : studentInClassEntities) {
			if (student.getClassForeign().getClassid() == classDTO.getClassid()) {
				studentInClassDTOs.add(student.getStudent().getUserid());
			}
		}
		return studentInClassDTOs;
	}

	@Override
	public List<StudentInClassDTO> getListStudentsByClassid(Long classid) {
		ClassDTO classDTO = ClassUtil.parseToDTO(classDAO.getClassByClassid(classid));
		// TODO: Why not query by classId
		List<StudentInClassEntity> studentInClassEntities = studentInClassDAO.findAll();
		List<StudentInClassDTO> studentInClassDTOs = new ArrayList<>();

		for (StudentInClassEntity student : studentInClassEntities) {
			if (student.getClassForeign().getClassid() == classDTO.getClassid()) {
				studentInClassDTOs.add(StudentInClassUtil.parseToDTO(student));
			}
		}
		return studentInClassDTOs;
	}
	
	@Override
	public void deleteStudentInClass(Long id) {
		studentInClassDAO.deleteById(id);
	}

	@Override
	public List<StudentInClassDTO> getAllStudentInClass() {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO.findAll();
		List<StudentInClassDTO> studentInClassDTO = new ArrayList<>();

		for (StudentInClassEntity student : studentInClassEntity) {
			studentInClassDTO.add(StudentInClassUtil.parseToDTO(student));
		}
		return studentInClassDTO;
	}

	@Override
	public Long findIdByValue(Long userid) {
		List<StudentInClassDTO> studentInClassDTO = getAllStudentInClass();
		for (StudentInClassDTO student : studentInClassDTO) {
			if (student.getStudent().getUserid().equals(userid)) {
				return student.getIdrow();
			}
		}
		return null;
	}

	@Override
	public void deleteAllByClass(Long classId) {

		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO
				.findByClassForeign(classDAO.getClassByClassid(classId));
		studentInClassDAO.deleteAll(studentInClassEntity);
	}

	@Override
	public List<Long> getClassIdByStudent(Long userid) {
		List<StudentInClassEntity> studentInClassEntity = studentInClassDAO
				.findByStudent(userDAO.getUserByUserid(userid));
		List<Long> listClass = new ArrayList<>();
		for (StudentInClassEntity student : studentInClassEntity) {
			listClass.add(student.getClassForeign().getClassid());
		}
		return listClass;
	}

	@Override
	public Float setScoreForStudent(Long assessmentId, Long studentId) {
		
		List<ResultDTO> listResult = resultService.findByAssessmentId(assessmentId);
		Float userScore = (float) 0;
		for (ResultDTO result : listResult) {
			if(studentId == result.getStudent().getUserid()) {
				userScore += result.getScore();
			}
		}
		return userScore;
	}
}
