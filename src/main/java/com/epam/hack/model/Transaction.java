package com.epam.hack.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {

	@JsonProperty("account_id")
	private String accountId;
	
	@JsonProperty("account_owner")
	private String accountOwner;
	
	private Double amount;
	
	private List<String> category;
	
	@JsonProperty("category_id")
	private String categoryId;
	
	private LocalDate date;
	
	@JsonProperty("iso_currency_code")
	private String currencyCode;
	
	private String name;
	
	private boolean pending;
	
	@JsonProperty("pending_transaction_id")
	private String pendingTransactionId;
	
	@JsonProperty("transaction_id")
	private String transactionId;
	
	@JsonProperty("unofficial_currency_code")
	private String otherCurrencyCode;
}
