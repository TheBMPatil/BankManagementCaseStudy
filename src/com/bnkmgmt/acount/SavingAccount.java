package com.bnkmgmt.acount;

import java.util.Date;

public class SavingAccount extends Account {

	int accountNo;
	double minBalance;
	static double savingAccountInterest;

	public SavingAccount(int customerId, String custumerName, double balance, String address, Date creationDate,
			int accountNo, double minBalance) {
		super(customerId, custumerName, balance, address, creationDate);
		this.accountNo = accountNo;
		this.minBalance = minBalance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public static double getSavingAccountInterest() {
		return savingAccountInterest;
	}

	public static void setSavingAccountInterest(double savingAccountInterest) {
		SavingAccount.savingAccountInterest = savingAccountInterest;
	}

	public void withdraw(double amount) {
		double temp = this.balance;
		if (temp - amount <= 1000) {
			System.out.println("Withdrawal not allowed. Minimum balance requirement will be violated.");
			return;
		} else {
			this.balance -= amount;
			System.out.println("You have withdraw Rs." + amount + " and Remaining Balance is " + this.balance);
		}
	}

	public double calculateDailyInterestRate() {
		double dailyInterestRate = SavingAccount.savingAccountInterest / 365;
		return dailyInterestRate;

	}

	public void updateBalanceWithInterest(Date lastTransactionDate) {
		Date currentDate = null;
//        long totalDays = DaysBetweenTransactions.calculateDaysBetweenDates(lastTransactionDate, currentDate); 
//        balance += balance * calculateDailyInterestRate() * totalDays; 
	}

	public void depositeAmount(double amount) {
		balance += amount;
	}

	public void checkBalance() {
		Date lastTransactionDate = new Date();
//		Date currentDate= 12/10/2022;
//		updateBalanceWithInterest(TranscationOfSavingAccount.getLastTranscationDate());

	}

}
