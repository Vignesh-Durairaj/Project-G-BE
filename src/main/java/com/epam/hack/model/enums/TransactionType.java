package com.epam.hack.model.enums;

public enum TransactionType {

	DR("Debit Record"),
	CR("Credit Record");
	
	private String name;
	
	TransactionType(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
