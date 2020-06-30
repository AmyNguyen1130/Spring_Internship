package com.codeenginestudio.elearning.util;

import com.codeenginestudio.elearning.dao.entity.UserEntity;
import com.codeenginestudio.elearning.dto.UserDTO;
import com.codeenginestudio.elearning.util.general.UtilGeneral;

public class UserUtil {

	public static UserDTO parseToUserDTO(UserEntity userEntity) {

		UserDTO userDTO = UtilGeneral.modelMapper.map(userEntity, UserDTO.class);

		return userDTO;
	}

	public static UserEntity parseToUserEntity(UserDTO userDTO) {

		UserEntity userEntity = UtilGeneral.modelMapper.map(userDTO, UserEntity.class);

		return userEntity;
	}
}
