package com.bnkmgmt.account;

public class CurrentAccount extends Account {

	private static int accNoCnt = 1100;
	static String type = "Current";
	double overDraftLimit;
	static double currentAccountInterest = 7.00;

	public CurrentAccount(String custumerName, String address, String dateOfBirth, long moNo) {
		super(custumerName, address, dateOfBirth, moNo);

		this.accountNo = createAccNo();
		this.overDraftLimit = assignrOverDraftLimit();
	}

//Assign overdraaft Limit
	private double assignrOverDraftLimit() {

		return this.getBalance() * 0.5;
	}

//Auto Generaate ACccc no
	private int createAccNo() {

		return accNoCnt++;
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

	@Override
	public void deposit(double amount) {
		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= this.getBalance()) {
			this.setBalance(this.getBalance() - amount);
			System.out.println("Withdrawal successful. Remaining balance: " + this.getBalance());
		} else if (amount <= this.getBalance() + overDraftLimit) {
			double overdraftUsed = amount - this.getBalance();
			this.setBalance(0);
			this.overDraftLimit -= overdraftUsed;
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

}
