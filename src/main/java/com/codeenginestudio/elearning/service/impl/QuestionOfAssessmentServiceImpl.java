package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeenginestudio.elearning.dao.QuestionOfAssessmentDAO;
import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;

@Service
public class QuestionOfAssessmentServiceImpl implements QuestionOfAssessmentService {

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssessmentDAO;

	@Override
	public List<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(AssessmentDTO assessment) {
		List<QuestionOfAssessmentEntity> listQuestionEntity = questionOfAssessmentDAO.findAll();
		List<QuestionOfAssessmentDTO> listQuestionDTO = new ArrayList<>();
		for (QuestionOfAssessmentEntity questionOfAssessmentEntity : listQuestionEntity) {
			if (questionOfAssessmentEntity.getAssessment().getAssessmentid() == assessment.getAssessmentid()) {
				listQuestionDTO
						.add(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentDTO(questionOfAssessmentEntity));
			}
		}

		return listQuestionDTO;
	}

	@Override
	public void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO) {
		questionOfAssessmentDAO
				.saveAndFlush(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO));

	}

	@Override
	public void deleteQuestionOfAssessment(Long questionId) {
		questionOfAssessmentDAO.deleteById(questionId);

	}

	@Override
	public void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO) {
		questionOfAssessmentDAO
				.saveAndFlush(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO));
	}

	@Override
	public QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId) {

		return QuestionOfAssignmentUtil.parseToQuestionOfAssignmentDTO(questionOfAssessmentDAO.getOne(questionId));
	}

}
