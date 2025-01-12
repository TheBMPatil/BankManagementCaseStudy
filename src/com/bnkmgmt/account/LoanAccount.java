package com.bnkmgmt.account;

public final class LoanAccount extends Account {
	private static int accCnt = 1300;
	private static String type = "Loan";
	private double loanAmount;
	private static double loanAccountInterest = 0.11;
	private int transactionIdCnt = 300000;
	private int transactionCount;

	public LoanAccount(String custumerName, String address, String dateOfBirth, long moNo, double loanAmount) {
		super(custumerName, address, dateOfBirth, moNo);
		this.loanAmount = loanAmount;
		this.accountNo = AccountUtility.generateAccountNumber(accCnt++);
		this.setBalance(loanAmount);
		this.transactionCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.setTransactions(new AccTransaction[50]);
		calculateIntrest();
	}

//	public static void setLoanAccountInterest(double loanAccountInterest) {
//		LoanAccount.loanAccountInterest = loanAccountInterest;
//	}

	@Override
	public void deposit(double amount) {
		double oldBal = this.getBalance();
		this.setBalance(this.getBalance() + amount);
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());
		this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Deposit",
				AccountUtility.currentDate(), oldBal, this.getBalance());
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
		double oldBal = this.getBalance();
		double intrest = (loanAmount * loanAccountInterest) / 100;
		this.setBalance(this.getBalance() + intrest);

		this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, intrest, "Deposit-INT",
				AccountUtility.currentDate(), oldBal, this.getBalance());

//		System.out.println("Interest on loan amount " + loanAmount + " is: " + interest);
	}

	public void checkBalance() {
		calculateIntrest();
		System.out.println("Balance : " + this.getBalance());
	}

	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type          : Loan Account");
		System.out.println("Account Number        : " + accountNo);
		System.out.println("Loan Amount           : " + loanAmount);
		System.out.println("Interest Rate         : " + (loanAccountInterest * 100) + "%");
		System.out.println("====================================================================");
	}

	public int getTransactionCount() {
		return transactionCount;
	}

}
