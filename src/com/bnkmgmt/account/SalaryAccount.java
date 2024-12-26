package com.bnkmgmt.account;

public class SalaryAccount extends Account {
	private static int accCnt = 21000;
	private double pfAmount;
	private static String type = "Salary";
	private static int transactionsLimit = 10;
	private int transactionCount;
	private int transactionIdCnt = 20000;
	private int transactionsLimitCount;

	private static double salaryAccountInterest = 3.0;

	public SalaryAccount(String custumerName, String address, String dateOfBirth, long moNo, double pf) {
		super(custumerName, address, dateOfBirth, moNo);
		this.accountNo = AccountUtility.generateAccountNumber(accCnt++);
		this.pfAmount = pf;
		this.transactionCount = 0;
		this.transactionsLimitCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.transactions = new AccTransaction[50];
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

	public void resetTransactions() {
		transactionsLimitCount = 0;
		System.out.println("Transactions count reset to 0.");
	}

	@Override
	public void deposit(double amount) {

		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());

	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if (transactionsLimitCount >= transactionsLimit) {
			System.out.println("Transactions Limit reached  can't withdrow...!");
			return;
		} else if (this.getBalance() < amount) {
			System.out.println("InSufficient Balance  : " + this.getBalance());
			return;

		} else {
			transactionsLimitCount++;
			System.out.println("Transaction Number : " + transactionsLimitCount);
			this.setBalance(this.getBalance() - amount);
			System.out.println("Withdrowal success..!");
			System.out.println("Balance : " + this.getBalance());

		}
	}

	@Override
	public void calculateIntrest() {
		double interest = this.getBalance() * (salaryAccountInterest / 100);
//		System.out.println("Interest Calculated: " + interest);
		this.setBalance(this.getBalance() + interest);
	}

	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type 				: Salary Account");
		System.out.println("Acccount Number 			: " + accountNo);
		System.out.println("PF Amount 			: " + pfAmount);
		System.out.println("Intrest rate				: " + salaryAccountInterest);
		System.out.println("Maximam Transaction limit 	: " + transactionsLimit);
		System.out.println("No of transactions remaining : " + (transactionsLimit - transactionsLimitCount));
		System.out.println("====================================================================");
	}

	public void checkBalance() {

		calculateIntrest();
		System.out.println("Balance : " + this.getBalance());
	}

	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	public int getTransactionCount() {
		return transactionCount;
	}

}
