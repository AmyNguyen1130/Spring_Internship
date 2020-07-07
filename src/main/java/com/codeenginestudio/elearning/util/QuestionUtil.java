package com.codeenginestudio.elearning.util;

import com.codeenginestudio.elearning.dao.entity.QuestionEntity;
import com.codeenginestudio.elearning.dto.QuestionDTO;
import com.codeenginestudio.elearning.util.general.UtilGeneral;

public class QuestionUtil {
	public static QuestionDTO parseToDTO(QuestionEntity questionEntity) {

		QuestionDTO questionDTO = UtilGeneral.modelMapper.map(questionEntity, QuestionDTO.class);

		return questionDTO;
	}

	public static QuestionEntity parseToEntity(QuestionDTO questionDTO) {

		QuestionEntity questionEntity = UtilGeneral.modelMapper.map(questionDTO, QuestionEntity.class);

		return questionEntity;
	}

}
