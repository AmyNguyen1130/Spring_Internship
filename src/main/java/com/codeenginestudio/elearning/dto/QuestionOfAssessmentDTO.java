package com.codeenginestudio.elearning.dto;

import java.util.List;

public class QuestionOfAssessmentDTO {

	private Long questionid;

	private int numericalorder;

	private QuestionTypeDTO questionType;

	private String content;

	private String[] optionName;
	
	private String[] optionValue;
	
	private List<OptionDTO> options;

	private String correctanswer;

	private float score;

	private AssessmentDTO assessment;

	public QuestionOfAssessmentDTO(Long questionid, int numericalorder, QuestionTypeDTO questionType, String content,
			List<OptionDTO> options, String correctanswer, float score, AssessmentDTO assessment) {
		super();
		this.questionid = questionid;
		this.numericalorder = numericalorder;
		this.questionType = questionType;
		this.content = content;
		this.options = options;
		this.correctanswer = correctanswer;
		this.score = score;
		this.assessment = assessment;
	}

	public QuestionOfAssessmentDTO() {
		super();
	}
	
	
	public String[] getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String[] optionValue) {
		this.optionValue = optionValue;
	}

	public String[] getOptionName() {
		return optionName;
	}

	public void setOptionName(String[] optionName) {
		this.optionName = optionName;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public int getNumericalorder() {
		return numericalorder;
	}

	public void setNumericalorder(int numericalorder) {
		this.numericalorder = numericalorder;
	}

	public QuestionTypeDTO getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionTypeDTO questionType) {
		this.questionType = questionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<OptionDTO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionDTO> options) {
		this.options = options;
	}

	public String getCorrectanswer() {
		return correctanswer;
	}

	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public AssessmentDTO getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentDTO assessment) {
		this.assessment = assessment;
	}
}
