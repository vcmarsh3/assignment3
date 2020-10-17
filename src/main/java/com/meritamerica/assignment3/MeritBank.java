package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MeritBank {
	static String accountData;
	static long accountNumber;
	static AccountHolder[] accountHolders = new AccountHolder[0];
	static CDOffering[] CDOfferingsArray = new CDOffering[0];
	

	static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] temp = Arrays.copyOf(accountHolders, accountHolders.length + 1);
		accountHolders = temp;
		accountHolders[accountHolders.length-1] = accountHolder;
	}
	
	static AccountHolder[] getAccountHolders(){
		return accountHolders;
	}
	
	static CDOffering[] getCDOfferings() {
		return CDOfferingsArray;
	}
	
	static CDOffering getBestCDOffering(double depositAmount){
		double bestValue = 0.0;
		CDOffering bestOfferingAvailable = null;
		if(CDOfferingsArray == null) {
			return null;
		} else {
			for(CDOffering offering: CDOfferingsArray) {
				if(futureValue(depositAmount, offering.getInterestRate(), offering.getTerm()) > bestValue) {
					bestOfferingAvailable = offering;
					bestValue = futureValue(depositAmount, offering.getInterestRate(), offering.getTerm());
				}
			}
		}
		return bestOfferingAvailable;
		
	}
	
	static CDOffering getSecondBestCDOffering(double depositAmount){
		CDOffering secondBest = null;
		double bestValue = 0.0;
		CDOffering bestOfferingAvailable = null;
		if(CDOfferingsArray == null) {
			return null;
		} else {
			for(CDOffering offering: CDOfferingsArray) {
				if(futureValue(depositAmount, offering.getInterestRate(), offering.getTerm()) > bestValue) {
					secondBest = bestOfferingAvailable;
					bestOfferingAvailable = offering;
					bestValue = futureValue(depositAmount, offering.getInterestRate(), offering.getTerm());
				}
			}
		}
		return secondBest;
	}
	
	static void clearCDOfferings(){
		CDOfferingsArray = null;
	}
	
	static void setCDOfferings(CDOffering[] offerings){
		CDOfferingsArray = offerings;
	}
	
	static long getNextAccountNumber() {
		return accountNumber;
	}
	
	static double totalBalances() {
		double totalBalance = 0.0;
		for(AccountHolder accountHolder: accountHolders) {
			totalBalance += accountHolder.getCombinedBalance();
		}
		return totalBalance;
	}
	
	static double futureValue(double presentValue, double interestRate, int term) {
		double futureValue = presentValue* Math.pow((1+ interestRate),term);
		return futureValue;
	}
	
	static boolean readFromFile(String fileName){
		
		try (BufferedReader rd = new BufferedReader(new FileReader(fileName))){
			//reads first line sets account number
			MeritBank.accountNumber = Long.parseLong(rd.readLine());
			
			//reads line 2 number of cd offerings
			int numOfCDOfferings = Integer.parseInt(rd.readLine());
			
			//keeps reading cd offerings in file
			CDOffering[] cds = new CDOffering[numOfCDOfferings];
			for(int i = 0; i < numOfCDOfferings; i++) {
				cds[i] = CDOffering.readFromString(rd.readLine());
			}
			MeritBank.setCDOfferings(cds);//adds the offerings to the bank
			
			//reads number number of account holders
			int numOfAccountHolders = Integer.parseInt(rd.readLine());
			
			
			for(int i = 0; i < numOfAccountHolders; i++) {
				//reads account holder info for each accountHolder
				AccountHolder holder = AccountHolder.readFromString(rd.readLine());
				
				//reads number of checking accounts
				int numOfChecking = Integer.parseInt(rd.readLine());
				//reads in data for each checking account
				for(int j = 0; j < numOfChecking; j++) {
					MeritBank.accountData = rd.readLine();
					holder.addCheckingAccount(CheckingAccount.readFromString(MeritBank.accountData));
				}
				
				//reads number of Saving accounts
				int numOfSavings = Integer.parseInt(rd.readLine());
				//reads in data for each savings account
				for(int j = 0; j < numOfSavings; j++) {
					MeritBank.accountData = rd.readLine();
					holder.addSavingsAccount(SavingsAccount.readFromString(MeritBank.accountData));
				}
				
				//reads number of CD accounts
				int numOfCDs = Integer.parseInt(rd.readLine());
				//reads in data for each CD account
				for(int j = 0; j < numOfCDs; j++) {
					MeritBank.accountData = rd.readLine();
					holder.addCDAccount(CDAccount.readFromString(MeritBank.accountData));
				}
				//adds AccountHolder to the bank
				MeritBank.addAccountHolder(holder);
			}
		}
		catch(IOException ex){
			System.out.println("did not read because i/o");
			return false;
		}
		catch(Exception e) {
			System.out.println("did not read");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
