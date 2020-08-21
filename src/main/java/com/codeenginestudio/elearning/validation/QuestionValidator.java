package com.codeenginestudio.elearning.validation;

import org.springframework.util.StringUtils;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

public class QuestionValidator {

	private String errContent = BLANK;
	private String errNumericalOrder = BLANK;
	private String errCorrectAnswer = BLANK;

	public String getErrContent() {
		return errContent;
	}

	public void setErrContent(String errContent) {
		this.errContent = errContent;
	}

	public String getErrNumericalOrder() {
		return errNumericalOrder;
	}

	public void setErrNumericalOrder(String errNumericalOrder) {
		this.errNumericalOrder = errNumericalOrder;
	}

	public String getErrCorrectAnswer() {
		return errCorrectAnswer;
	}

	public void setErrCorrectAnswer(String errCorrectAnswer) {
		this.errCorrectAnswer = errCorrectAnswer;
	}

	public boolean noError() {

		return StringUtils.isEmpty(this.getErrContent()) && StringUtils.isEmpty(this.getErrCorrectAnswer())
				&& StringUtils.isEmpty(this.getErrNumericalOrder());
	}

	public static String checkNull(String value, String error) {

		if (StringUtils.isEmpty(value)) {
			return error;
		}

		return BLANK;
	}

	public static QuestionValidator validateQuestion(QuestionOfAssessmentDTO questionOfAssessmentDTO) {

		QuestionValidator inValid = new QuestionValidator();
		inValid.errContent = checkNull(questionOfAssessmentDTO.getContent(), "content-could-not-be-null");
		inValid.errNumericalOrder = checkNumericalOrder(questionOfAssessmentDTO.getNumericalorder());
		inValid.errCorrectAnswer = checkNull(questionOfAssessmentDTO.getCorrectanswer(),
				"correct-answer-could-not-be-null");

		return inValid;
	}

	public static boolean checkOnlyDigital(String data) {

		return data.matches(REGEX_DIGITAL_FORMAT);
	}

	public static String checkNumericalOrder(String numerical) {

		if (StringUtils.isEmpty(numerical)) {

			return "numerical-order-should-not-be-null";
		}

		if (!checkOnlyDigital(numerical)) {

			return "numerical-order-should-be-only-digital";
		}

		if (Integer.parseInt(numerical) <= 0) {

			return "numerical-order-should-be-more-than-0";
		}

		return BLANK;
	}

	private static final String BLANK = "";
	private static final String REGEX_DIGITAL_FORMAT = "\\p{Digit}+";
}