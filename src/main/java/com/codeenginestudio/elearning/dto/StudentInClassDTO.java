package com.codeenginestudio.elearning.dto;

public class StudentInClassDTO {

	private Long idrow;

	private ClassDTO classForeign;

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

	public ClassDTO getClassForeign() {
		return classForeign;
	}

	public void setClassForeign(ClassDTO classForeign) {
		this.classForeign = classForeign;
	}

	public UserDTO getStudent() {
		return student;
	}

	public void setStudent(UserDTO student) {
		this.student = student;
	}

}
