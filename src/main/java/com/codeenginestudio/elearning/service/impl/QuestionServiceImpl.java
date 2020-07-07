package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.QuestionDAO;
import com.codeenginestudio.elearning.dao.entity.QuestionEntity;
import com.codeenginestudio.elearning.dto.QuestionDTO;
import com.codeenginestudio.elearning.service.QuestionService;
import com.codeenginestudio.elearning.util.QuestionUtil;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDAO questionDAO;

	@Override
	public List<QuestionDTO> getListQuestion() {

		List<QuestionEntity> listQuestion = questionDAO.findAll();

		List<QuestionDTO> questionDTO = new ArrayList<>();
		for (QuestionEntity question : listQuestion) {
			questionDTO.add(QuestionUtil.parseToDTO(question));
		}
		return questionDTO;
	}

	@Override
	public List<QuestionDTO> getListQuestionbyAssessmentid(Long assessmentid) {
		List<QuestionEntity> listQuestion = questionDAO.getQuestionByAssessmentid(assessmentid);

		List<QuestionDTO> questionDTO = new ArrayList<>();
		for (QuestionEntity question : listQuestion) {
			questionDTO.add(QuestionUtil.parseToDTO(question));
		}
		return questionDTO;
	}

}
