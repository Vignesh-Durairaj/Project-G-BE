package com.epam.hack.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.hack.model.TransactionHistory;

@RestController
public class Transactions {

	public final String URL = "http://localhost:8080/transaction/history";
	
	public List<TransactionHistory> getTransactionHistories() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<TransactionHistory[]> response = template.getForEntity(URL, TransactionHistory[].class);
		return Arrays.asList(response.getBody());
	}
	
}
