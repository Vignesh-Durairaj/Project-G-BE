package com.epam.hack.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hack.app.bo.GoalGenerator;
import com.epam.hack.app.util.BaseInterface;
import com.epam.hack.model.Goal;
import com.epam.hack.model.UserProfile;

@Service
public class GoalGeneratorService implements BaseInterface {

	@Autowired private GoalGenerator goalGenerator;
	
	public List<Goal> getAutomatedGoalWithNoTransactions(UserProfile userProfile) {
		return goalGenerator.getAutoGeneratedGoal(userProfile);
	}
}