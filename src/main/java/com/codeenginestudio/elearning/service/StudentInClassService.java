package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.StudentInClassDTO;

public interface StudentInClassService {

	void saveTeachersToClass(Long classid, Long userid);

	List<StudentInClassDTO> getAllStudentInClass();

	Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long userid);

	void deleteByClassid(Long classid);

	List<StudentInClassDTO> getAllStudentInClassByClassid(Long classid);

	void deleteStudentInClass(Long id);

}
