package com.codeenginestudio.elearning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;

@Service
public interface QuestionOfAssessmentService {

	List<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(AssessmentDTO assessmentid);

	void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO);

	void deleteQuestionOfAssessment(Long questionId);

	void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO);

	QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId);
}
