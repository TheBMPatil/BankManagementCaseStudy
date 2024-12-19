package com.bnkmgmt.acount;

import java.util.Date;

public class CurrentAccount extends Account {
	
	int accountNo;
	double overDraftLimit;
	static double currentAccountInterest;
	
	
	public CurrentAccount(int customerId, String custumerName, double balance, String address, Date creationDate,
			int accountNo, double overDraftLimit) {
		super(customerId, custumerName, balance, address, creationDate);
		this.accountNo = accountNo;
		this.overDraftLimit = overDraftLimit;
	}

	
	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public double getOverDraftLimit() {
		return overDraftLimit;
	}


	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}


	public static double getCurrentAccountInterest() {
		return currentAccountInterest;
	}


	public static void setCurrentAccountInterest(double currentAccountInterest) {
		CurrentAccount.currentAccountInterest = currentAccountInterest;
	}


	public void depositeAmount(double amount)
	{
		balance += amount;
	}
    
}
