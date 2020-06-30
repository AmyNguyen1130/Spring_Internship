package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.UserDTO;

public interface UserService {

	List<UserDTO> getListUser();

	Page<UserDTO> getUserPage(Integer page);

	void addUser(UserDTO user);

	void deleteUser(long userId);

	UserDTO getOneUser(long userId);

	void editUser(UserDTO user);
	
	void editUserStatus(long userId);

	long countByUsername(String username);

	long countByEmail(String email);
}
