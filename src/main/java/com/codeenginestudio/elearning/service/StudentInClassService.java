package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.StudentInClassDTO;

public interface StudentInClassService {

	void deleteByClassid(Long classid);

	void deleteById(Long id);

	void saveTeachersToClass(Long classid, Long userid);

	Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long userid);

	List<StudentInClassDTO> getAllStudentInClass();

	List<StudentInClassDTO> getStudentInClassByClassid(Long classid);

}
