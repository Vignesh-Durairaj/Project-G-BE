package com.epam.hack.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

	@JsonProperty("account_id")
	private String accountId;
	
	@JsonProperty("account_owner")
	private String accountOwner;
	
	private Double amount;
	
	private List<String> category;
	
	@JsonProperty("category_id")
	private String categoryId;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern="yyyy-MM-dd")
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public String getPendingTransactionId() {
		return pendingTransactionId;
	}

	public void setPendingTransactionId(String pendingTransactionId) {
		this.pendingTransactionId = pendingTransactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOtherCurrencyCode() {
		return otherCurrencyCode;
	}

	public void setOtherCurrencyCode(String otherCurrencyCode) {
		this.otherCurrencyCode = otherCurrencyCode;
	}
	
}
