package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.AssessmentDTO;

public interface AssessmentService {

	Page<AssessmentDTO> getPageListAssessment(Integer page);

	List<AssessmentDTO> getListAssessment();

	void saveAssessment(AssessmentDTO assessmentDTO);

	AssessmentDTO findByAssessmentName(String assessmentname);
}
