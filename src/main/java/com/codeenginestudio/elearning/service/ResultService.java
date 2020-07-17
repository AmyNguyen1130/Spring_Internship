package com.codeenginestudio.elearning.service;

import java.time.LocalDate;
import java.util.List;

import com.codeenginestudio.elearning.dto.ResultDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ResultService {

	void saveSubmitAssessment(Long userId, Long assessmentid, Long questionId, String answerChoice, LocalDate currentDate, LocalDate updateDate)
			throws JsonProcessingException;

	List<ResultDTO> getAssessmentByAssessmentId(Long assessmentid);

}
