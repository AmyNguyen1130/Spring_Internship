package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.ResultDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ResultService {

	void saveSubmitAssessment(Long userId, Long assessmentid, Long questionId, String answerChoice, Float score)
			throws JsonProcessingException;

	void saveEditSubmitAssessment(Long idEdit, Long userId, Long assessmentid, Long questionId, String answerChoice,
			Float score) throws JsonProcessingException;

	Float getUserScoreByAssessment(Long assessmentid);

	List<ResultDTO> findByAssessmentId(Long assessmentid);

	List<ResultDTO> findByAssessmentAndStudent(Long assessmentid, Long userId);

	List<Long> getListStudentIdtByAssessmentId(Long assessmentid);

}
