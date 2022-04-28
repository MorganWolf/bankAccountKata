package com.morgan.kata.bankaccount.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DepositTest {
	
	private Deposit deposit;	
	
	@Test
	void deposit_creation() {
		
		double deposit_value = 100;
		double balance = 100;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		deposit = new Deposit(expected_date, deposit_value, balance);
		
		assertEquals(expected_date, deposit.getDate());
		assertEquals(deposit_value, deposit.getAmount());
		assertEquals(balance, deposit.getBalance());
	}
	
	
	@Test
	void deposit_execute() {
		
		double deposit_value = 100;
		double balance = 100;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		deposit = new Deposit(expected_date, deposit_value, balance);
		
		deposit.executeOperation();
		assertEquals(balance + deposit_value, deposit.getBalance());	
		
	}
	

}
