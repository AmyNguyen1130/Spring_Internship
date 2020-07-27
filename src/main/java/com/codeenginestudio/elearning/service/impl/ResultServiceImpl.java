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
	private AssessmentDAO assessmentDAO;

	@Autowired
	private ResultDAO resultDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssessmentDAO;

	@Override
	public void saveSubmitAssessment(Long userId, Long assessmentid, Long questionId, String answerChoice, Float score)
			throws JsonProcessingException {

		final LocalDate startDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();
		ResultEntity resultEntity = new ResultEntity();

		resultEntity.setStudent(userDAO.getUserByUserid(userId));
		resultEntity.setQuestion(questionOfAssessmentDAO.getOne(questionId));
		resultEntity.setAssessment(assessmentDAO.getOne(assessmentid));
		resultEntity.setAnswerchoice(answerChoice);
		resultEntity.setScore(score);
		resultEntity.setStartdate(startDate);
		resultEntity.setUpdatedate(updateDate);
		resultDAO.save(resultEntity);
	}

	@Override
	public List<ResultDTO> findByAssessmentId(Long assessmentid) {
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
			String answerChoice, Float score) throws JsonProcessingException {

		LocalDate updateDate = LocalDate.now();

		if (idEdit == 0) {
			saveSubmitAssessment(userId, assessmentid, questionId, answerChoice, score);
		} else {
			ResultEntity resultEntity = resultDAO.getOne(idEdit);

			resultEntity.setQuestion(questionOfAssessmentDAO.getOne(questionId));
			resultEntity.setAnswerchoice(answerChoice);
			resultEntity.setScore(score);
			resultEntity.setUpdatedate(updateDate);
			resultDAO.save(resultEntity);
		}

	}

	@Override
	public Float getUserScoreByAssessment(Long assessmentid) {

		List<ResultDTO> listResult = findByAssessmentId(assessmentid);
		Float totalScore = (float) 0;
		for (ResultDTO result : listResult) {
			totalScore += result.getScore();
		}
		return totalScore;
	}

	@Override
	public List<Long> getListStudentIdtByAssessmentId(Long assessmentid) {

		List<Long> listIdOfStudent = new ArrayList<>();
		List<ResultDTO> listResultDTOs = findByAssessmentId(assessmentid);
		for (ResultDTO resultDTO : listResultDTOs) {
			listIdOfStudent.add(resultDTO.getStudent().getUserid());
		}
		return listIdOfStudent;

	}

}
