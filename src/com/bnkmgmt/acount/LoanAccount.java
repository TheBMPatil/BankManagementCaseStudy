package com.bnkmgmt.acount;


public class LoanAccount extends Account {
	private static int accCnt = 1300;
	
	double loanAmount;
	static double loanAccountInterest = 11.0;

	public LoanAccount(String custumerName, String address, String dateOfBirth, long moNo, double loanAmount) {
		super(custumerName, address, dateOfBirth, moNo);
		this.loanAmount = loanAmount;
		this.accountNo = generateAccountNumber();
	}

	
	private int generateAccountNumber() {
		return accCnt++;
	}

//	public static void setLoanAccountInterest(double loanAccountInterest) {
//		LoanAccount.loanAccountInterest = loanAccountInterest;
//	}

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
		System.out.println("Account Type : Loan Account");
		System.out.println("Acccount Number : " + accountNo);
		System.out.println("Loan Amount : " + loanAmount);
		System.out.println("Intrest rate : " + loanAccountInterest);
		System.out.println("====================================================================");
	}

}
