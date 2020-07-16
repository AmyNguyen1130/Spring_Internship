package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class ResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "studentid", referencedColumnName = "userid")
	private UserEntity student;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "questionid", referencedColumnName = "questionid")
	private QuestionOfAssessmentEntity question;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "assessmentid", referencedColumnName = "assessmentid")
	private AssessmentEntity assessment;

	@Column
	private String answerChoice;

	public ResultEntity() {
		super();
	}

	public ResultEntity(UserEntity student, QuestionOfAssessmentEntity question, AssessmentEntity assessment,
			String answerChoice) {
		super();
		this.student = student;
		this.question = question;
		this.assessment = assessment;
		this.answerChoice = answerChoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getStudent() {
		return student;
	}

	public void setStudent(UserEntity student) {
		this.student = student;
	}

	public QuestionOfAssessmentEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionOfAssessmentEntity question) {
		this.question = question;
	}

	public AssessmentEntity getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentEntity assessment) {
		this.assessment = assessment;
	}

	public String getAnswerChoice() {
		return answerChoice;
	}

	public void setAnswerChoice(String answerChoice) {
		this.answerChoice = answerChoice;
	}

}
