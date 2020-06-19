package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class ClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;

	@Column
	private String className;

	@Column
	private int teacherId;

	public ClassEntity() {

	}

	public ClassEntity(int classId, String className, int teacherId) {
		this.classId = classId;
		this.className = className;
		this.teacherId = teacherId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}
