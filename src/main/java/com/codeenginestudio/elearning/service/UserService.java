package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.UserDTO;

public interface UserService {

	List<UserDTO> getListUser();
	
	Page<UserDTO> getUserPageByEnabledAndRoleid(Boolean enabled, Long roleid, Integer page);

	Page<UserDTO> getUserPage(Integer page);
	
	void addUser(UserDTO user);

	void deleteUser(long userId);

	UserDTO getOneUser(long userId);

	void editUser(UserDTO user);
	
	void editUserStatus(long userId);

	List<UserEntity> findByUsername(String username);

	List<UserEntity> findByEmail(String email);

	List<UserDTO> getUsersByRoleid(Long roleid);
	
	Page<UserDTO> getUserPageByRoleid(Long roleid, Integer page);
	
}
