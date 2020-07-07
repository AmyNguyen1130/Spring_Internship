package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.QuestionDTO;

public interface QuestionService {

	List<QuestionDTO> getListQuestion();

	List<QuestionDTO> getListQuestionbyAssessmentid(Long assessmentid);
}
