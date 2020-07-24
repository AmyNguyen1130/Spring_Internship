package com.codeenginestudio.elearning.dto;

import java.time.LocalDate;
import java.util.List;

public class ResultDTO {

	private Long id;

	private UserDTO student;

	private List<QuestionOfAssessmentDTO> questions;

	private AssessmentDTO assessment;

	private String answerchoice;

	private LocalDate startdate;

	private LocalDate updatedate;

	private Float score;

	public ResultDTO() {
		super();
	}

	public UserDTO getStudent() {
		return student;
	}

	public void setStudent(UserDTO student) {
		this.student = student;
	}

	public List<QuestionOfAssessmentDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionOfAssessmentDTO> questions) {
		this.questions = questions;
	}

	public AssessmentDTO getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentDTO assessment) {
		this.assessment = assessment;
	}

	public String getAnswerchoice() {
		return answerchoice;
	}

	public void setAnswerchoice(String answerchoice) {
		this.answerchoice = answerchoice;
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

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}
