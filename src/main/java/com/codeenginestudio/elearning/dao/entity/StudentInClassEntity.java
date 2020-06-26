package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_student")
public class StudentInClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRowStudentInClass;
	
	@Column
	private Long classId;

	@Column
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

	public StudentInClassEntity(Long idRowStudentInClass, Long classId, Long studentId) {
		super();
		this.idRowStudentInClass = idRowStudentInClass;
		this.classId = classId;
		this.studentId = studentId;
	}

	public StudentInClassEntity() {
		super();
	}


}
