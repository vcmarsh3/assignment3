/**
package com.meritamerica.assignment3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Vanessa Marsh , Andres Magana
 *
 */
public class CDAccount extends BankAccount {
	CDOffering offering;
	private int term;
	
	
	public CDAccount(CDOffering offering, double openBalance) {
		super(openBalance,offering.getInterestRate());
		this.offering = offering;
		this.term = offering.getTerm();
	}
	
	public CDAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn, int term) {
		super(accountNumber, balance,interestRate,accountOpenedOn);
		this.term = term;
	}
	
	public int getTerm() {
		return this.term;
	}
	
	public Date getStartDate(){
		return date;
	}
	
	public double futureValue() {
		return super.futureValue(term);
	}
	
	
	public boolean withdraw(double amount) {
        return false;
    }
    
    public boolean deposit(double amount) {
    	return false;
    }
    
    
}
