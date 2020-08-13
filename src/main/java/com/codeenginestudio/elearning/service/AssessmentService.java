package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.ClassDTO;

public interface AssessmentService {

	void deleteById(Long assessmentid);

	void saveAddAssessment(AssessmentDTO assessmentDTO);

	void saveEditAssessment(AssessmentDTO assessmentDTO);

	void deleteAssessmentClassid(Long classId);

	void editAssessmentStatus(Long assessmentid);

	List<Long> getAssessmentEnable(boolean status);

	AssessmentDTO getAssessmentByAssessmentid(Long assessmentid);

	AssessmentDTO findByAssessmentName(String assessmentname);

	List<AssessmentDTO> getListAssessment();

	List<AssessmentDTO> getListAssessmentByUnExpired(Long userId);

	List<AssessmentDTO> getListAssessmentByExpired(Long userId);

	List<AssessmentDTO> getAssessmentByClassForeign(List<ClassDTO> listClass);

	List<AssessmentDTO> getListAssessmentByClassid(Long classid);

}
