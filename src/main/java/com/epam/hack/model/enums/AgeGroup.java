package com.epam.hack.model.enums;

import java.util.Arrays;

public enum AgeGroup {

	EIGHTEEN_TO_TWENTY("18 to 20"), 
	TWENTY_TO_TWENTY_FIVE("21 to 25"), 
	TWENTY_FIVE_TO_THIRTY("26 to 30"), 
	THIRTY_TO_FORTY("31 to 40"), 
	FORTY_TO_FIFTY("41 to 50"), 
	FIFTY_TO_SIXTY("51 to 60"), 
	SIXTY_AND_ABOVE("61 or higher");
	
	private String desc;
	
	private AgeGroup(final String desc) {
		this.desc = desc;
	}
	
	public String getDescription() {
		return this.desc;
	}
	
	public static AgeGroup getAgeGroupFromDesc(String desc) {
		return Arrays.stream(values())
			.filter(group -> group.getDescription().equalsIgnoreCase(desc))
			.findFirst()
			.orElseThrow();
	}
}
