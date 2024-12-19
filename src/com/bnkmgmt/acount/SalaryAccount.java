package com.bnkmgmt.acount;

import java.util.Date;

public class SalaryAccount extends Account {
	
	int accountNo;
	double pfAmount;
	static double salaryAccountInterest;
	public SalaryAccount(int customerId, String custumerName, double balance, String address, Date creationDate,
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
	
	public static double getSalaryAccountInterest() {
		return salaryAccountInterest;
	}
	
	public static void setSalaryAccountInterest(double salaryAccountInterest) {
		SalaryAccount.salaryAccountInterest = salaryAccountInterest;
	}
	
	public void depositeAmount(double amount)
	{
		balance += amount;
	}
		
	
}
