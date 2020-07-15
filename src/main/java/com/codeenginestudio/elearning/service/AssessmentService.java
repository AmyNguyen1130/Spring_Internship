package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.ClassDTO;

public interface AssessmentService {

	void deleteById(Long assessmentid);

	void saveAssessment(AssessmentDTO assessmentDTO);

	void editAssessmentStatus(Long assessmentid);

	AssessmentDTO getAssessmentByAssessmentid(Long assessmentid);

	AssessmentDTO findByAssessmentName(String assessmentname);

	List<AssessmentDTO> getListAssessment();

	Page<AssessmentDTO> getPageListAssessment(Integer page);

	Page<AssessmentDTO> getPageListAssessmentByClass(ClassDTO classDTO, Integer page);

}
