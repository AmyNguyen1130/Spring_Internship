package com.codeenginestudio.elearning.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

@Service
public interface QuestionOfAssessmentService {

	Page<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(Integer page, Long assessmentid);

	void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO);

	void deleteQuestionOfAssessment(Long questionId);

	void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO);

	QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId);
}
