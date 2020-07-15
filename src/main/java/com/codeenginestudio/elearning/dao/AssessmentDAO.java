package com.codeenginestudio.elearning.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.AssessmentEntity;
import com.codeenginestudio.elearning.dao.entity.ClassEntity;

@Repository
public interface AssessmentDAO extends JpaRepository<AssessmentEntity, Long> {

	Page<AssessmentEntity> getAssessmentPageByAssessmentname(String inputSearch, Pageable pageable);

	Page<AssessmentEntity> getAssessmentPageByClassForeign(ClassEntity classForeign, Pageable pageable);

}
