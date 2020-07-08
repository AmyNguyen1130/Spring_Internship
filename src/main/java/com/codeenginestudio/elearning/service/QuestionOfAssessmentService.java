package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

@Service
public interface QuestionOfAssessmentService {
	
	Page<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessmentid(Integer page, Long assessmentid);
	
	List<QuestionOfAssessmentDTO> getListQuestionbyAssessmentid(Long assessmentId);
	
	void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO);
	
	void deleteQuestionOfAssessment(Long questionId);
	
	void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO);
	
	QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId);
}
