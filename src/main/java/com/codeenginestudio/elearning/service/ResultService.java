package com.codeenginestudio.elearning.service;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.dto.UserDTO;

public interface ResultService {

	void saveSubmitAssessment(UserDTO userByUsername, AssessmentDTO assessmentByAssessmentid,
			QuestionOfAssessmentDTO oneQuestionOfAssessment, String answerChoice);

}
