package com.codeenginestudio.elearning.decorator;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminSiteMeshConfig extends SpringBootServletInitializer {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean siteMeshFilter() {

		FilterRegistrationBean fitler = new FilterRegistrationBean();

		AdminSiteMeshFilter adminSiteMeshFilter = new AdminSiteMeshFilter();

		fitler.setFilter(adminSiteMeshFilter);

		return fitler;
	}

}
