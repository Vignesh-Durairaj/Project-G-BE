package com.epam.hack.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hack.app.util.DateHelper;
import com.epam.hack.model.Transaction;
import com.epam.hack.model.TransactionAggregate;
import com.epam.hack.model.TransactionHistory;

@Service
public class ExpenseAggregateService {

	@Autowired private DateHelper dateHelper;
	
	public Map<LocalDate, TransactionAggregate> getaggregateByMonth(List<TransactionHistory> allTransactionHistories) {
		Map<LocalDate, List<DateExpensePair>> expensesByMonth = consolidateTransactions(allTransactionHistories)
				.stream()
				.map(this::getDateExpensePair)
				.collect(Collectors.groupingBy(DateExpensePair::getDate));
		
		return expensesByMonth.entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> getAggregateForMonth(entry.getValue())));
	}
	
	private List<Transaction> consolidateTransactions (List<TransactionHistory> allTransactionHistory) {
		return allTransactionHistory
				.stream()
				.flatMap(history -> history.getTransactions().stream())
				.collect(Collectors.toList());
	}
	
	private DateExpensePair getDateExpensePair(Transaction transaction) {
		return new DateExpensePair(transaction.getAmount(), dateHelper.getLastDateOfMonth(transaction.getDate()));
	}
	
	private TransactionAggregate getAggregateForMonth(List<DateExpensePair> dateExpensePairs) {
		TransactionAggregate aggregate = new TransactionAggregate();
		aggregate.setExpenses(getSum(dateExpensePairs, pair -> pair.getAmount() >= 0));
		aggregate.setIncome(getSum(dateExpensePairs, pair -> pair.getAmount() < 0));
		return aggregate;
	}
	
	private Double getSum(List<DateExpensePair> dateExpensePairs, Predicate<DateExpensePair> predicateFunc) {
		return dateExpensePairs.stream().filter(predicateFunc).mapToDouble(trans -> trans.getAmount()).sum();
	}
	
	private class DateExpensePair {
		private Double amount;
		private LocalDate date;
		
		public DateExpensePair(Double amount, LocalDate date) {
			this.amount = amount;
			this.date = date;
		}

		public Double getAmount() {
			return amount;
		}

		public LocalDate getDate() {
			return date;
		}
		
	}
}
