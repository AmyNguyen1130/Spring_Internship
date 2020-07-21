package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.ClassDTO;

public interface ClassService {

	void deleteClass(Long id);

	void editStatusClass(Long classid);

	void saveClass(ClassDTO classDTO);

	ClassDTO getClassByClassid(Long classid);

	List<ClassDTO> getAllClass();

	Page<ClassDTO> getClassPage(Integer page);

}
