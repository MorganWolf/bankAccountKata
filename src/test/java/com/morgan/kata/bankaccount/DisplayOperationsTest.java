package com.morgan.kata.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.morgan.kata.bankaccount.services.Account;
import com.morgan.kata.bankaccount.services.Displayer;
import com.morgan.kata.bankaccount.services.Ledger;

class DisplayOperationsTest {
	
	
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;
	
	private static final String HEADER = "Date               Amount               Balance";
	
	private Account account;
	private Ledger ledger;
	private Displayer displayer;

	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@BeforeEach
	void initialize() {
		ledger = new Ledger();
		displayer = new Displayer(System.out);
		account = new Account(ledger, displayer);
	}
	

	
	@Test
	void display_header_on_no_operation() {
		account.displayLedger();
	    assertEquals(HEADER, outContent.toString());
	}
	
	@Test
	void display_one_deposit() {
		String expected_output = HEADER + '\n' +
								 "01/01/2022         100.00               100.00";
		account.deposit(100, LocalDate.of(2022, 01, 01));
		account.displayLedger();
	    assertEquals(expected_output, outContent.toString());
	}
	
	@Test
	void display_one_withdraw() {
		
		String expected_output = HEADER + '\n' +
								 "01/05/2022         -100.00              -100.00";	
		account.withdraw(100, LocalDate.of(2022, 05, 01));
		account.displayLedger();
	    assertEquals(expected_output, outContent.toString());
	}
	
	@Test
	void display_multiple_deposit_and_withdraw() {
		
		String expected_output = HEADER + '\n' +
								 "21/12/2022         -500.00              -300.00\n"+
								 "05/12/2022         -300.00              200.00\n" +
								 "01/05/2022         400.00               500.00\n" +
								 "01/05/2022         100.00               100.00";
		
		
		account.deposit(100, LocalDate.of(2022, 05, 01));
		account.deposit(400, LocalDate.of(2022, 05, 01));
		account.withdraw(300, LocalDate.of(2022, 12, 05));
		account.withdraw(500, LocalDate.of(2022, 12, 21));
		
		account.displayLedger();
	    assertEquals(expected_output, outContent.toString());
	}
	

}
