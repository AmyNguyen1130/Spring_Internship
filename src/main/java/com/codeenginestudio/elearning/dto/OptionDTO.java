package com.codeenginestudio.elearning.dto;

public class OptionDTO {

	private String name;
	
	private String optionValue;
	
	public OptionDTO() {
		super();
	}

	public OptionDTO(String name, String optionValue) {
		super();
		this.name = name;
		this.optionValue = optionValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	
	
}
