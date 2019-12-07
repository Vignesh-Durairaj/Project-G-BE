package com.epam.hack.model.enums;

import java.util.Arrays;

public enum Health {

	RED(1),
	AMBER(2),
	GREEN(3);
	
	private int healthLevel;
	
	Health (final int healthLevel) {
		this.healthLevel = healthLevel;
	}
	
	public int getLevel() {
		return healthLevel;
	}
	
	public static Health getHealthFromLevel(int level) {
		return Arrays.stream(Health.values())
			.filter(health -> health.getLevel() == level)
			.findFirst()
			.orElseThrow();
	}
}
