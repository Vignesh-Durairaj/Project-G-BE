package com.epam.hack.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hack.app.util.JsonHelper;
import com.epam.hack.model.Goal;
import com.epam.hack.model.TransactionHistory;
import com.epam.hack.model.UserProfile;

@RestController
@RequestMapping("/goal")
public class Goals {

	public static String targetUrl = "";
	
	@Autowired private Transactions transactionController;
	@Autowired private JsonHelper jsonHelper;
	
	@PostMapping("/auto")
	public String getGoalsForUser(@RequestBody UserProfile userProfile) {
		
		// List<TransactionHistory> transactionHistories = transactionController.getTransactionHistories();
		List<Goal> autoGoals = new ArrayList<>();
		return jsonHelper.marshall(autoGoals);
	}
}
