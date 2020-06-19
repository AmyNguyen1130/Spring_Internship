package com.codeenginestudio.elearning.util;

import org.modelmapper.ModelMapper;
import com.codeenginestudio.elearning.dao.entity.ClassEntity;
import com.codeenginestudio.elearning.dto.ClassDTO;

public class ClassUtil {
	public static ClassDTO parseToDTO(ClassEntity classEntity) {

		ModelMapper modelMapper = new ModelMapper();
		ClassDTO classDTO = modelMapper.map(classEntity, ClassDTO.class);

		return classDTO;
	}

	public static ClassEntity parseToEntity(ClassDTO classDTO) {

		ModelMapper modelMapper = new ModelMapper();
		ClassEntity classEntity = modelMapper.map(classDTO, ClassEntity.class);

		return classEntity;
	}
}
