package com.codeenginestudio.elearning.validation;

import org.springframework.util.CollectionUtils;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;

public class UserValidation {

	private String errUsername;
	private String errPassword = "";
	private String errFirstname = "";
	private String errLastname = "";
	private String errEmail = "";
	
	public String getErrUsername() {
		return errUsername;
	}

	public void setErrUsername(String errUsername) {
		this.errUsername = errUsername;
	}

	public String getErrPassword() {
		return errPassword;
	}

	public void setErrPassword(String errPassword) {
		this.errPassword = errPassword;
	}

	public String getErrFirstname() {
		return errFirstname;
	}

	public void setErrFirstname(String errFirstname) {
		this.errFirstname = errFirstname;
	}

	public String getErrLastname() {
		return errLastname;
	}

	public void setErrLastname(String errLastname) {
		this.errLastname = errLastname;
	}

	public String getErrEmail() {
		return errEmail;
	}

	public void setErrEmail(String errEmail) {
		this.errEmail = errEmail;
	}

	public String getUsernameErr() {
		return this.errUsername;
	}

	public UserValidation validateAddUser(UserDTO userDTO, UserService userService) {
		UserValidation inValid = new UserValidation();

		inValid.errUsername = checkUsernameUnique(userDTO.getUsername(), userService);

		if (userDTO.getPassword() == "") {
			inValid.errPassword = "Password could not be null";
		}

		if (userDTO.getFirstname() == "") {
			inValid.errFirstname = "Firstname could not be null";
		}

		if (userDTO.getLastname() == "") {
			inValid.errLastname = "Lastname could not be null";
		}

		inValid.errEmail = checkEmailUnique(userDTO.getEmail(), userService);

		return inValid;
	}

	String checkUsernameUnique(String username, UserService userService) {

		if (username == "") {
			return "Username could not be null";
		} else if (!CollectionUtils.isEmpty(userService.findByUsername(username))) {

			return "Username already exsits";
		}

		return "";
	}

	String checkEmailUnique(String email, UserService userService) {

		if (email == "") {
			return "Email could not be null";

		} else if (!isValidEmail(email)) {
			return "This email is wrong format";

		} else if (!CollectionUtils.isEmpty(userService.findByEmail(email))) {
			return "Email already exists !";
		}

		return "";
	}

	boolean isValidEmail(String email) {

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
//	@Override
//	public String toString() {
//		return "UserValidation ToString Method";
//	}

}
