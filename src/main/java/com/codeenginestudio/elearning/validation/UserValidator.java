package com.codeenginestudio.elearning.validation;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;

public class UserValidator {

	private static final String BLANK = "";
	private static final String SPACE = " ";
	private static final String REGEX_EMAIL_FORMAT = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	private static String errUsername = BLANK;
	private static String errPassword = BLANK;
	private static String errFirstname = BLANK;
	private static String errLastname = BLANK;
	private static String errEmail = BLANK;

	public static String getErrUsername() {
		return errUsername;
	}

	public static void setErrUsername(String errUsername) {
		UserValidator.errUsername = errUsername;
	}

	public static String getErrPassword() {
		return errPassword;
	}

	public void setErrPassword(String errPassword) {
		UserValidator.errPassword = errPassword;
	}

	public static String getErrFirstname() {
		return errFirstname;
	}

	public static void setErrFirstname(String errFirstname) {
		UserValidator.errFirstname = errFirstname;
	}

	public static String getErrLastname() {
		return errLastname;
	}

	public void setErrLastname(String errLastname) {
		UserValidator.errLastname = errLastname;
	}

	public static String getErrEmail() {
		return errEmail;
	}

	public static void setErrEmail(String errEmail) {
		UserValidator.errEmail = errEmail;
	}

	public static String checkUsernameUnique(String username, UserService userService) {

		if (StringUtils.isEmpty(username)) {
	
			return "Username could not be null";
		} 
	
		int err = username.indexOf(SPACE);
	
		if (err >= 0) {
	
			return "Username could not contains the space";
		}
	
		if (!CollectionUtils.isEmpty(userService.findByUsername(username))) {
	
			return "Username is already exsits !";
		}

		return BLANK;
	}

	public static String checkEmailUnique(String email, UserService userService) {

		if (StringUtils.isEmpty(email)) {

			return "Email could not be null";

		} else if (!isValidEmail(email)) {

			return "Email is wrong format !";

		} else if (!CollectionUtils.isEmpty(userService.findByEmail(email))) {

			return "Email is already exsits !";
		}

		return BLANK;
	}

	public static String checkNull(String value, String error) {

		if (StringUtils.isEmpty(value)) {

			return error;
		}

		return BLANK;
	}

	public static boolean isValidEmail(String email) {

		return email.matches(REGEX_EMAIL_FORMAT);
	}

	public static void validateAddUser(UserDTO userDTO, UserService userService) {

		UserValidator.errUsername = checkUsernameUnique(userDTO.getUsername(), userService);
		UserValidator.errPassword = checkNull(userDTO.getPassword(), "Password could not be null");
		UserValidator.errFirstname = checkNull(userDTO.getFirstname(), "Firstname could not be null");
		UserValidator.errLastname = checkNull(userDTO.getLastname(), "Lastname could not be null");
		UserValidator.errEmail = checkEmailUnique(userDTO.getEmail(), userService);
	}

	public static void validateEditUser(UserDTO userDTO, UserService userService, long userId) {

		UserDTO originUser = userService.getUserByUserId(userId);

		if (!originUser.getUsername().equals(userDTO.getUsername())) {

			UserValidator.errUsername = checkUsernameUnique(userDTO.getUsername(), userService);
		}

		UserValidator.errPassword = checkNull(userDTO.getPassword(), "Password could not be null");
		UserValidator.errFirstname = checkNull(userDTO.getFirstname(), "Firstname could not be null");
		UserValidator.errLastname = checkNull(userDTO.getLastname(), "Lastname could not be null");

		if (!originUser.getEmail().equals(userDTO.getEmail())) {

			UserValidator.errEmail = checkEmailUnique(userDTO.getEmail(), userService);
		}
	}

	public static boolean noError() {

		return StringUtils.isEmpty(UserValidator.getErrUsername()) && StringUtils.isEmpty(UserValidator.getErrPassword())
				&& StringUtils.isEmpty(UserValidator.getErrFirstname()) && StringUtils.isEmpty(UserValidator.getErrLastname())
				&& StringUtils.isEmpty(UserValidator.getErrEmail());
	}
}