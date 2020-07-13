package com.codeenginestudio.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.ClassEntity;
import com.codeenginestudio.elearning.dto.ClassDTO;

@Repository
public interface ClassDAO extends JpaRepository<ClassEntity, Long> {

	ClassEntity getClassByClassid(Long classid);

}
