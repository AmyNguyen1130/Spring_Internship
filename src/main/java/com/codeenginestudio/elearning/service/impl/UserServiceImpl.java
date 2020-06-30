package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.util.PasswordUtil;
import com.codeenginestudio.elearning.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<UserDTO> getListUser() {

		List<UserEntity> listUserEntity = userDAO.findAll();
		List<UserDTO> listUserDTO = new ArrayList<>();
		for (UserEntity userEntity : listUserEntity) {
			listUserDTO.add(UserUtil.parseToUserDTO(userEntity));
		}
		return listUserDTO;
	}

	@Override
	public void addUser(UserDTO user) {
		UserEntity userEntity = UserUtil.parseToUserEntity(user);
		userEntity.setPassword(PasswordUtil.encode(userEntity.getPassword()));

		userDAO.saveAndFlush(userEntity);
	}

	@Override
	public void deleteUser(long userId) {
		userDAO.deleteById(userId);
	}

	@Override
	public UserDTO getOneUser(long userId) {
		return UserUtil.parseToUserDTO(userDAO.getOne(userId));
	}

	@Override
	public void editUser(UserDTO user) {
		UserEntity userEntity = UserUtil.parseToUserEntity(user);
		userEntity.setPassword(PasswordUtil.encode(userEntity.getPassword()));

		userDAO.saveAndFlush(userEntity);
	}

	@Override
	public void editUserStatus(long userId) {
		boolean status = userDAO.getOne(userId).isEnabled();
		userDAO.getOne(userId).setEnabled(!status);
		userDAO.saveAndFlush(userDAO.getOne(userId));
	}
}
