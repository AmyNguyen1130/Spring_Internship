package com.codeenginestudio.elearning.dto;

public class ClassDTO {

	private Long classid;

	private String classname;

	private Long teacherid;

	private int totalStudents;

	private Boolean status;

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Long getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

}
