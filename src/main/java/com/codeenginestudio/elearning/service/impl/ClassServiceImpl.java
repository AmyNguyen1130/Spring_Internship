package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.ClassDAO;
import com.codeenginestudio.elearning.dao.entity.ClassEntity;
import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.service.ClassService;
import com.codeenginestudio.elearning.util.ClassUtil;

@Service("classService")
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDAO classDAO;

	@Override
	public List<ClassDTO> getAllClass() {

		List<ClassEntity> listClass = (List<ClassEntity>) classDAO.findAll();

		List<ClassDTO> classDTO = new ArrayList<>();
		for (ClassEntity classes : listClass) {
			classDTO.add(ClassUtil.parseToDTO(classes));
		}
		return classDTO;
	}

	@Override
	public void saveClass(ClassDTO classDTO) {

		classDAO.saveAndFlush(ClassUtil.parseToEntity(classDTO));
	}

	@Override
	public void deleteClass(Long id) {

		classDAO.deleteById(id);
	}

	@Override
	public ClassDTO showEditClass(Long id) {

		return ClassUtil.parseToDTO(classDAO.getOne(id));
	}

}
