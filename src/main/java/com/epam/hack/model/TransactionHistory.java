package com.epam.hack.model;

import java.util.List;

public class TransactionHistory {
	
	private String accountName;
	private List<Transaction> transactions;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
