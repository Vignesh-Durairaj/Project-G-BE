package com.epam.hack.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hack.app.service.GoalGeneratorService;
import com.epam.hack.app.util.JsonHelper;
import com.epam.hack.model.UserProfile;

@RestController
@RequestMapping("/goal")
public class Goals {

	public static String targetUrl = "http://localhost:3000/";
	
	@Autowired private Transactions transactionController;
	@Autowired private GoalGeneratorService goalGeneratorService;
	@Autowired private JsonHelper jsonHelper;
	
	@PostMapping("/auto")
	public String getGoalsForUser(@RequestBody UserProfile userProfile) {
		
		// List<TransactionHistory> transactionHistories = transactionController.getTransactionHistories();
		return jsonHelper.marshall(goalGeneratorService.getAutomatedGoalWithNoTransactions(userProfile));
	}
}
