package com.codeenginestudio.elearning.validation;

import org.springframework.util.StringUtils;

import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

public class QuestionValidator {

	private String errContent = "";
	private String errOptions = "";
	private String errCorrectAnswer = "";
	public String getErrContent() {
		return errContent;
	}
	public void setErrContent(String errContent) {
		this.errContent = errContent;
	}
	public String getErrOptions() {
		return errOptions;
	}
	public void setErrOptions(String errOptions) {
		this.errOptions = errOptions;
	}
	public String getErrCorrectAnswer() {
		return errCorrectAnswer;
	}
	public void setErrCorrectAnswer(String errCorrectAnswer) {
		this.errCorrectAnswer = errCorrectAnswer;
	}
	
	String checkNull(String value, String error) {
		if (value == "") {
			return error;
		}
		return "";
	}
	
	public QuestionValidator validateQuestion(QuestionOfAssessmentDTO questionOfAssessmentDTO) {
		QuestionValidator inValid = new QuestionValidator();

		inValid.errContent = checkNull(questionOfAssessmentDTO.getContent(), "Content could not be null");
		inValid.errOptions = checkNull(questionOfAssessmentDTO.getOptions(), "Options could not be null");
		inValid.errCorrectAnswer = checkNull(questionOfAssessmentDTO.getCorrectanswer(), "Correct answer could not be null");

		return inValid;
	}

	
	public boolean noError() {
		return StringUtils.isEmpty(this.getErrContent()) && StringUtils.isEmpty(this.getErrOptions())
				&& StringUtils.isEmpty(this.getErrCorrectAnswer());
	}
}
