package com.codeenginestudio.elearning.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.codeenginestudio.elearning.constant.RoleConstant;
import com.codeenginestudio.elearning.dao.AssessmentDAO;
import com.codeenginestudio.elearning.dao.QuestionOfAssessmentDAO;
import com.codeenginestudio.elearning.dao.ResultDAO;
import com.codeenginestudio.elearning.dao.RoleDAO;
import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.AssessmentEntity;
import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dao.entity.ResultEntity;
import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.ResultDTO;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.ResultUtil;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.codeenginestudio.elearning.util.UserUtil;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private AssessmentDAO assessmentDAO;

	@Autowired
	private ResultDAO resultDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

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
				userDAO.getOne(userId));
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

	public void saveSubmitResult(ResultDTO result) {

		ResultEntity resultEntity = new ResultEntity();
		Long userId = SecurityUtil.getUserPrincipal().getUserid();

		QuestionOfAssessmentEntity question = questionOfAssessmentDAO.getOne(result.getQuestion().getQuestionid());

		resultEntity.setStudent(userDAO.getOne(userId));
		resultEntity.setQuestion(question);
		resultEntity.setAssessment(question.getAssessment());
		resultEntity.setAnswerchoice(result.getAnswerchoice());
		resultEntity
				.setScore(caculateScore(result.getAnswerchoice(), result.getQuestion().getQuestionid()));
		resultEntity.setStartdate(LocalDate.now());
		resultEntity.setUpdatedate(LocalDate.now());

		resultDAO.save(resultEntity);

	}

	@Override
	public void saveEditSubmitResult(ResultDTO result) {
		if (result.getId() == null) {
			saveSubmitResult(result);
		} else {
			ResultEntity resultEntity = resultDAO.getOne(result.getId());

			resultEntity.setAnswerchoice(result.getAnswerchoice());
			resultEntity.setScore(
					caculateScore(result.getAnswerchoice(), result.getQuestion().getQuestionid()));
			resultEntity.setUpdatedate(LocalDate.now());

			resultDAO.save(resultEntity);
		}
	}

	public Float caculateScore(String answerChoice, Long questionId) {
		Float score = (float) 0;
		QuestionOfAssessmentEntity question = questionOfAssessmentDAO.getOne(questionId);

		if (StringUtils.isEmpty(answerChoice) && answerChoice.equals(question.getCorrectanswer())) {
			score = question.getScore();
		}
		return score;
	}

	@Override
	public List<Long> getListAssessmentIdByStudentId(Long studentid) {

		List<Long> listIdOfAssessment = new ArrayList<>();
		List<ResultDTO> listResultDTOs = findByStudentId(studentid);

		for (ResultDTO resultDTO : listResultDTOs) {
			listIdOfAssessment.add(resultDTO.getAssessment().getAssessmentid());
		}

		return listIdOfAssessment;
	}

	@Override
	public List<UserDTO> getListStudentNotyetSubmitAssessment() {

		List<AssessmentEntity> listAssessments = assessmentDAO.findAll();
		List<UserEntity> listUsers = userDAO.findByRole(roleDAO.getRoleIdByRolename(RoleConstant.STUDENT));
		List<UserDTO> listUserDTOs = new ArrayList<>();

		for (AssessmentEntity assessment : listAssessments) {
			List<Long> listIdOfStudentDTOs = getListStudentIdtByAssessmentId(assessment.getAssessmentid());
			for (UserEntity user : listUsers) {
				if (!listIdOfStudentDTOs.contains(user.getUserid())) {
					listUserDTOs.add(UserUtil.parseToUserDTO(user));
				}
			}
		}

		return listUserDTOs;
	}

	@Override
	public void deleteResultByAssessmentId(Long assessmentid) {
		List<ResultEntity> listResults = resultDAO.findByAssessment(assessmentDAO.getOne(assessmentid));
		for (ResultEntity result : listResults) {
			resultDAO.delete(result);
		}
	}

	@Override
	public void deleteResultByQuestionId(Long questionId) {
		ResultEntity result = resultDAO.findByQuestion(questionOfAssessmentDAO.getOne(questionId));
		if (result != null) {
			resultDAO.delete(result);
		}
	}

	@Override
	public void deleteResultByStudent(Long studentId) {

		List<ResultEntity> results = resultDAO.findByStudent(userDAO.getOne(studentId));
		if (results.size() > 0) {

			for (ResultEntity result : results) {
				resultDAO.delete(result);
			}

		}
	}

}
