package com.morgan.kata.bankaccount.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.morgan.kata.bankaccount.data.AccountOperation;
import com.morgan.kata.bankaccount.data.Deposit;

@ExtendWith(MockitoExtension.class)
class DisplayerTest {
	
	private static final String HEADER = "Date               Amount               Balance";
	
	@Mock
	Ledger ledger;
	
	@Mock
	Deposit deposit;
	
	@Mock
	AccountOperation accountoperation;
	
	@Mock
	PrintStream printStream;	
	
	Displayer displayer;
	
	
	
	@BeforeEach
	void initialize() {
		displayer = new Displayer(printStream);
	}
	
	@Test
	void print_header_on_empty_ledger() {
		
		displayer.print(ledger);
		
		verify(printStream).print(HEADER);
	}
	
	@Test
	void print_one_deposit() {
		LocalDate expected_date = LocalDate.of(2022,01,01);
		Double expected_amount = 100.0;
		Double expect_balance = 100.0;
		String expected_output = HEADER + '\n' +
								 "01/01/2022         100.00               100.00";
		
		ArrayList<AccountOperation> arr = new ArrayList<>();
		arr.add(accountoperation);
		
		when(ledger.getAccountOperations()).thenReturn(arr);
		when(accountoperation.getDate()).thenReturn(expected_date);
		when(accountoperation.getAmount()).thenReturn(expected_amount);
		when(accountoperation.getBalance()).thenReturn(expect_balance);
		
		displayer.print(ledger);
		System.out.println(expected_output);
		verify(printStream).print(expected_output);
	}
	
	@Test
	void print_one_withdraw() {
		LocalDate expected_date = LocalDate.of(2022,01,01);
		Double expected_amount = -1000.0;
		Double expect_balance = 0.0;
		String expected_output = HEADER + '\n' +
								 "01/01/2022         -1000.00             0.00";
		ArrayList<AccountOperation> arr = new ArrayList<>();
		arr.add(accountoperation);
		
		when(ledger.getAccountOperations()).thenReturn(arr);
		when(accountoperation.getDate()).thenReturn(expected_date);
		when(accountoperation.getAmount()).thenReturn(expected_amount);
		when(accountoperation.getBalance()).thenReturn(expect_balance);
		
		displayer.print(ledger);
		
		verify(printStream).print(expected_output);
	}
	
	@Test
	void print_multiple_deposit() {
		LocalDate[] expected_date = {LocalDate.of(2022,01,01), LocalDate.of(2022,01,02), LocalDate.of(2022,01,03)};
		Double[] expected_amount = {1.0, 200.0, 3000000.0};
		Double[] expect_balance = {100.0, 500.0, 1000.0};
		
		String expected_output = HEADER + '\n' +
								 "01/01/2022         1.00                 100.00\n" +
								 "02/01/2022         200.00               500.00\n" +
								 "03/01/2022         3000000.00           1000.00";
		
		ArrayList<AccountOperation> arr = new ArrayList<>();
		arr.add(accountoperation);
		arr.add(accountoperation);
		arr.add(accountoperation);
		
		when(ledger.getAccountOperations()).thenReturn(arr);
		

		when(accountoperation.getDate()).thenReturn(expected_date[0], expected_date[1], expected_date[2]);
		when(accountoperation.getAmount()).thenReturn(expected_amount[0], expected_amount[1] ,expected_amount[2]);
		when(accountoperation.getBalance()).thenReturn(expect_balance[0], expect_balance[1], expect_balance[2]);
		
		displayer.print(ledger);
		
		verify(printStream).print(expected_output);
	}
	
	@Test
	void print_multiple_withdraw() {
		LocalDate[] expected_date = {LocalDate.of(2022,01,01), LocalDate.of(2022,01,02), LocalDate.of(2022,01,03)};
		Double[] expected_amount = {-1.0, -200.0, -3000000.0};
		Double[] expect_balance = {100.0, -500.0, 1000.0};
		
		String expected_output = HEADER + '\n' +
								 "01/01/2022         -1.00                100.00\n" +
								 "02/01/2022         -200.00              -500.00\n" +
								 "03/01/2022         -3000000.00          1000.00";
		
		ArrayList<AccountOperation> arr = new ArrayList<>();
		arr.add(accountoperation);
		arr.add(accountoperation);
		arr.add(accountoperation);
		
		when(ledger.getAccountOperations()).thenReturn(arr);
		

		when(accountoperation.getDate()).thenReturn(expected_date[0], expected_date[1], expected_date[2]);
		when(accountoperation.getAmount()).thenReturn(expected_amount[0], expected_amount[1] ,expected_amount[2]);
		when(accountoperation.getBalance()).thenReturn(expect_balance[0], expect_balance[1], expect_balance[2]);
		
		displayer.print(ledger);
		verify(printStream).print(expected_output);
	}
	
	
	
	

}
