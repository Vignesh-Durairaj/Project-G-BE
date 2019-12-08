package com.epam.hack.model;

import java.time.LocalDate;

public class TransactionAggregate {

	private Double expenses;
	private Double income;

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
}
