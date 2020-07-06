package com.codeenginestudio.elearning.dto;

import java.sql.Date;

public class AssessmentDTO {

	private Long assessmentid;

	private String assessmentname;

	private Long classid;

	private Date startdate;

	private Date expireddate;

	private String status;

	private int totalquestion;

	public AssessmentDTO() {
		super();
	}

	public AssessmentDTO(Long assessmentid, String assessmentname, Long classid, Date startdate, Date expireddate,
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
