package com.epam.hack.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionHistory {
	private String accountName;
	private List<Transaction> transactions;
}
