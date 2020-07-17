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
import com.codeenginestudio.elearning.util.OptionUtil;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class QuestionOfAssessmentServiceImpl implements QuestionOfAssessmentService {

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssessmentDAO;

	@Override
	public List<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(AssessmentDTO assessment) {
		return findQuestionByAssessment(assessment.getAssessmentid());
	}

	private List<QuestionOfAssessmentDTO> findQuestionByAssessment(Long assessmentid) {

		List<QuestionOfAssessmentEntity> listQuestionEntities = questionOfAssessmentDAO.findAll();
		List<QuestionOfAssessmentDTO> listQuestionDTOs = new ArrayList<>();
		QuestionOfAssessmentDTO questionOfAssignmentDTO = new QuestionOfAssessmentDTO();

		for (QuestionOfAssessmentEntity questionOfAssessmentEntity : listQuestionEntities) {
			if (questionOfAssessmentEntity.getAssessment().getAssessmentid() == assessmentid) {

				questionOfAssignmentDTO = QuestionOfAssignmentUtil
						.parseToQuestionOfAssignmentDTO(questionOfAssessmentEntity);
				questionOfAssignmentDTO.setOptions(OptionUtil.parseToObject(questionOfAssessmentEntity.getOptions()));
				listQuestionDTOs.add(questionOfAssignmentDTO);
			}
		}

		return listQuestionDTOs;
	}

	@Override
	public int generateNumericalOrder(Long assessmentid) {

		return findQuestionByAssessment(assessmentid).size() + 1;
	}

	@Override
	public void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO)
			throws JsonProcessingException {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = QuestionOfAssignmentUtil
				.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO);
		questionOfAssignmentEntity.setOptions(OptionUtil.parseToJson(questionOfAssessmentDTO.getOptions()));

		questionOfAssessmentDAO.saveAndFlush(questionOfAssignmentEntity);
	}

	@Override
	public void deleteQuestionOfAssessment(Long questionId) {
		questionOfAssessmentDAO.deleteById(questionId);

	}

	@Override
	public void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO)
			throws JsonProcessingException {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = QuestionOfAssignmentUtil
				.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO);
		questionOfAssignmentEntity.setOptions(OptionUtil.parseToJson(questionOfAssessmentDTO.getOptions()));
		questionOfAssessmentDAO.saveAndFlush(questionOfAssignmentEntity);
	}

	@Override
	public QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId) {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = questionOfAssessmentDAO.getOne(questionId);
		QuestionOfAssessmentDTO questionOfAssignmentDTO = QuestionOfAssignmentUtil
				.parseToQuestionOfAssignmentDTO(questionOfAssignmentEntity);
		questionOfAssignmentDTO.setOptions(OptionUtil.parseToObject(questionOfAssignmentEntity.getOptions()));

		return questionOfAssignmentDTO;
	}
}
