package com.codeenginestudio.elearning.validation;

import java.util.Date;

import com.codeenginestudio.elearning.dto.AssessmentDTO;
import com.codeenginestudio.elearning.service.AssessmentService;

public class AssessmentValidation {

	private String errAssessmentName;
	private String errStartDate = "";
	private String errExpiredDate = "";

	public String getErrAssessmentName() {
		return errAssessmentName;
	}

	public void setErrAssessmentName(String errAssessmentName) {
		this.errAssessmentName = errAssessmentName;
	}

	public String getErrStartDate() {
		return errStartDate;
	}

	public void setErrStartDate(String errStartDate) {
		this.errStartDate = errStartDate;
	}

	public String getErrExpiredDate() {
		return errExpiredDate;
	}

	public void setErrExpiredDate(String errExpiredDate) {
		this.errExpiredDate = errExpiredDate;
	}

	String checkEmpty(String value, String error) {
		if (value == "") {
			return error;
		}
		return "";
	}

	public String checkAssessmentNameExisted(String assessmentname, AssessmentService assessmentService) {
		if (assessmentname == "") {
			return "Assessment name could not be null";
		} else {
			if (assessmentService.findByAssessmentName(assessmentname) != null) {
				return "Assessment name already exists !";
			}
		}
		return "";
	}

	public String checkExpiredDate(Date startDate, Date expiredDate) {
		if (expiredDate.before(startDate)) {
			return "expired date must be after start date";
		}
		return "";
	}

	public String checkStartDateWithCurrentDate(Date startDate) {
		Date currentDate = new Date();

		if (currentDate.after(startDate)) {
			return "start date can not  before current date";
		}

		return "";
	}

	public AssessmentValidation validateAddAssessment(AssessmentDTO assessmentDTO,
			AssessmentService assessmentService) {

		AssessmentValidation inValid = new AssessmentValidation();
		inValid.errAssessmentName = checkEmpty(assessmentDTO.getAssessmentname(), "Assessment name could not be null");
		inValid.errAssessmentName = checkAssessmentNameExisted(assessmentDTO.getAssessmentname(), assessmentService);
		inValid.errStartDate = checkStartDateWithCurrentDate(assessmentDTO.getStartdate());
		inValid.errExpiredDate = checkExpiredDate(assessmentDTO.getStartdate(), assessmentDTO.getExpireddate());
		return inValid;
	}
}
