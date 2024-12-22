package com.bnkmgmt.acount;

public class CurrentAccount extends Account {

	private static int accNoCnt = 1100;

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
	public void deposite(double amount) {
		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdrow(double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateIntrest(double amount) {
		// TODO Auto-generated method stub

	}

	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type : Current Account");
		System.out.println("Acccount Number : " + accountNo);
		System.out.println("Over Draft Limit : " + overDraftLimit);
		System.out.println("Intrest rate : " + currentAccountInterest);
		System.out.println("====================================================================");
	}

}
