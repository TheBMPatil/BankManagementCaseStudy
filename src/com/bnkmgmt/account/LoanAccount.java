package com.bnkmgmt.account;

public class LoanAccount extends Account {
	private static int accCnt = 1300;
	static String type = "Loan";
	double loanAmount;
	static double loanAccountInterest = .11;
	static int transactionIdCnt = 300000;
	int transactionCount;

	public LoanAccount(String custumerName, String address, String dateOfBirth, long moNo, double loanAmount) {
		super(custumerName, address, dateOfBirth, moNo);
		this.loanAmount = loanAmount;
		this.accountNo = AccountUtility.generateAccountNumber(accCnt++);
		this.setBalance(loanAmount);
		calculateIntrest();
		this.transactionCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.transactions = new AccTransaction[50];
	}

//	public static void setLoanAccountInterest(double loanAccountInterest) {
//		LoanAccount.loanAccountInterest = loanAccountInterest;
//	}

	@Override
	public void deposit(double amount) {
		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
	}

	@Override
	public void withdraw(double amount) {

		System.out.println("Withdrawal is not allowed from a loan account.");

//		if (this.getBalance() >= amount) {
//		    this.setBalance(this.getBalance() - amount);
//		    System.out.println("Withdrawal successful: " + amount);
//		    System.out.println("Remaining Balance: " + this.getBalance());
//		} else {
//		    System.out.println("Insufficient balance for withdrawal.");
//		}

	}

	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void calculateIntrest() {

		double interest = (loanAmount * loanAccountInterest) / 100;
		this.setBalance(this.getBalance() + interest);
//		System.out.println("Interest on loan amount " + loanAmount + " is: " + interest);
	}

	public void checkBalance() {
		calculateIntrest();
		System.out.println("Balance : " + this.getBalance());
	}

	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type : Loan Account");
		System.out.println("Acccount Number : " + accountNo);
		System.out.println("Loan Amount : " + loanAmount);
		System.out.println("Intrest rate : " + loanAccountInterest);
		System.out.println("====================================================================");
	}

	public int getTransactionCount() {
		return transactionCount;
	}

}
