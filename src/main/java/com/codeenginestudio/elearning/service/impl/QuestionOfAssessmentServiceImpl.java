package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeenginestudio.elearning.dao.QuestionOfAssessmentDAO;
import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.util.AssessmentUtil;
import com.codeenginestudio.elearning.util.OptionUtil;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;
import com.codeenginestudio.elearning.util.QuestionTypeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class QuestionOfAssessmentServiceImpl implements QuestionOfAssessmentService {

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssessmentDAO;

	@Override
	public List<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(Long assessmentid) {

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

		return getListQuestionOfAssessmentByAssessment(assessmentid).size() + 1;
	}

	@Override
	public void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO)
			throws JsonProcessingException {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = new QuestionOfAssessmentEntity();

		// TODO: use QuestionTypeDAO to get QuestionTypeEntity
		questionOfAssignmentEntity
				.setQuestiontype(QuestionTypeUtil.parseToQuestionTypeEntity(questionOfAssessmentDTO.getQuestionType()));
		questionOfAssignmentEntity.setNumericalorder(questionOfAssessmentDTO.getNumericalorder());
		questionOfAssignmentEntity.setContent(questionOfAssessmentDTO.getContent());
		questionOfAssignmentEntity.setScore(questionOfAssessmentDTO.getScore());
		// TODO: use AssessmentDAO to get AssessmentEntity
		questionOfAssignmentEntity.setAssessment(AssessmentUtil.parseToEntity(questionOfAssessmentDTO.getAssessment()));
		questionOfAssignmentEntity.setCorrectanswer(questionOfAssessmentDTO.getCorrectanswer());
		questionOfAssignmentEntity.setOptions(OptionUtil.parseToJson(questionOfAssessmentDTO.getOptions()));

		// TODO: Why 1 ?
		questionOfAssignmentEntity.setNumericalorder(1);
		questionOfAssessmentDAO.saveAndFlush(questionOfAssignmentEntity);
	}

	@Override
	public void deleteQuestionOfAssessment(Long questionId) {
		questionOfAssessmentDAO.deleteById(questionId);
	}

	@Override
	public void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO)
			throws JsonProcessingException {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = questionOfAssessmentDAO
				.getOne(questionOfAssessmentDTO.getQuestionid());

		// TODO: use QuestionTypeDAO to get QuestionTypeEntity
		questionOfAssignmentEntity
				.setQuestiontype(QuestionTypeUtil.parseToQuestionTypeEntity(questionOfAssessmentDTO.getQuestionType()));
		questionOfAssignmentEntity.setContent(questionOfAssessmentDTO.getContent());
		questionOfAssignmentEntity.setScore(questionOfAssessmentDTO.getScore());
		questionOfAssignmentEntity.setCorrectanswer(questionOfAssessmentDTO.getCorrectanswer());
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
