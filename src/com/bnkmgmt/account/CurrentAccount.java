package com.bnkmgmt.account;

public class CurrentAccount extends Account {

	private static int accNoCnt = 1100;
	static String type = "Current";
	double overDraftLimit;
	static double currentAccountInterest = 7.00;
	static int transactionIdCnt = 800000;
	int transactionCount;

	public CurrentAccount(String custumerName, String address, String dateOfBirth, long moNo) {
		super(custumerName, address, dateOfBirth, moNo);

		this.accountNo = AccountUtility.generateAccountNumber(accNoCnt++);
		this.overDraftLimit = assignrOverDraftLimit();
		this.transactionCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.transactions = new AccTransaction[50];
	}

//Assign overdraaft Limit
	private double assignrOverDraftLimit() {

		return this.getBalance() * 0.5;
	}

//Auto Generaate ACccc no

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	public static double getCurrentAccountInterest() {
		return currentAccountInterest;
	}

	@Override
	public void deposit(double amount) {
		double oldBal = this.getBalance();
		this.setBalance(this.getBalance() + amount);
		// Add Trasansaction into transactions Array
		transactions[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Deposit",
				AccountUtility.currentDate(), oldBal, this.getBalance());

		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdraw(double amount) {
		double oldBal = this.getBalance();
		if (amount <= this.getBalance()) {
			this.setBalance(this.getBalance() - amount);
			System.out.println("Withdrawal successful. Remaining balance: " + this.getBalance());
			// Add Trasansaction into transactions Array
			transactions[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Withdrow",
					AccountUtility.currentDate(), oldBal, this.getBalance());

		} else if (amount <= this.getBalance() + overDraftLimit) {
			double overdraftUsed = amount - this.getBalance();
			this.setBalance(0);
			this.overDraftLimit -= overdraftUsed;
			// Add Trasansaction into transactions Array
			transactions[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Withdrow",
					AccountUtility.currentDate(), oldBal, this.getBalance());
			System.out.println(
					"Withdrawal successful using overdraft. Remaining overdraft limit: " + this.overDraftLimit);
		} else {
			System.out.println("Insufficient balance or overdraft limit exceeded.");
		}
	}

//	@Override
//	public void withdraw(double amount) {
//		// TODO Auto-generated method stub
//		if (amount < overDraftLimit) {
//			this.setBalance(this.getBalance() - amount);
//		} else {
//			System.out.println("Insufficiant balance");
//		}
//
//	}

	@Override
	public void calculateIntrest() {
//		System.out.println("Interest calculation is not applicable for current accounts.");

	}

	public void checkBalance() {
//		calculateIntrest();
		System.out.println("Balance : " + this.getBalance());
	}

	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type : Current Account");
		System.out.println("Acccount Number : " + accountNo);
		System.out.println("Over Draft Limit : " + overDraftLimit);
		System.out.println("Intrest rate : " + currentAccountInterest);
		System.out.println("====================================================================");
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	public int getTransactionCount() {
		return transactionCount;
	}

}
