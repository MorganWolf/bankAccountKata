package com.morgan.kata.bankaccount.services;

import java.time.LocalDate;

import com.morgan.kata.bankaccount.data.AccountOperation;
import com.morgan.kata.bankaccount.data.Deposit;
import com.morgan.kata.bankaccount.data.Withdraw;


public class Account {
	
	private Ledger ledger;
	private double balance;

	private Displayer displayer;
	
	public Account(Ledger ledger, Displayer displayer) {
		this.ledger = ledger;
		this.balance = 0;
		this.displayer = displayer;
	}
	
	
	/**
	 * Deposit a certain amount to your account
	 * 
	 * @param amount value of the deposit, must be positive
	 * @param date date to when the deposit is saved
	 */
	public void deposit(double amount, LocalDate date) {
		AccountOperation op = new Deposit(date, amount, balance);
		op.executeOperation();
		balance = op.getBalance();
		ledger.addOperation(op);
	}
	
	/**
	 * Withdraw a certain amount from your account
	 * 
	 * @param amount value of the withdraw, must be positive
	 * @param date date to when the deposit is saved
	 */
	public void withdraw(double amount, LocalDate date) {
		AccountOperation op = new Withdraw(date, -amount, balance);
		op.executeOperation();
		balance = op.getBalance();
		ledger.addOperation(op);
	}

	/**
	 * Display the full history of the account operation saved in the ledger using the {@link #displayer} class.
	 * 
	 */
	public void displayLedger() {
		displayer.print(ledger);		
	}


	public double getBalance() {
		return balance;
	}
	
	

}
