package com.morgan.kata.bankaccount.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class WithdrawTest {
	
	private Withdraw withdraw;	
	
	@Test
	void withdraw_creation() {
		
		double withdraw_value = 100;
		double balance = 100;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		withdraw = new Withdraw(expected_date, withdraw_value, balance);
		
		assertEquals(expected_date, withdraw.getDate());
		assertEquals(withdraw_value, withdraw.getAmount());
		assertEquals(balance, withdraw.getBalance());
	}
	
	
	@Test
	void withdraw_execute() {
		
		double withdraw_value = 100;
		double balance = 100;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		withdraw = new Withdraw(expected_date, -withdraw_value, balance);
		
		withdraw.executeOperation();
		assertEquals(balance - withdraw_value, withdraw.getBalance());	
		
	}
}
