package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;

	@Column
	private String content;

	@Column
	private String answer;

	@Column
	private Long assessmentid;

	public QuestionEntity() {
		super();
	}

	public QuestionEntity(Long questionid, String content, String answer, Long assessmentid) {
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
