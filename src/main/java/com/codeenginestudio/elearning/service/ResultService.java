package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.ResultDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ResultService {

	void saveSubmitAssessment(ResultDTO resultDTO) throws JsonProcessingException;

	void saveEditSubmitAssessment(ResultDTO resultDTO)throws JsonProcessingException;

	Float getUserScoreByAssessment(Long assessmentid);

	List<Long> getListStudentIdtByAssessmentId(Long assessmentid);

	List<ResultDTO> findByAssessmentId(Long assessmentid);

	List<ResultDTO> findByAssessmentAndStudent(Long assessmentid, Long userId);

	ResultDTO findResultByAssessmentId(Long assessmentid);

}
