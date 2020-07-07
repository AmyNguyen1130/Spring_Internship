package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.AssessmentDTO;

public interface AssessmentService {

	void deleteById(Long assessmentid);

	void saveAssessment(AssessmentDTO assessmentDTO);

	AssessmentDTO showEditAssessment(Long assessmentid);

	AssessmentDTO findByAssessmentName(String assessmentname);

	List<AssessmentDTO> getListAssessment();

	Page<AssessmentDTO> getPageListAssessment(Integer page);

	Page<AssessmentDTO> findAssessmentPageByAssessmentname(String inputSearch, Integer page);

}
