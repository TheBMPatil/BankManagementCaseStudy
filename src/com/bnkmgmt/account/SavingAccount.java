package com.bnkmgmt.account;

public class SavingAccount extends Account {
	static int accNoCnt = 1200;
	static String type = "Savings";
	static double minBalance = 1000;
	static double savingAccountInterest = 0.04;

	public SavingAccount(String custumerName, String address, String dateOfBirth, long moNo) {
		super(custumerName, address, dateOfBirth, moNo);
		this.accountNo = assignAccNo();

	}

	private int assignAccNo() {

		return accNoCnt++;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public static double getSavingAccountInterest() {
		return savingAccountInterest;
	}

//	public double calculateDailyInterestRate() {
//		double dailyInterestRate = SavingAccount.savingAccountInterest / 365;
//		return dailyInterestRate;
//
//	}

//	public void updateBalanceWithInterest(Date lastTransactionDate) {
//		Date currentDate = null;
////        long totalDays = DaysBetweenTransactions.calculateDaysBetweenDates(lastTransactionDate, currentDate); 
////        balance += balance * calculateDailyInterestRate() * totalDays; 
//	}

	public void checkBalance() {
//		Date lastTransactionDate = new Date();
//		Date currentDate= 12/10/2022;
//		updateBalanceWithInterest(TranscationOfSavingAccount.getLastTranscationDate());
		calculateIntrest();
		System.out.println("Balance : " + this.getBalance());
	}

	@Override
	public void deposit(double amount) {

		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdraw(double amount) {

		if (this.getBalance() - amount <= minBalance) {
			System.out.println("Withdrawal not allowed. Minimum balance requirement will be violated.");
			return;
		} else {

			this.setBalance(this.getBalance() - amount);
			System.out.println("You have withdraw Rs." + amount + " and Remaining Balance is " + this.getBalance());
		}

	}

	@Override
	public void calculateIntrest() {
		if (this.getBalance() > minBalance) {
			this.setBalance(this.getBalance() * savingAccountInterest);
		}

	}

	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type : Savings Account");
		System.out.println("Acccount Number : " + accountNo);
		System.out.println("Min. Bal. Limit : " + minBalance);
		System.out.println("Intrest rate : " + savingAccountInterest);
		System.out.println("====================================================================");
	}

}
