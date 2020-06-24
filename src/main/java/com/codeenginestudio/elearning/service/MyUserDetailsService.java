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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.codeenginestudio.elearning.dao.UserDAO;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		authorities.add(new SimpleGrantedAuthority("USER"));

		// UserEntity
		if (DEFAULT_USER_NAME.equals(username)) {
			return new User(username, getDefaultPassword(DEFAULT_PASSWORD), authorities);
		}

		throw new UsernameNotFoundException("Can not found user");
	}

	private String getDefaultPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
		return passwordEncoder.encode(password);
	}

	private static String DEFAULT_PASSWORD = "12345";

	private static String DEFAULT_USER_NAME = "admin";
}
