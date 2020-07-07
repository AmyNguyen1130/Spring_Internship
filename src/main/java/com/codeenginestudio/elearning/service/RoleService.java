package com.codeenginestudio.elearning.service;

import java.util.List;

import com.codeenginestudio.elearning.dto.RoleDTO;

public interface RoleService {

	void addRole(RoleDTO user);

	List<RoleDTO> getListRole();
}
