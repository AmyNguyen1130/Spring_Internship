package com.codeenginestudio.elearning.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

@Component
public class QuestionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return QuestionOfAssessmentDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		QuestionOfAssessmentDTO questionOfAssessmentDTO = (QuestionOfAssessmentDTO) target;

		if (questionOfAssessmentDTO.getContent().equals("")) {

			errors.rejectValue("content", "content-should-not-be-null");
		}

		if (questionOfAssessmentDTO.getOptions().equals("")) {

			errors.rejectValue("options", "options-should-not-be-null");
		}

		if (questionOfAssessmentDTO.getCorrectanswer().equals("")) {

			errors.rejectValue("correctAnswer", "correctAnswer-should-not-be-null");
		}
	}

}
