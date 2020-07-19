package com.codeenginestudio.elearning.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.constant.Constant;
import com.codeenginestudio.elearning.dao.AssessmentDAO;
import com.codeenginestudio.elearning.dao.entity.AssessmentEntity;
import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.dto.ClassDTO;
import com.codeenginestudio.elearning.service.AssessmentService;
import com.codeenginestudio.elearning.util.AssessmentUtil;
import com.codeenginestudio.elearning.util.ClassUtil;
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
		Pageable pageable = (Pageable) PageRequest.of(CommonUtil.getInt(page), Constant.ITEM_PER_PAGE);

		Page<AssessmentEntity> listAssessment = assessmentDAO.findAll(pageable);

		return listAssessment.map(x -> (AssessmentUtil.parseToDTO(x)));

	}

	@Override
	public void saveAssessment(AssessmentDTO assessmentDTO) {
		// TODO: Don't use util in here
		assessmentDAO.saveAndFlush(AssessmentUtil.parseToEntity(assessmentDTO));
	}

	@Override
	public void deleteById(Long assessmentid) {
		assessmentDAO.deleteById(assessmentid);

	}

	@Override
	public AssessmentDTO getAssessmentByAssessmentid(Long assessmentid) {
		return AssessmentUtil.parseToDTO(assessmentDAO.getOne(assessmentid));
	}

	@Override
	public void editAssessmentStatus(Long assessmentid) {
		Boolean status = assessmentDAO.getOne(assessmentid).getStatus();
		assessmentDAO.getOne(assessmentid).setStatus(!status);
		assessmentDAO.saveAndFlush(assessmentDAO.getOne(assessmentid));

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

	@Override
	public Page<AssessmentDTO> getPageListAssessmentByClass(ClassDTO classDTO, Integer page) {
		
		// TODO: no need class DTO, only classId
		Pageable pageable = (Pageable) PageRequest.of(CommonUtil.getInt(page), Constant.ITEM_PER_PAGE);

		Page<AssessmentEntity> listAssessment = assessmentDAO
				.getAssessmentPageByClassForeign(ClassUtil.parseToEntity(classDTO), pageable);

		return listAssessment.map(x -> (AssessmentUtil.parseToDTO(x)));
	}

	@Override
	public List<AssessmentDTO> getListAssessmentByUnExpired() {

		LocalDate currentDate = LocalDate.now();
		List<AssessmentDTO> listAssessment = getListAssessment();
		List<AssessmentDTO> listAssessmentUnExpired = new ArrayList<>();

		for (AssessmentDTO assessment : listAssessment) {
			if (!assessment.getExpireddate().isBefore(currentDate) || assessment.getExpireddate().equals(currentDate)) {
				listAssessmentUnExpired.add(assessment);
			}
		}
		return listAssessmentUnExpired;
	}

	@Override
	public List<AssessmentDTO> getListAssessmentByExpired() {

		LocalDate currentDate = LocalDate.now();
		List<AssessmentDTO> listAssessment = getListAssessment();
		List<AssessmentDTO> listAssessmentExpired = new ArrayList<>();

		for (AssessmentDTO assessment : listAssessment) {
			if (assessment.getExpireddate().isBefore(currentDate)) {
				listAssessmentExpired.add(assessment);
			}
		}
		return listAssessmentExpired;
	}

}
