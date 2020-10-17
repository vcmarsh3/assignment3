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
	
	public boolean withdraw(double amount) {
        if(amount <= this.balance && amount >= 0) {
        	this.balance =- amount;
        	return true;
        }
        else {
    		return false;       	
        }
    }
	
    public boolean deposit(double amount) {
    	if(amount >= 0) {
        	this.balance =+ amount;
        	return true;
        }
        else {
    		return false;       	
        }
    }
	
	public static BankAccount readFromString(String accountData) throws ParseException, NumberFormatException {
	    try {
	    	String[] holding = accountData.split(",");
	    	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	    	
	    	//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate
	    	//might throw exception
	    	long accountNumber = Long.parseLong(holding[0]);
	    	double balance = Double.parseDouble(holding[1]);
	    	double interestRate = Double.parseDouble(holding[2]);
	    	Date accountOpenedOn = date.parse(holding[3]);
	    	
	    	//creates the Bank account
	    	return new BankAccount(accountNumber, balance, interestRate,accountOpenedOn);
	    	}
	    catch (Exception e){
	    	System.out.println("couldn't read bank account");
	    	return null;
	    }
	    
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
