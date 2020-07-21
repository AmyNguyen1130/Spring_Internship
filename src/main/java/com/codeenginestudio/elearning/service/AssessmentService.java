package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.AssessmentDTO;

public interface AssessmentService {

	void deleteById(Long assessmentid);

	void saveAddAssessment(AssessmentDTO assessmentDTO);

	void saveEditAssessment(AssessmentDTO assessmentDTO);

	void editAssessmentStatus(Long assessmentid);

	AssessmentDTO getAssessmentByAssessmentid(Long assessmentid);

	AssessmentDTO findByAssessmentName(String assessmentname);

	List<AssessmentDTO> getListAssessment();

	List<AssessmentDTO> getListAssessmentByUnExpired();

	List<AssessmentDTO> getListAssessmentByExpired();

	Page<AssessmentDTO> getPageListAssessment(Integer page);

}
