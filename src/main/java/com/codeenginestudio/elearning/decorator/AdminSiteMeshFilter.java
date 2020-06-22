package com.codeenginestudio.elearning.decorator;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class AdminSiteMeshFilter extends ConfigurableSiteMeshFilter {
	private final String PRE_FIX = "/WEB-INF/view/decorator/";
	private final String NEXT_FIX = ".jsp";
	
	public String callDecorator(String decorator) {
		return PRE_FIX + decorator + NEXT_FIX;
	}
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/", callDecorator("administrator/decorator"));
		
	}
}
