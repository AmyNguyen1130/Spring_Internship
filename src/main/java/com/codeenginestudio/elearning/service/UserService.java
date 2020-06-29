package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.UserDTO;

public interface UserService {
	List<UserDTO> getListUser();

	void addUser(UserDTO user);

	void deleteUser(long userId);

	UserDTO getOneUser(long userId);

	void editUser(UserDTO user);
	
	void editUserStatus(long userId);
}
