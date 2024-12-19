package com.bnkmgmt.acount;

import java.util.Date;

public class LoanAccount extends Account {

	int accountNo;
	double pfAmount;
	static double loanAccountInterest;

	public LoanAccount(int customerId, String custumerName, double balance, String address, Date creationDate,
			int accountNo, double pfAmount) {
		super(customerId, custumerName, balance, address, creationDate);
		this.accountNo = accountNo;
		this.pfAmount = pfAmount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getPfAmount() {
		return pfAmount;
	}

	public void setPfAmount(double pfAmount) {
		this.pfAmount = pfAmount;
	}

	public static double getLoanAccountInterest() {
		return loanAccountInterest;
	}

	public static void setLoanAccountInterest(double loanAccountInterest) {
		LoanAccount.loanAccountInterest = loanAccountInterest;
	}

	public void depositeAmount(double amount) {
		balance += amount;
	}

}
