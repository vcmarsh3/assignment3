package com.meritamerica.assignment3;
import java.util.ArrayList;
import java.util.Arrays;

public class CDOffering {
	private int term;
	private double interestRate;

	public CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}

	public int getTerm() {
		return term;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

    static CDOffering readFromString(String cdOfferingDataString) {
    	String[] holding = cdOfferingDataString.split(",");
    	int term = Integer.parseInt(holding[0]);
    	double interestRate = Double.parseDouble(holding[1]);
    	return new CDOffering(term, interestRate);
    }

    public String writeToString() {
    	StringBuilder cdOfferingData = new StringBuilder();
    	cdOfferingData.append(term).append(",");
    	cdOfferingData.append(interestRate);
    	return cdOfferingData.toString(); 
    }
}

