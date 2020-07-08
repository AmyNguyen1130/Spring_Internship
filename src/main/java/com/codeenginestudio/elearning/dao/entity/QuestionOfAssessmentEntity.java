package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class QuestionOfAssessmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;

	@Column
	private int numericalorder;

	@Column
	private Long questiontypeid;

	@Column
	private String content;

	@Column
	private String options;

	@Column
	private String correctanswer;

	@Column
	private float score;
	
	@Column
	private Long assessmentid;

	public QuestionOfAssessmentEntity(Long questionid, int numericalorder, Long questiontypeid, String content,
			String options, String correctanswer, float score, Long assessmentid) {
		super();
		this.questionid = questionid;
		this.numericalorder = numericalorder;
		this.questiontypeid = questiontypeid;
		this.content = content;
		this.options = options;
		this.correctanswer = correctanswer;
		this.score = score;
		this.assessmentid = assessmentid;
	}

	public QuestionOfAssessmentEntity() {
		super();
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

	public Long getQuestiontypeid() {
		return questiontypeid;
	}

	public void setQuestiontypeid(Long questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
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

	public Long getAssessmentid() {
		return assessmentid;
	}

	public void setAssessmentid(Long assessmentid) {
		this.assessmentid = assessmentid;
	}
}
