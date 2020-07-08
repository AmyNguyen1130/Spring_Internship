package com.codeenginestudio.elearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codeenginestudio.elearning.dao.RoleDAO;
import com.codeenginestudio.elearning.dao.UserDAO;
import com.codeenginestudio.elearning.dao.entity.RoleEntity;
import com.codeenginestudio.elearning.dao.entity.UserEntity;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = userDAO.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Can not found user");
		}

		Long roleId = user.getRoleid();
		RoleEntity role = roleDAO.getRoleNameByRoleid(roleId);
		String roleName = role.getRolename();

		// List Roles should get from role table
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		authorities.add(new SimpleGrantedAuthority("ROLE_"+ roleName.toUpperCase()));

		return new User(username, user.getPassword(), authorities);
	}
}
