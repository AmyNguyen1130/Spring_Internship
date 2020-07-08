package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.util.CommonUtil;
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
	public Page<UserDTO> getUserPage(Integer page) {

		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), ITEM_PER_PAGE);
		Page<UserEntity> listUserEntity = userDAO.findAll(pageable);
		return listUserEntity.map(x -> (UserUtil.parseToUserDTO(x)));
	}

	@Override
	public Page<UserDTO> getUserPageByEnabledAndRoleid(Boolean enabled, Long roleid, Integer page) {

		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), ITEM_PER_PAGE);
		Page<UserEntity> listUserEntity = userDAO.getUserPageByEnabledAndRoleid(enabled, roleid, pageable);

		return listUserEntity.map(x -> (UserUtil.parseToUserDTO(x)));
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

	@Override
	public List<UserEntity> findByUsername(String username) {

		return userDAO.findByUsername(username);
	}

	@Override
	public List<UserEntity> findByEmail(String email) {

		return userDAO.findByEmail(email);
	}

	public List<UserDTO> getUsersByRoleid(Long roleid) {

		List<UserEntity> listUserEntity = userDAO.getUsersByRoleid(roleid);
		List<UserDTO> listUserDTO = new ArrayList<>();
		for (UserEntity userEntity : listUserEntity) {
			listUserDTO.add(UserUtil.parseToUserDTO(userEntity));
		}
		
		return listUserDTO;
	}

	@Override
	public Page<UserDTO> getUserPageByRoleid(Long roleid, Integer page) {
		
		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), ITEM_PER_PAGE);
		Page<UserEntity> listUserEntity = userDAO.getUserPageByRoleid(roleid, pageable);
		
		return listUserEntity.map(x -> (UserUtil.parseToUserDTO(x)));
	}
	
	@Override
	public Page<UserDTO> getUserPageByUsername(String username, Integer page) {
		
		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), ITEM_PER_PAGE);
		Page<UserEntity> listUserEntity = userDAO.getUserPageByUsername(username, pageable);
		
		return listUserEntity.map(x -> (UserUtil.parseToUserDTO(x)));
	}

	private static final int ITEM_PER_PAGE = 10;
}
