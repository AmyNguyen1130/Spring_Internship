package com.codeenginestudio.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {

}
