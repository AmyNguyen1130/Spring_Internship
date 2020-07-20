package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.constant.Constant;
import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.service.UserService;
import com.codeenginestudio.elearning.util.CommonUtil;
import com.codeenginestudio.elearning.util.PasswordUtil;
import com.codeenginestudio.elearning.util.RoleUtil;
import com.codeenginestudio.elearning.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public Page<UserDTO> getUserPage(Integer page) {

		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), Constant.ITEM_PER_PAGE);
		Page<UserEntity> listUserEntity = userDAO.findAll(pageable);
		return listUserEntity.map(x -> (UserUtil.parseToUserDTO(x)));
	}

	@Override
	public void addUser(UserDTO user) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(PasswordUtil.encode(user.getPassword()));
		userEntity.setFirstname(user.getFirstname());
		userEntity.setLastname(user.getLastname());
		userEntity.setGender(user.getGender());
		userEntity.setRole(RoleUtil.parseToRoleEntity(user.getRole()));
		userEntity.setAvartar(user.getAvartar());
		userEntity.setEnabled(user.getEnabled());		

		userDAO.saveAndFlush(userEntity);
	}

	@Override
	public void deleteUser(long userId) {
		userDAO.deleteById(userId);
	}

	@Override
	public void editUser(UserDTO user) {
		
		UserEntity userEntity = userDAO.getOne(user.getUserid());
		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(PasswordUtil.encode(user.getPassword()));
		userEntity.setFirstname(user.getFirstname());
		userEntity.setLastname(user.getLastname());
		userEntity.setGender(user.getGender());
		userEntity.setRole(RoleUtil.parseToRoleEntity(user.getRole()));
		userEntity.setAvartar(user.getAvartar());
		userEntity.setEnabled(user.getEnabled());	

		userDAO.saveAndFlush(userEntity);
	}

	@Override
	public void editUserStatus(long userId) {
		
		UserEntity userEntity = userDAO.getOne(userId);
		userEntity.setEnabled(!userEntity.isEnabled());
		userDAO.saveAndFlush(userEntity);
	}

	@Override
	public List<UserEntity> findByUsername(String username) {

		return userDAO.findByUsername(username);
	}

	@Override
	public List<UserEntity> findByEmail(String email) {

		return userDAO.findByEmail(email);
	}

	public List<UserDTO> getUserByRole(Long roleid) {

		List<UserEntity> listUserEntity = userDAO.findAll();
		List<UserDTO> listUserDTO = new ArrayList<>();
		for (UserEntity userEntity : listUserEntity) {
			if (userEntity.getRole().getRoleid() == roleid) {
				listUserDTO.add(UserUtil.parseToUserDTO(userEntity));
			}
		}

		return listUserDTO;
	}

	@Override
	public Page<UserDTO> getUserPageByRole(Long roleid, Integer page) {

		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), Constant.ITEM_PER_PAGE);
		Page<UserEntity> listUserEntity = userDAO.getUserPageByRole(roleid, pageable);

		return listUserEntity.map(x -> (UserUtil.parseToUserDTO(x)));
	}

	@Override
	public UserDTO showUserByUserId(Long userid) {

		return UserUtil.parseToUserDTO(userDAO.getOne(userid));
	}

	@Override
	public UserDTO getUserByUsername(String username) {

		return UserUtil.parseToUserDTO(userDAO.getUserByUsername(username));
	}
}
