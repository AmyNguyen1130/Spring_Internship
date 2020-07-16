package com.codeenginestudio.elearning.dto;

public class ResultDTO {

	private Long id;

	private UserDTO student;

	private QuestionOfAssessmentDTO question;

	private AssessmentDTO assessment;

	private String answerChoice;

	public ResultDTO() {
		super();
	}

	public ResultDTO(UserDTO student, QuestionOfAssessmentDTO question, AssessmentDTO assessment, String answerChoice) {
		super();
		this.student = student;
		this.question = question;
		this.assessment = assessment;
		this.answerChoice = answerChoice;
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
		return answerChoice;
	}

	public void setAnswerChoice(String answerChoice) {
		this.answerChoice = answerChoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
