package com.codeenginestudio.elearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.codeenginestudio.elearning.dao.QuestionOfAssessmentDAO;
import com.codeenginestudio.elearning.dao.entity.QuestionOfAssessmentEntity;
import com.codeenginestudio.elearning.dto.QuestionOfAssessmentDTO;
import com.codeenginestudio.elearning.service.QuestionOfAssessmentService;
import com.codeenginestudio.elearning.util.CommonUtil;
import com.codeenginestudio.elearning.util.QuestionOfAssignmentUtil;

@Service
public class QuestionOfAssessmentServiceImpl implements QuestionOfAssessmentService {

	@Autowired
	private QuestionOfAssessmentDAO questionOfAssignmentDAO;

	@Override
	public Page<QuestionOfAssessmentDTO> getListQuestionOfAssessmentByAssessment(Integer page, Long assessmentid) {

		Pageable pageable = PageRequest.of(CommonUtil.getInt(page), ITEM_PER_PAGE);
		Page<QuestionOfAssessmentEntity> listQuestionOfAssignmentEntity = questionOfAssignmentDAO
				.getListQuestionOfAssessmentByAssessment(pageable, assessmentid);
		return listQuestionOfAssignmentEntity.map(x -> (QuestionOfAssignmentUtil.parseToQuestionOfAssignmentDTO(x)));
	}

	@Override
	public void addQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO) {
		questionOfAssignmentDAO
				.saveAndFlush(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO));

	}

	@Override
	public void deleteQuestionOfAssessment(Long questionId) {
		questionOfAssignmentDAO.deleteById(questionId);

	}

	@Override
	public void editQuestionOfAssessment(QuestionOfAssessmentDTO questionOfAssessmentDTO) {
		questionOfAssignmentDAO
				.saveAndFlush(QuestionOfAssignmentUtil.parseToQuestionOfAssignmentEntity(questionOfAssessmentDTO));
	}

	@Override
	public QuestionOfAssessmentDTO getOneQuestionOfAssessment(Long questionId) {

		return QuestionOfAssignmentUtil.parseToQuestionOfAssignmentDTO(questionOfAssignmentDAO.getOne(questionId));
	}

	private static final int ITEM_PER_PAGE = 10;
}
