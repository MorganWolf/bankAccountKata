package com.morgan.kata.bankaccount.data;

import java.time.LocalDate;

import com.morgan.kata.bankaccount.services.Account;


/**
 * Interface representing the data save from an operation involving the balance of an {@link Account}
 *
 */

public interface AccountOperation {
	
	/**
	 * Executing the calculation and updating the balance of the operation
	 *
	 */
	public void executeOperation();
	
	public LocalDate getDate();
	public double getBalance();
	public double getAmount();

}
