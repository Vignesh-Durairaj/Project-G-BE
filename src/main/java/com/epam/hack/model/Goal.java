package com.epam.hack.model;

import com.epam.hack.model.enums.Health;
import com.epam.hack.model.enums.Level;

public class Goal {

	private String name;
	private double amount;
	private int targetMonth;
	private Level priority;
	private Health health;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTargetMonth() {
		return targetMonth;
	}

	public void setTargetMonth(int targetMonth) {
		this.targetMonth = targetMonth;
	}

	public Level getPriority() {
		return priority;
	}

	public void setPriority(Level priority) {
		this.priority = priority;
	}

	public Health getHealth() {
		return health;
	}

	public void setHealth(Health health) {
		this.health = health;
	}
}
