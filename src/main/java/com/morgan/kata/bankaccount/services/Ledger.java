package com.morgan.kata.bankaccount.services;

import java.util.ArrayList;
import java.util.List;

import com.morgan.kata.bankaccount.data.AccountOperation;


/**
 *	Repository of every {@link AccountOperation} saved from an account
 *
 */
public class Ledger {
	
	private List<AccountOperation> accountOperations;
	
	public Ledger() {
		accountOperations = new ArrayList<>();
	}
	
	public void addOperation(AccountOperation accountOperation) {
		accountOperations.add(accountOperation);
	}

	public List<AccountOperation> getAccountOperations() {
		return accountOperations;
	}
	
}
