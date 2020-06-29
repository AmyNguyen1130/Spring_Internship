package com.codeenginestudio.elearning.validation;

import java.util.List;

import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;

public class UserValidation {
	public static String errUsername = "";
	public static String errPassword = "";
	public static String errFirstname = "";
	public static String errLastname = "";
	public static String errEmail = "";
	
	private static UserService userService;
	
	public UserValidation() {
		super();
	}

	public static boolean validateAddUser(UserDTO userDTO) {
		if(!checkUsernameUnique(userDTO.getUsername())) {
			return false;
		}
		
		if(userDTO.getPassword() == "") {
			errPassword = "Password could not be null";
			return false;
		}
		
		if(userDTO.getFirstname() == "") {
			errFirstname = "Firstname could not be null";
			return false;	
		}
		
		if(userDTO.getLastname() == "") {
			errLastname = "Lastname could not be null";
			return false;	
		}
		
		if(!checkEmail(userDTO.getEmail())) {
			return false;	
		}
		
		return true;
	}
	
	static boolean checkUsernameUnique(String username) {
		if(username == "") {
			errUsername = "Username could not be null"; 
			return false;
		}else {
			List<UserDTO> listUser = userService.getListUser();
			for (UserDTO existedUser : listUser) {
				if(existedUser.getUsername() == username) {
					errUsername = "username already exists !";
					return false;
				};
			}
		}
		
		return true;
	}
	
	
	static boolean checkEmail(String email) {
		if(email == "") {
			errEmail = "Email could not be null";
			return false;
		}else if(!isValidEmail(email)) {
			errEmail = "This email is wrong format";
			return false;
		}else {
			List<UserDTO> listUser = userService.getListUser();
			for (UserDTO existedUser : listUser) {
				if(existedUser.getEmail() == email) {
					errEmail = "Email already exists !";
					return false;
				};
			}
		}
		return true;
	}
	
	static boolean isValidEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	   }
}
