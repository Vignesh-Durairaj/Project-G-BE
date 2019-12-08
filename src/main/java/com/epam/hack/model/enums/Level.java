package com.epam.hack.model.enums;

public enum Level {
	HIGH(1), MID(2), LOW(3), NO(5);
	
	private int value;
	
	Level(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
