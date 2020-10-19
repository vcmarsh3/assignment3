package com.meritamerica.assignment3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class CheckingAccount extends BankAccount {
	public static final double INTEREST_RATE = 0.0001;
	
	public CheckingAccount(double openBalance){
		super(openBalance, INTEREST_RATE);
	}
	
	public CheckingAccount (long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
	}


	public static CheckingAccount readFromString(String accountData) throws ParseException, NumberFormatException {
	    	String[] holding = accountData.split(",");
	    	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	    	
	    	//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate
	    	//might throw exception
	    	long accountNumber = Long.parseLong(holding[0]);
	    	double balance = Double.parseDouble(holding[1]);
	    	double interestRate = Double.parseDouble(holding[2]);
	    	Date accountOpenedOn = date.parse(holding[3]);
	    	
	    	//creates the Bank account
	    	return new CheckingAccount(accountNumber, balance, interestRate,accountOpenedOn);
    }   
	
}
