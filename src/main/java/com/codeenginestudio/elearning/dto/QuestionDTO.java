package com.codeenginestudio.elearning.dto;

public class QuestionDTO {

	private Long questionid;

	private String content;

	private String answer;

	private Long assessmentid;

	public QuestionDTO() {
		super();
	}

	public QuestionDTO(Long questionid, String content, String answer, Long assessmentid) {
		super();
		this.questionid = questionid;
		this.content = content;
		this.answer = answer;
		this.assessmentid = assessmentid;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getAssessmentid() {
		return assessmentid;
	}

	public void setAssessmentid(Long assessmentid) {
		this.assessmentid = assessmentid;
	}

}
