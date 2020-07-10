package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionOfAssessmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;

	@Column
	private int numericalorder;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "questiontypeid", referencedColumnName = "questiontypeid")
	private QuestionTypeEntity questionType;

	@Column
	private String content;

	@Column
	private String options;

	@Column
	private String correctanswer;

	@Column
	private float score;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "assessmentid", referencedColumnName = "assessmentid")
	private AssessmentEntity assessment;

	public QuestionOfAssessmentEntity(Long questionid, int numericalorder, QuestionTypeEntity questionType,
			String content, String options, String correctanswer, float score, AssessmentEntity assessment) {
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

	public QuestionTypeEntity getQuestiontypeid() {
		return questionType;
	}

	public void setQuestiontypeid(QuestionTypeEntity questionType) {
		this.questionType = questionType;
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

	public AssessmentEntity getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentEntity assessment) {
		this.assessment = assessment;
	}
}
