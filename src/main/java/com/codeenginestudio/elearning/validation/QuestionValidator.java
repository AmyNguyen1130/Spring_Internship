package com.codeenginestudio.elearning.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

public class QuestionValidator {

	private String errContent = "";
	private List<String> errOptions = new ArrayList<>();
	private String errCorrectAnswer = "";

	public String getErrContent() {
		return errContent;
	}

	public void setErrContent(String errContent) {
		this.errContent = errContent;
	}

	public List<String> getErrOptions() {
		return errOptions;
	}

	public void setErrOptions(List<String> errOptions) {
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

		for (int i = 0; i < questionOfAssessmentDTO.getOptions().size(); i++) {
			inValid.errOptions.add(i, checkNull(questionOfAssessmentDTO.getOptions().get(i).getOptionValue(),
					"Option could not be null"));
		}

		inValid.errCorrectAnswer = checkNull(questionOfAssessmentDTO.getCorrectanswer(),
				"Correct answer could not be null");

		return inValid;
	}

	public boolean noError() {

		boolean checkNotNullOption = true;

		for (int i = 0; i < this.getErrOptions().size(); i++) {
			if (!StringUtils.isEmpty(this.getErrOptions().get(i))) {
				checkNotNullOption = false;
				break;
			}
		}

		return StringUtils.isEmpty(this.getErrContent()) && StringUtils.isEmpty(this.getErrOptions())
				&& StringUtils.isEmpty(this.getErrCorrectAnswer()) && checkNotNullOption;
	}
}
