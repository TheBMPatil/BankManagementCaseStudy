package com.bnkmgmt.acount;

public class SalaryAccount extends Account {

	double pfAmount;
	boolean freez = false;
	static int transactionsLimit = 10;
	int transactionsCount = 0;
	static double salaryAccountInterest = 3.0;

	public SalaryAccount(String custumerName, String address, String dateOfBirth, long moNo, double pf) {
		super(custumerName, address, dateOfBirth, moNo);

		this.pfAmount = pf;
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

	@Override
	public void deposite(double amount) {

		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
		this.setBalance(this.getBalance() + amount);

	}

	@Override
	public void withdrow(double amount) {
		// TODO Auto-generated method stub
		if (transactionsCount >= transactionsLimit) {
			System.out.println("Transactions Limit reached  can't withdrow...!");
			return;
		} else if (this.getBalance() < amount) {
			System.out.println("InSufficient Balance  : " + this.getBalance());
			return;

		} else {
			transactionsCount++;
			System.out.println("Transaction Number : " + transactionsCount);
			this.setBalance(this.getBalance() - amount);
			System.out.println("Withdrowal success..!");
			System.out.println("Balance : " + this.getBalance());

		}
	}

	@Override
	public void calculateIntrest(double amount) {
		// TODO Auto-generated method stub

	}

	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type : Salary Account");
		System.out.println("Acccount Number : " + accountNo);
		System.out.println("PF Amount : " + pfAmount);
		System.out.println("Intrest rate : " + salaryAccountInterest);
		System.out.println("Maximam Transaction limit : " + transactionsLimit);
		System.out.println("No of transactions remaining : " + (transactionsLimit - transactionsCount));
		System.out.println("====================================================================");
	}

}
