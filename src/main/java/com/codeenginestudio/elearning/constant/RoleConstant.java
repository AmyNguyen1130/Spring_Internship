package com.codeenginestudio.elearning.constant;

public class RoleConstant {

	public static final String ADMIN = "ADMIN";

	public static final String DEFAULT_ROLE = "ROLE_USER";

	public static final String PREFIX_ROLE = "ROLE_";

	public static final Long ROLE_ADMIN = (long) 1;

	public static final Long ROLE_STUDENT = (long) 3;

	public static final Long ROLE_TEACHER = (long) 2;

	public static final String STUDENT = "STUDENT";

	public static final String TEACHER = "TEACHER";

	public static final String getRoleAdmin() {
		return getRole(ADMIN);
	}

	public static final String getRoleStudent() {
		return getRole(STUDENT);
	}

	public static final String getRoleTeacher() {
		return getRole(TEACHER);
	}

	private static final String getRole(String role) {
		return PREFIX_ROLE.concat(role);
	}

}
