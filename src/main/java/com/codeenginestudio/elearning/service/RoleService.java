package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> getListRole();

	void addRole(RoleDTO user);
}
