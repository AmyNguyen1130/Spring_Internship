package com.codeenginestudio.elearning.dao.entity;

import java.sql.Date;

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
@Table(name = "assessments")
public class AssessmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assessmentid;

	@Column
	private String assessmentname;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "classid", referencedColumnName = "classid")
	private ClassEntity classForeign;

	@Column
	private Date startdate;

	@Column
	private Date expireddate;

	@Column
	private Boolean status;

	public AssessmentEntity() {
		super();
	}

	public AssessmentEntity(Long assessmentid, String assessmentname, Date startdate, Date expireddate,
			Boolean status) {
		super();
		this.assessmentid = assessmentid;
		this.assessmentname = assessmentname;
		this.startdate = startdate;
		this.expireddate = expireddate;
		this.status = status;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ClassEntity getClassForeign() {
		return classForeign;
	}

	public void setClassForeign(ClassEntity classForeign) {
		this.classForeign = classForeign;
	}

}
