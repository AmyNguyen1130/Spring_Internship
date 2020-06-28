package com.codeenginestudio.elearning.dto;

import java.util.Date;

public class UserDTO {

	private Long userid;

	private String username;

	private String password;

	private String firstname;

	private String lastname;

	private String email;

	private String gender;

	private Date dob;

	private boolean enabled;

	private String avartar;

	private String status;

	private int roleid;

	public UserDTO() {
	}

	public UserDTO(String username, String password, String firstName, String lastname, String email, String gender,
			Date dob, String avartar, int roleid, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstName;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.avartar = avartar;
		this.roleid = roleid;
		this.enabled = enabled;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAvartar() {
		return avartar;
	}

	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

}
