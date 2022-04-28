package com.morgan.kata.bankaccount.data;

import java.time.LocalDate;

public class Deposit implements AccountOperation {
	
	private LocalDate date;
	private double amount;
	private double balance;
	
	
	public Deposit(LocalDate date, double amount, double balance) {
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public void executeOperation() {
		if(amount > 0)
			balance += amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalance() {
		return balance;
	}

}
