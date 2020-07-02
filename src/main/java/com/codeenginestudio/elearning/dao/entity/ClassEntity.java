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
	private Long classid;

	@Column
	private String classname;

	@Column
	private Long teacherid;

	@Column
	private Boolean status;

	public ClassEntity() {

	}

	public ClassEntity(Long classid, String classname, Long teacherid, Boolean status) {
		super();
		this.classid = classid;
		this.classname = classname;
		this.teacherid = teacherid;
		this.status = status;
	}

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

}
