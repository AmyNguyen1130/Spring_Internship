package com.codeenginestudio.elearning.util;

import org.modelmapper.ModelMapper;

import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.UserDTO;

public class UserUtil {

	public static UserDTO parseToUserDTO(UserEntity userEntity) {

		ModelMapper modelMapper = new ModelMapper();
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

		return userDTO;
	}

	public static UserEntity parseToUserEntity(UserDTO userDTO) {

		ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

		return userEntity;
	}
}
