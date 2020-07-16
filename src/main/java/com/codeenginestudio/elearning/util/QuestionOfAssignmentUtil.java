package com.codeenginestudio.elearning.util;

import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.fasterxml.jackson.core.JsonProcessingException;


public class QuestionOfAssignmentUtil {

	public static QuestionOfAssessmentDTO parseToQuestionOfAssignmentDTO(
			QuestionOfAssessmentEntity questionOfAssignmentEntity) {

		QuestionOfAssessmentDTO questionOfAssignmentDTO = new QuestionOfAssessmentDTO();
		
		questionOfAssignmentDTO.setQuestionid(questionOfAssignmentDTO.getQuestionid());
		questionOfAssignmentDTO.setQuestionType(QuestionTypeUtil.parseToQuestionTypeDTO( questionOfAssignmentEntity.getQuestiontype()));
		questionOfAssignmentDTO.setNumericalorder(questionOfAssignmentEntity.getNumericalorder());
		questionOfAssignmentDTO.setContent(questionOfAssignmentEntity.getContent());
		questionOfAssignmentDTO.setScore(questionOfAssignmentEntity.getScore());
		questionOfAssignmentDTO.setAssessment(AssessmentUtil.parseToDTO(questionOfAssignmentEntity.getAssessment()));
		questionOfAssignmentDTO.setCorrectanswer(questionOfAssignmentEntity.getCorrectanswer());
		questionOfAssignmentDTO.setOptions(OptionUtil.parseToObject(questionOfAssignmentEntity.getOptions()));

		return questionOfAssignmentDTO;
	}

	public static QuestionOfAssessmentEntity parseToQuestionOfAssignmentEntity(
			QuestionOfAssessmentDTO questionOfAssignmentDTO) throws JsonProcessingException {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = new QuestionOfAssessmentEntity();
		
		questionOfAssignmentEntity.setQuestionid(questionOfAssignmentDTO.getQuestionid());
		questionOfAssignmentEntity.setQuestiontype(QuestionTypeUtil.parseToQuestionTypeEntity( questionOfAssignmentDTO.getQuestionType()));
		questionOfAssignmentEntity.setNumericalorder(questionOfAssignmentDTO.getNumericalorder());
		questionOfAssignmentEntity.setContent(questionOfAssignmentDTO.getContent());
		questionOfAssignmentEntity.setScore(questionOfAssignmentDTO.getScore());
		questionOfAssignmentEntity.setAssessment(AssessmentUtil.parseToEntity(questionOfAssignmentDTO.getAssessment()));
		questionOfAssignmentEntity.setCorrectanswer(questionOfAssignmentDTO.getCorrectanswer());
		questionOfAssignmentEntity.setOptions(OptionUtil.parseToJson(questionOfAssignmentDTO.getOptions()));

		return questionOfAssignmentEntity;
	}
	
}
