package com.codeenginestudio.elearning.util;

import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.util.general.UtilGeneral;

public class QuestionOfAssignmentUtil {

	public static QuestionOfAssessmentDTO parseToQuestionOfAssignmentDTO(
			QuestionOfAssessmentEntity questionOfAssignmentEntity) {

		QuestionOfAssessmentDTO questionOfAssignmentDTO = UtilGeneral.modelMapper.map(questionOfAssignmentEntity,
				QuestionOfAssessmentDTO.class);

		return questionOfAssignmentDTO;
	}

	public static QuestionOfAssessmentEntity parseToQuestionOfAssignmentEntity(
			QuestionOfAssessmentDTO questionOfAssignmentDTO) {

		QuestionOfAssessmentEntity questionOfAssignmentEntity = UtilGeneral.modelMapper.map(questionOfAssignmentDTO,
				QuestionOfAssessmentEntity.class);

		return questionOfAssignmentEntity;
	}

}
