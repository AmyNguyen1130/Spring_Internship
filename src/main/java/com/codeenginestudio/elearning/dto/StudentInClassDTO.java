package com.codeenginestudio.elearning.dto;

public class StudentInClassDTO {

	private Long idRowStudentInClass;

	private Long classId;

	private Long studentId;

	public Long getIdRowStudentInClass() {
		return idRowStudentInClass;
	}

	public void setIdRowStudentInClass(Long idRowStudentInClass) {
		this.idRowStudentInClass = idRowStudentInClass;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

}
