package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeenginestudio.elearning.dao.QuestionOfAssessmentDAO;
import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class QuestionOfAssessmentServiceImpl implements QuestionOfAssessmentService {

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssessmentDAO;

	@Override
	public List<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(AssessmentDTO assessment) {
		return finfQuestionByAssessment(assessment.getAssessmentid());
	}

	List<QuestionOfAssessmentDTO> finfQuestionByAssessment(Long assessmentid){
		List<QuestionOfAssessmentEntity> listQuestionEntity = questionOfAssessmentDAO.findAll();
		List<QuestionOfAssessmentDTO> listQuestionDTO = new ArrayList<>();
		for (QuestionOfAssessmentEntity questionOfAssessmentEntity : listQuestionEntity) {
			if (questionOfAssessmentEntity.getAssessment().getAssessmentid() == assessmentid) {
				listQuestionDTO
						.add(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentDTO(questionOfAssessmentEntity));
			}
		}

		return listQuestionDTO;
	}
	
	@Override
	public int generateNumbericalOrder(Long assessmentid) {

		return finfQuestionByAssessment(assessmentid).size() + 1;
	}

	@Override
	public void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO) throws JsonProcessingException {
		questionOfAssessmentDAO
				.saveAndFlush(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO));

	}

	@Override
	public void deleteQuestionOfAssessment(Long questionId) {
		questionOfAssessmentDAO.deleteById(questionId);

	}

	@Override
	public void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO) throws JsonProcessingException {
		questionOfAssessmentDAO
				.saveAndFlush(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO));
	}

	@Override
	public QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId) {

		return QuestionOfAssignmentUtil.parseToQuestionOfAssignmentDTO(questionOfAssessmentDAO.getOne(questionId));
	}
}
