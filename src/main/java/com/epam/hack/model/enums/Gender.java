package com.epam.hack.model.enums;

import java.util.Arrays;

public enum Gender {
	M("Male"), F("Female");
	
	private String desc;
	
	Gender(final String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public Gender getGender(String desc) {
		return Arrays.stream(Gender.values())
				.filter(gender -> desc.equals(gender.getDesc()))
				.findFirst()
				.orElseThrow();
	}
}
