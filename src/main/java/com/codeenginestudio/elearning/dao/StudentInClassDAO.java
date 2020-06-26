package com.codeenginestudio.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeenginestudio.elearning.dao.entity.StudentInClassEntity;

public interface StudentInClassDAO extends JpaRepository<StudentInClassEntity, Long> {

}
