package com.morgan.kata.bankaccount.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.morgan.kata.bankaccount.data.Deposit;

@ExtendWith(MockitoExtension.class)
class LedgerTest {
	
	@Mock
	private Deposit deposit;
	
	private Ledger ledger;
	
	@Test
	void ledger_creation() {
		
		ledger = new Ledger();
		
		assertTrue(ledger.getAccountOperations().isEmpty());
	}
	
	@Test
	void ledger_add_account_operation() {
		
		ledger = new Ledger();
		
		ledger.addOperation(deposit);
		
		assertEquals(1, ledger.getAccountOperations().size());
		assertEquals(ledger.getAccountOperations().get(0), deposit);
		
	}
	
}
