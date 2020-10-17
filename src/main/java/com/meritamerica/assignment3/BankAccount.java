package com.meritamerica.assignment3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
	double balance;
	double interestRate;
	static Date accountOpenedOn;
	long  accountNumber;

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
	    this.interestRate = interestRate;
	}
	    
	BankAccount(double balance, double interestRate, Date accountOpenedOn){
		this(balance, interestRate);
		this.accountOpenedOn = accountOpenedOn;
	}
	    
	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn){
		this(balance, interestRate, accountOpenedOn);
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	   
	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public java.util.Date getOpenedOn() {
		return accountOpenedOn;
	}
	
	public static BankAccount readFromString(String accountData)throws ParseException, NumberFormatException {
	    try {
	    	String [] holding = accountData.split(",");
	    	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	    }
	    
	public String writeToString() {
		StringBuilder accountData = new StringBuilder();
		accountData.append(accountNumber).append(",");
		accountData.append(accountOpenedOn).append(",");
		accountData.append(balance).append(",");
		accountData.append(interestRate);
		return accountData.toString();
	}
	    

}
