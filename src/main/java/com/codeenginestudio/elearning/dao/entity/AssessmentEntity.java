package com.codeenginestudio.elearning.dao.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assessments")
public class AssessmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assessmentid;

	@Column
	private String assessmentname;

	@Column
	private Long classid;

	@Column
	private Date startdate;

	@Column
	private Date expireddate;

	@Column
	private String status;

	@Column
	private int totalquestion;

	public AssessmentEntity() {
		super();
	}

	public AssessmentEntity(Long assessmentid, String assessmentname, Long classid, Date startdate, Date expireddate,
			String status, int totalquestion) {
		super();
		this.assessmentid = assessmentid;
		this.assessmentname = assessmentname;
		this.classid = classid;
		this.startdate = startdate;
		this.expireddate = expireddate;
		this.status = status;
		this.totalquestion = totalquestion;
	}

	public Long getAssessmentid() {
		return assessmentid;
	}

	public void setAssessmentid(Long assessmentid) {
		this.assessmentid = assessmentid;
	}

	public String getAssessmentname() {
		return assessmentname;
	}

	public void setAssessmentname(String assessmentname) {
		this.assessmentname = assessmentname;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalquestion() {
		return totalquestion;
	}

	public void setTotalquestion(int totalquestion) {
		this.totalquestion = totalquestion;
	}

}
