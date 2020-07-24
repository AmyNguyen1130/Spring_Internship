package com.codeenginestudio.elearning.dao.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

	@Lob
	@Column( length = 100000)
	private String questions;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "assessmentid", referencedColumnName = "assessmentid")
	private AssessmentEntity assessment;

	@Column
	private String answerchoice;

	@Column
	private LocalDate startdate;

	@Column
	private LocalDate updatedate;

	@Column
	private Float score;

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

	public ResultEntity() {
		super();
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

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public AssessmentEntity getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentEntity assessment) {
		this.assessment = assessment;
	}

	public String getAnswerchoice() {
		return answerchoice;
	}

	public void setAnswerchoice(String answerchoice) {
		this.answerchoice = answerchoice;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}
