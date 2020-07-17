package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.StudentInClassDTO;

public interface StudentInClassService {

	void saveStudentInClass(Long classid, Long userid);

	void deleteStudentInClass(Long id);

	void deleteAllByClass(Long classid);

	Long findIdByValue(List<StudentInClassDTO> studentInClassDTO, Long check);

	List<Long> getListStudentByClassid(Long classid);

	List<StudentInClassDTO> getAllStudentInClass();

	List<Long> getClassIdByStudent(String username);

}
