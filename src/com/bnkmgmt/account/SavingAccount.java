package com.bnkmgmt.account;

public final class SavingAccount extends Account {
	private static int accNoCnt = 1200;
	private static String type = "Savings";
	private static double minBalance = 1000;
	private static double savingAccountInterest = 0.04;
	private int transactionIdCnt = 900000;
	private int transactionCount;

	public SavingAccount(String custumerName, String address, String dateOfBirth, long moNo) {
		super(custumerName, address, dateOfBirth, moNo);
		this.accountNo = AccountUtility.generateAccountNumber(accNoCnt++);
		this.transactionCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.setTransactions(new AccTransaction[50]);
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
		double oldBal = this.getBalance();
		// Amt deposit nd update bal
		this.setBalance(this.getBalance() + amount);
		// Add Trasansaction into transactions Array
		this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Deposit",
				AccountUtility.currentDate(), oldBal, this.getBalance());
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdraw(double amount) {

		if (this.getBalance() - amount <= minBalance) {
			System.out.println("Withdrawal not allowed. Minimum balance requirement will be violated.");
			return;
		} else {
			double oldBal = this.getBalance();

			this.setBalance(this.getBalance() - amount);
			// Add Trasansaction into transactions Array
			this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Withdrow",
					AccountUtility.currentDate(), oldBal, this.getBalance());

			System.out.println("You have withdraw Rs." + amount + " and Remaining Balance is " + this.getBalance());
		}

	}

	@Override
	public void calculateIntrest() {
		if (this.getBalance() > minBalance) {
			double oldBal = this.getBalance();
			double intrest = (this.getBalance() * savingAccountInterest);
			this.setBalance(this.getBalance() + intrest);
			// Add Trasansaction into transactions Array
			this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, intrest, "Deposit-INT",
					AccountUtility.currentDate(), oldBal, this.getBalance());

		}

	}

	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	public int getTransactionCount() {
		return transactionCount;
	}

	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type            : Savings Account");
		System.out.println("Account Number          : " + accountNo);
		System.out.println("Minimum Balance Limit   : " + minBalance);
		System.out.println("Interest Rate           : " + (savingAccountInterest * 100) + "%");
		System.out.println("====================================================================");
	}

}
