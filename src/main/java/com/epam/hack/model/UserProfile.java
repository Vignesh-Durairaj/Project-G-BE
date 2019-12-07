package com.epam.hack.model;

import java.util.List;

import com.epam.hack.model.enums.AgeGroup;
import com.epam.hack.model.enums.Gender;
import com.epam.hack.model.enums.Health;
import com.epam.hack.model.enums.Level;

public class UserProfile {

	private Gender gender;
	private AgeGroup ageGroup;
	private Level incomeLevel;
	private List<Goal> needs;
	private Health overallHealth;
	private boolean isMarried;

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAgeGroup() {
		return ageGroup.getDescription();
	}

	public void setAgeGroup(String ageGroupDesc) {
		this.ageGroup = AgeGroup.getAgeGroupFromDesc(ageGroupDesc);
	}

	public Level getIncomeLevel() {
		return incomeLevel;
	}

	public void setIncomeLevel(Level incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	public List<Goal> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Goal> needs) {
		this.needs = needs;
	}

	public Health getOverallHealth() {
		return overallHealth;
	}

	public void setOverallHealth(Health overallHealth) {
		this.overallHealth = overallHealth;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
}
