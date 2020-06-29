package com.codeenginestudio.elearning.dto;

public class StudentInClassDTO {

	private Long idrow;

	private Long classid;

	private Long studentid;

	public StudentInClassDTO() {
		super();
	}

	public StudentInClassDTO(Long idrow, Long classid, Long studentid) {
		super();
		this.idrow = idrow;
		this.classid = classid;
		this.studentid = studentid;
	}

	public Long getIdrow() {
		return idrow;
	}

	public void setIdrow(Long idrow) {
		this.idrow = idrow;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

}
