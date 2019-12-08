package com.epam.hack.app.bo;

import static com.epam.hack.model.enums.AgeGroup.getAgeGroupFromDesc;
import static com.epam.hack.model.enums.Gender.F;
import static com.epam.hack.model.enums.Level.HIGH;
import static com.epam.hack.model.enums.Level.LOW;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.hack.app.util.BaseInterface;
import com.epam.hack.model.Goal;
import com.epam.hack.model.UserProfile;
import com.epam.hack.model.enums.AgeGroup;

@Component
public class GoalGenerator implements BaseInterface {

	public List<Goal> getAutoGeneratedGoal(final UserProfile user) {
		AgeGroup ageGroup = getAgeGroupFromDesc(user.getAgeGroup());
		List<Goal> goals = new ArrayList<>();
		
		switch (ageGroup) {
			case EIGHTEEN_TO_TWENTY:
				goals.addAll(getGoalsAtEarlyStage(user));
				break;
			case TWENTY_TO_TWENTY_FIVE:
				goals.addAll(getGoalsAtEarlyStage(user));
				break;
			case TWENTY_FIVE_TO_THIRTY:
				goals.addAll(getGoalAtEarlyMiddleAge(user));
				break;
			case THIRTY_TO_FORTY:
				goals.addAll(getGoalAtMiddleAge(user));
				break;
			case FORTY_TO_FIFTY:
				goals.addAll(getGoalAtLateMiddleAge(user));
				break;
			case FIFTY_TO_SIXTY:
				goals.addAll(getGoalAtEarlyRetirement(user));
				break;
			case SIXTY_AND_ABOVE:
				goals.addAll(getGoalAtAfterRetirement(user));
				break;
			default:
				goals.add(new Goal("Plan a vacation overseas", 6));
				
		}
		return goals;
	}

	private List<Goal> getGoalsAtEarlyStage(UserProfile user) {
		Goal goal;
		if (user.isMarried()) {
			goal = new Goal("Save money for new home furnitures", 3);
		} else {
			goal = new Goal(user.getGender() == F ? "Plan for Marriage Expenses" : 
				"Plan for a master degree at university", 6);
		}
		
		return List.of(goal);
	}
	
	private List<Goal> getGoalAtEarlyMiddleAge(UserProfile user) {
		List<Goal> goals = new ArrayList<>();
		if (user.getGender() == F) {
			if (user.isMarried()) {
				goals.add(new Goal ("Baby time... yay!", 10));
			} else {
				goals.addAll(getGoalsAtEarlyStage(user));
			}
		} else {
			goals.add(new Goal(user.isMarried() ? "Plan for baby expenses" : "Plan for marriage", 6));
		}
		
		return goals;
	}
	
	private List<Goal> getGoalAtMiddleAge(UserProfile user) {
		List<Goal> goals = new ArrayList<>();
		if (user.isMarried()) {
			Goal goal = new Goal("School time", 6, HIGH);
			goals.add(goal);
		} else {
			goals.addAll(getGoalsAtEarlyStage(user));
			goals.add(new Goal("Plan to own a new apartment", 24));
		}
		
		return goals;
	}
	
	private List<Goal> getGoalAtLateMiddleAge(UserProfile user) {
		List<Goal> goals = new ArrayList<>();
		goals.add(new Goal("Plan to buy a new house", 24, HIGH));
		return goals;
	}
	
	private List<Goal> getGoalAtEarlyRetirement(UserProfile user) {
		List<Goal> goals = new ArrayList<>();
		goals.add(new Goal("Plan for a vacation", 12, LOW));
		goals.add(new Goal("Plan for children's wedding gift", 6));
		return goals;
	}
	
	private List<Goal> getGoalAtAfterRetirement(UserProfile user) {
		List<Goal> goals = new ArrayList<>();
		goals.add(new Goal("Save for the next holiday of grand children", 6));
		return goals;
	}







}