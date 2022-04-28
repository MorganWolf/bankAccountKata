package com.morgan.kata.bankaccount;

import java.time.LocalDate;

import com.morgan.kata.bankaccount.services.Account;
import com.morgan.kata.bankaccount.services.Displayer;
import com.morgan.kata.bankaccount.services.Ledger;

public class Application {

	public static void main(String[] args) {
		
		Ledger ledger = new Ledger();
		Displayer displayer = new Displayer(System.out);
		Account account = new Account(ledger, displayer);
		LocalDate today = LocalDate.now();
		
		account.deposit(5, today);
		account.deposit(400, today);
		account.deposit(700.50, today);
		account.withdraw(400.47, today);
		account.withdraw(6000, today);

		account.displayLedger();
	}

}
