package com.epam.hack.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hack.app.service.GoalGeneratorService;
import com.epam.hack.app.util.JsonHelper;
import com.epam.hack.model.TransactionHistory;
import com.epam.hack.model.UserProfile;

@RestController
@RequestMapping("/goal")
public class Goals {

	private static final Logger LOGGER = LoggerFactory.getLogger(Goals.class);
	
	@Autowired private Transactions transactionController;
	@Autowired private GoalGeneratorService goalGeneratorService;
	@Autowired private JsonHelper jsonHelper;
	@Autowired private ResourceLoader resourceLoader;
	
	@PostMapping("/auto")
	public String getGoalsForUser(@RequestBody UserProfile userProfile) {
		
		List<TransactionHistory> transactionHistories = transactionController.getTransactionHistories();
		String transHistory = transactionHistories != null ? transactionHistories.toString() : "";
		LOGGER.info(transHistory);
		return jsonHelper.marshall(goalGeneratorService.getAutomatedGoalWithNoTransactions(userProfile));
	}
	
	@GetMapping("/auto/predefined")
	public String getGoalsForPreDefinedUser() {
		try {
			UserProfile usr = jsonHelper.unMarshallFromFile(
					getFileFromClassPath("UserProfile.json"), UserProfile.class);
			return jsonHelper.marshall(goalGeneratorService.getAutomatedGoalWithNoTransactions(usr));
		} catch (IOException e) {
			LOGGER.error("Exception while getting predefined goals", e);
			return jsonHelper.getErrorRespose(e.getMessage());
		}
	}
	
	@GetMapping("/auto/list")
	public String getAllGoals() {
		try {
			return jsonHelper.getJsonFromFile(getFileFromClassPath("GoalAsResponse.json"));
		} catch (Exception e) {
			LOGGER.error("Exception while getting predefined goals", e);
			return jsonHelper.getErrorRespose(e.getMessage());
		}
	}
	
	private File getFileFromClassPath(String fileName) {
		try {
			Resource resource =  resourceLoader.getResource(
					String.format("classpath:static/%s", fileName));
			return resource.getFile();
		} catch (IOException e) {
			LOGGER.error("Exception in finding the file : {}", fileName);
			return null;
		}
	}
}
