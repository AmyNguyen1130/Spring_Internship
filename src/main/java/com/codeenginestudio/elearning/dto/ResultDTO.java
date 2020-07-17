package com.codeenginestudio.elearning.dto;

import java.time.LocalDate;

public class ResultDTO {

	private Long id;

	private UserDTO student;

	private QuestionOfAssessmentDTO question;

	private AssessmentDTO assessment;

	private String answerchoice;

	private LocalDate startdate;

	private LocalDate updatedate;

	public ResultDTO() {
		super();
	}

	public ResultDTO(UserDTO student, QuestionOfAssessmentDTO question, AssessmentDTO assessment, String answerChoice) {
		super();
		this.student = student;
		this.question = question;
		this.assessment = assessment;
		this.answerchoice = answerChoice;
	}

	public UserDTO getStudent() {
		return student;
	}

	public void setStudent(UserDTO student) {
		this.student = student;
	}

	public QuestionOfAssessmentDTO getQuestion() {
		return question;
	}

	public void setQuestion(QuestionOfAssessmentDTO question) {
		this.question = question;
	}

	public AssessmentDTO getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentDTO assessment) {
		this.assessment = assessment;
	}

	public String getAnswerChoice() {
		return answerchoice;
	}

	public void setAnswerChoice(String answerChoice) {
		this.answerchoice = answerChoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}

}
