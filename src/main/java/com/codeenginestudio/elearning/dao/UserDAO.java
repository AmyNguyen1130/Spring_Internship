package com.codeenginestudio.elearning.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	List<UserEntity> findByUsername(String username);

	List<UserEntity> findByEmail(String email);

	List<UserEntity> getUsersByRoleid(@Param("roleid") Long roleid);
	
	List<UserEntity> getUserPageByRoleid(@Param("roleid") Long roleid);

	Page<UserEntity> getUserPageByRoleid(Long roleid, Pageable pageable);

	Page<UserEntity> getUserPageByEnabledAndRoleid(Boolean enabled, Long roleid, Pageable pageable);

	Page<UserEntity> getUserPageByUsername(String username, Pageable pageable);
}
