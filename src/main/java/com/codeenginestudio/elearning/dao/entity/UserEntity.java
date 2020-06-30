package com.codeenginestudio.elearning.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String email;

	@Column
	private String gender;

	@Column
	private boolean enabled;

	@Column
	private String avartar;

	@Column
	private Long roleid;

	public UserEntity() {
		super();
	}

	public UserEntity(String username, String password, String firstname, String lastname, String email, String gender,
			String avartar, Long roleid, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getAvartar() {
		return avartar;
	}

	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
