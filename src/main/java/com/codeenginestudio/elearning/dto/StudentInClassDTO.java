package com.codeenginestudio.elearning.dto;

public class StudentInClassDTO {

	private Long idrow;

	private ClassDTO classid;

	private UserDTO student;

	public StudentInClassDTO() {
		super();
	}

	public Long getIdrow() {
		return idrow;
	}

	public void setIdrow(Long idrow) {
		this.idrow = idrow;
	}

	public ClassDTO getClassid() {
		return classid;
	}

	public void setClassid(ClassDTO classid) {
		this.classid = classid;
	}

	public UserDTO getStudent() {
		return student;
	}

	public void setStudent(UserDTO student) {
		this.student = student;
	}

}
