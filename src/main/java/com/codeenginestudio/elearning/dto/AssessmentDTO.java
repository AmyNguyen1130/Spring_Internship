package com.codeenginestudio.elearning.dto;

import java.sql.Date;

public class AssessmentDTO {

	private Long assessmentid;

	private String assessmentname;

	private ClassDTO classForeign;

	private Date startdate;

	private Date expireddate;

	private Boolean status;

	private int totalquestion;

	public AssessmentDTO() {
		super();
	}

	public AssessmentDTO(Long assessmentid, String assessmentname, Date startdate, Date expireddate, Boolean status,
			int totalquestion) {
		super();
		this.assessmentid = assessmentid;
		this.assessmentname = assessmentname;
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

	public ClassDTO getClassForeign() {
		return classForeign;
	}

	public void setClassForeign(ClassDTO classForeign) {
		this.classForeign = classForeign;
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

	public int getTotalquestion() {
		return totalquestion;
	}

	public void setTotalquestion(int totalquestion) {
		this.totalquestion = totalquestion;
	}

}
