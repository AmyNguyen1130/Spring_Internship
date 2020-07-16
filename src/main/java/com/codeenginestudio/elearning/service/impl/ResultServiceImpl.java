package com.codeenginestudio.elearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.ResultDAO;
import com.codeenginestudio.elearning.dao.entity.ResultEntity;
import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.ResultService;
import com.codeenginestudio.elearning.util.AssessmentUtil;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;
import com.codeenginestudio.elearning.util.UserUtil;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDAO;

	@Override
	public void saveSubmitAssessment(UserDTO userDTO, AssessmentDTO assessmentDTO,
			QuestionOfAssessmentDTO questionOfAssignmentDTO, String answerChoice) {

		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setAnswerChoice(answerChoice);
		resultEntity.setAssessment(AssessmentUtil.parseToEntity(assessmentDTO));
		resultEntity.setQuestion(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssignmentDTO));
		resultEntity.setStudent(UserUtil.parseToUserEntity(userDTO));
		resultDAO.save(resultEntity);
	}

}
