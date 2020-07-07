package com.codeenginestudio.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.QuestionEntity;

@Repository
public interface QuestionDAO extends JpaRepository<QuestionEntity, Long> {

	List<QuestionEntity> getQuestionByAssessmentid(Long assessmentid);

}
