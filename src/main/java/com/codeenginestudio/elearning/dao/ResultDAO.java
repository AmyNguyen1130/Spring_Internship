package com.codeenginestudio.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeenginestudio.elearning.dao.entity.AssessmentEntity;
import com.codeenginestudio.elearning.dao.entity.ResultEntity;

public interface ResultDAO extends JpaRepository<ResultEntity, Long>{

	List<ResultEntity> findByAssessment(AssessmentEntity assessment);
}
