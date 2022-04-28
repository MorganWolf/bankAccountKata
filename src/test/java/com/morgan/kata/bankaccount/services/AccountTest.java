package com.morgan.kata.bankaccount.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.morgan.kata.bankaccount.data.Deposit;
import com.morgan.kata.bankaccount.data.Withdraw;

@ExtendWith(MockitoExtension.class)
class AccountTest {
	
	@Mock
	private Ledger ledger;
	
	@Mock
	private Displayer displayer;
	
	private Account account;
	
	
	
	@BeforeEach
	void initialize() {
		account = new Account(ledger, displayer);
	}
	
	@Test
	void desposit_an_amount() {
		double amount = 100;
		double balance = 100;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		account.deposit(amount, expected_date);
		
		assertEquals(amount, account.getBalance());
		verify(ledger).addOperation(refEq(new Deposit(expected_date, amount, balance)));
	}
	
	@Test
	void withdraw_an_amount() {
		double amount = 100;
		double balance = 100;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		account.withdraw(amount, expected_date);
		
		assertEquals(-amount, account.getBalance());
		verify(ledger).addOperation(refEq(new Withdraw(expected_date, -amount, -balance)));
	}
	
	@Test
	void deposit_a_negative_amount() {
		double amount = -100;
		double balance = 0;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		account.deposit(amount, expected_date);
		
		assertEquals(balance, account.getBalance());
	}
	
	@Test
	void withdraw_a_negative_amount() {
		double amount = -100;
		double balance = 0;
		LocalDate expected_date = LocalDate.of(2022, 05, 01);
		
		account.withdraw(amount, expected_date);
		
		assertEquals(balance, account.getBalance());
	}	

	@Test
	void display_ledger() {
		account.displayLedger();	
		verify(displayer).print(ledger);
	}
}
