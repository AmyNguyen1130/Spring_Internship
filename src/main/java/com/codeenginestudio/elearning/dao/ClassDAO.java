package com.codeenginestudio.elearning.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.ClassEntity;

@Repository
public interface ClassDAO extends JpaRepository<ClassEntity, Long> {

	Page<ClassEntity> getClassPageByClassname(String inputSearch, Pageable pageable);

	Page<ClassEntity> getClassByStatus(Boolean status, Pageable pageable);
}
