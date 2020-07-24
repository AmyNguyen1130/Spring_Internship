package com.codeenginestudio.elearning.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeenginestudio.elearning.dao.AssessmentDAO;
import com.codeenginestudio.elearning.dao.ResultDAO;
import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.ResultEntity;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.dto.ResultDTO;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;
import com.codeenginestudio.elearning.util.ResultUtil;
import com.codeenginestudio.elearning.util.SecurityUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AssessmentDAO assessmentDAO;

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
	public void saveSubmitAssessment(ResultDTO resultDTO) throws JsonProcessingException {
		ResultEntity resultEntity = new ResultEntity();
		Long userId = SecurityUtil.getUserPrincipal().getUserid();
		final LocalDate startDate = LocalDate.now();
		LocalDate updateDate = LocalDate.now();

		resultEntity.setStudent(userDAO.getUserByUserid(userId));
		resultEntity.setAssessment(assessmentDAO.getOne(resultDTO.getAssessment().getAssessmentid()));

		List<QuestionOfAssessmentDTO> questionOfAssessmentDTO = resultDTO.getQuestions();
		resultEntity.setQuestions(QuestionOfAssignmentUtil.parseToJson(questionOfAssessmentDTO));

		resultEntity.setStartdate(startDate);
		resultEntity.setUpdatedate(updateDate);

		resultDAO.save(resultEntity);

	}

	@Override
	public void saveEditSubmitAssessment(ResultDTO resultDTO) throws JsonProcessingException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultDTO findResultByAssessmentId(Long assessmentid) {
		ResultEntity result = resultDAO.getOneByAssessment(assessmentDAO.getOne(assessmentid));
		ResultDTO resultDTO = ResultUtil.parseToDTO(result);

		resultDTO.setQuestions(QuestionOfAssignmentUtil.parseToObject(result.getQuestions()));

		return resultDTO;
	}

}
