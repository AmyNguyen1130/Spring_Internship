package com.codeenginestudio.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.AssessmentDAO;
import com.codeenginestudio.elearning.dao.entity.AssessmentEntity;
import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.util.AssessmentUtil;
import com.codeenginestudio.elearning.util.CommonUtil;

@Service("assessmentService")
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentDAO assessmentDAO;

	@Override
	public List<AssessmentDTO> getListAssessment() {
		List<AssessmentEntity> listAssessment = (List<AssessmentEntity>) assessmentDAO.findAll();

		List<AssessmentDTO> assessmentDTO = new ArrayList<>();
		for (AssessmentEntity assessment : listAssessment) {
			assessmentDTO.add(AssessmentUtil.parseToDTO(assessment));
		}
		return assessmentDTO;
	}

	@Override
	public Page<AssessmentDTO> getPageListAssessment(Integer page) {
		Pageable pageable = (Pageable) PageRequest.of(CommonUtil.getInt(page), ITEM_PER_PAGE);

		Page<AssessmentEntity> listAssessment = assessmentDAO.findAll(pageable);

		return listAssessment.map(x -> (AssessmentUtil.parseToDTO(x)));

	}

	@Override
	public void saveAssessment(AssessmentDTO assessmentDTO) {
		assessmentDAO.saveAndFlush(AssessmentUtil.parseToEntity(assessmentDTO));

	}

	@Override
	public AssessmentDTO findByAssessmentName(String assessmentname) {
		List<AssessmentDTO> listAssessment = getListAssessment();
		
			for (AssessmentDTO existed : listAssessment) {
				if (assessmentname.equals(existed.getAssessmentname())) {
					return existed;
				}
			}
		return null;
	}

	private static final int ITEM_PER_PAGE = 10;

}
