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
	private Long idrow;

	@Column
	private Long classid;

	@Column
	private Long studentid;

	public StudentInClassEntity() {
		super();
	}

	public StudentInClassEntity(Long idrow, Long classid, Long studentid) {
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
