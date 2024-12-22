package com.bnkmgmt.acount;

public class SavingAccount extends Account {
	static int accNoCnt = 1200;

	
	static double minBalance = 1000;
	static double savingAccountInterest = 4.0;

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
		System.out.println("Balance : " + this.getBalance());
	}

	@Override
	public void deposite(double amount) {

		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdrow(double amount) {
		double temp = this.getBalance();
		if (temp - amount <= minBalance) {
			System.out.println("Withdrawal not allowed. Minimum balance requirement will be violated.");
			return;
		} else {
			temp -= amount;
			this.setBalance(temp);
			System.out.println("You have withdraw Rs." + amount + " and Remaining Balance is " + this.getBalance());
		}

	}

	@Override
	public void calculateIntrest(double amount) {
		// TODO Auto-generated method stub

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
