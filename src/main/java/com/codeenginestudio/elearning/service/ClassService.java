package com.codeenginestudio.elearning.service;

import java.util.List;
import com.codeenginestudio.elearning.dto.ClassDTO;

public interface ClassService {

	List<ClassDTO> getAllClass();

	void saveClass(ClassDTO classDTO);

	void deleteClass(int id);

	ClassDTO showEditClass(int id);
}
