package com.morgan.kata.bankaccount.services;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.morgan.kata.bankaccount.data.AccountOperation;

/**
 * Class defining how the {@link Ledger} is printed and the output {@link #printStream} where it is printed
 *
 */
public class Displayer {
	
	private PrintStream printStream;
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
	private static final String HEADER = "Date               Amount               Balance";
	
	public Displayer(PrintStream printStream) {
		this.printStream = printStream;
		DECIMAL_FORMAT.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	}

	public void print(Ledger ledger) {
		StringBuilder s = new StringBuilder();
		s.append(HEADER);
		List<AccountOperation> accountOperations = ledger.getAccountOperations();
		Collections.reverse(accountOperations);
		for(AccountOperation op : accountOperations) {
			String date = op.getDate().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
			String amount = DECIMAL_FORMAT.format(op.getAmount());
			String balance = DECIMAL_FORMAT.format(op.getBalance());
			s.append('\n');
			s.append(date);
			// date is 4 characters and the actual date is 10 and the space between date and amount is 15 -> 4 + 15 - 10 = 9
			s.append(numberOfSpace(9));
			s.append(amount);
			// Amount is 6 and space between amount and balance is 15 -> 6 + 15 - amount.length
			s.append(numberOfSpace(21 - amount.length()));
			s.append(balance);
		}
		printStream.print(s.toString());
	}
	

	
	
	private StringBuilder numberOfSpace(int n) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < n; i++) {
			s.append(' ');
		}
		return s;
	}

}
