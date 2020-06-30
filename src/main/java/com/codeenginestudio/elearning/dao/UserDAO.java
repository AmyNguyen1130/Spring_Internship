package com.codeenginestudio.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeenginestudio.elearning.dao.entity.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {

	/**
	 * META-INF/jpa/user.orm.xml
	 */
	UserEntity getUserByUsername(@Param("username") String username);

	long countByUsername(String lastname);

	long countByEmail(String email);
}
