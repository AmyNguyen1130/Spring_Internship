package com.codeenginestudio.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.RoleEntity;

@Repository
public interface RoleDAO extends JpaRepository<RoleEntity, Long> {
	
}
