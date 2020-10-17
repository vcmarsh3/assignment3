package com.meritamerica.assignment3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount {
	public static final double INTEREST_RATE = 0.01;
	
	public CheckingAccount(double openBalance, double interestRate){
		super(openBalance, interestRate);
	}
	
	public CheckingAccount (long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
	}


	public static CheckingAccount readFromString(String accountData)throws ParseException {
    	
    		String [] holding = accountData.split(",");
    		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    }   
	
}
