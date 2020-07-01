package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.ClassDTO;

public interface ClassService {

	List<ClassDTO> getAllClass();

	void saveClass(ClassDTO classDTO);

	void deleteClass(Long id);

	ClassDTO showEditClass(Long id);

	Page<ClassDTO> getClassPage(Integer page);

}
