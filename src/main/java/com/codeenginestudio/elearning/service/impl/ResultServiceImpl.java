package com.codeenginestudio.elearning.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.AssessmentDAO;
import com.codeenginestudio.elearning.dao.QuestionOfAssessmentDAO;
import com.codeenginestudio.elearning.dao.ResultDAO;
import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.ResultEntity;
import com.codeenginestudio.elearning.dto.ResultDTO;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.ResultUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssessmentDAO;

	@Autowired
	private AssessmentDAO assessmentDAO;

	@Override
	public void saveSubmitAssessment(Long userId, Long assessmentid, Long questionId, String answerChoice,
			LocalDate currentDate, LocalDate updateDate) throws JsonProcessingException {

		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setStudent(userDAO.getUserByUserid(userId));
		resultEntity.setQuestion(questionOfAssessmentDAO.getOne(questionId));
		resultEntity.setAssessment(assessmentDAO.getOne(assessmentid));
		resultEntity.setAnswerChoice(answerChoice);
		resultEntity.setStartdate(currentDate);
		resultEntity.setUpdatedate(updateDate);
		resultDAO.save(resultEntity);
	}

	@Override
	public List<ResultDTO> getAssessmentByAssessmentId(Long assessmentid) {
		List<ResultEntity> listResult = resultDAO.findByAssessment(assessmentDAO.getOne(assessmentid));
		List<ResultDTO> resultDTO = new ArrayList<>();
		for (ResultEntity result : listResult) {
			resultDTO.add(ResultUtil.parseToDTO(result));
		}
		return resultDTO;
	}

	@Override
	public List<ResultDTO> findByAssessmentAndStudent(Long assessmentid, Long userId) {
		List<ResultEntity> listResult = resultDAO.findByAssessmentAndStudent(assessmentDAO.getOne(assessmentid),
				userDAO.getUserByUserid(userId));
		List<ResultDTO> resultDTO = new ArrayList<>();
		for (ResultEntity result : listResult) {
			resultDTO.add(ResultUtil.parseToDTO(result));
		}
		return resultDTO;
	}

	@Override
	public void saveEditSubmitAssessment(Long idEdit, Long userId, Long assessmentid, Long questionId,
			String answerChoice, LocalDate currentDate, LocalDate updateDate) throws JsonProcessingException {

		ResultEntity resultEntity = resultDAO.getOne(idEdit);
		// TODO: Do we need update student, question, assessment, startdate
		resultEntity.setStudent(userDAO.getUserByUserid(userId));
		resultEntity.setQuestion(questionOfAssessmentDAO.getOne(questionId));
		resultEntity.setAssessment(assessmentDAO.getOne(assessmentid));
		resultEntity.setAnswerChoice(answerChoice);
		resultEntity.setStartdate(currentDate);
		resultEntity.setUpdatedate(updateDate);
		resultDAO.save(resultEntity);

	}

	@Override
	public Boolean checkDuplicateQuestionInAssessment(Long assessmentId, Long studentId, Long questionCheck) {
		List<ResultDTO> listResult = findByAssessmentAndStudent(assessmentId, studentId);
		for (ResultDTO ResultDTO : listResult) {
			if (ResultDTO.getQuestion().getQuestionid() == questionCheck) {
				return true;
			}
		}
		return false;
	}
}
