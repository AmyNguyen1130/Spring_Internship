package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.ResultDTO;
import com.codeenginestudio.elearning.dto.UserDTO;

public interface ResultService {

	Float getUserScoreByAssessment(Long assessmentid);

	List<ResultDTO> findByAssessmentId(Long assessmentid);
	
	List<ResultDTO> findByStudentId(Long studentid);

	List<ResultDTO> findByAssessmentAndStudent(Long assessmentid, Long userId);

	List<Long> getListStudentIdtByAssessmentId(Long assessmentid);
	
	List<Long> getListAssessmentIdByStudentId(Long studentid);

	void saveSubmitLesson(ResultDTO lesson);

	void saveEditSubmitLesson(ResultDTO lesson);

	List<UserDTO> getListStudentNotyetSubmitAssessment();

}
