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
import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dao.entity.ResultEntity;
import com.codeenginestudio.elearning.dto.ResultDTO;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.ResultUtil;
import com.codeenginestudio.elearning.util.SecurityUtil;

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


	@Override
	public List<ResultDTO> findByStudentId(Long studentid) {
		
		List<ResultEntity> listResult = resultDAO.findByStudent(userDAO.getOne(studentid));
		List<ResultDTO> resultDTO = new ArrayList<>();
		for (ResultEntity result : listResult) {
			resultDTO.add(ResultUtil.parseToDTO(result));
		}
		return resultDTO;
	}

	public void saveSubmitLesson(ResultDTO lesson) {
		final LocalDate startDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();
		ResultEntity resultEntity = new ResultEntity();
		Float score = (float) 0;
		Long userId = SecurityUtil.getUserPrincipal().getUserid();

		resultEntity.setStudent(userDAO.getUserByUserid(userId));
		resultEntity.setQuestion(questionOfAssessmentDAO.getOne(lesson.getQuestion().getQuestionid()));
		resultEntity.setAssessment(assessmentDAO.getOne(lesson.getAssessment().getAssessmentid()));
		resultEntity.setAnswerchoice(lesson.getAnswerchoice());
		resultEntity.setScore(showScoreOfEachQuestion(lesson.getAnswerchoice(), lesson.getQuestion().getQuestionid(), score));
		resultEntity.setStartdate(startDate);
		resultEntity.setUpdatedate(updateDate);

		resultDAO.save(resultEntity);
		
	}
	
	public Float showScoreOfEachQuestion(String answerChoice, Long questionId, Float score) {

		QuestionOfAssessmentEntity question = questionOfAssessmentDAO.getOne(questionId);
		if (answerChoice.equals(question.getCorrectanswer())) {
			score = question.getScore();
		} else {
			score = (float) 0;
		}
		return score;

	}

	@Override
	public List<Long> getListAssessmentIdtByStudentId(Long studentid) {
		// TODO Auto-generated method stub
		return null;
	}

}
