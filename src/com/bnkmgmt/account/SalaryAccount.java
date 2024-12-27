package com.bnkmgmt.account;

public final class SalaryAccount extends Account {
	private static int accCnt = 1400;
	private double pfAmount;
	private static String type = "Salary";
	private static int transactionsLimit = 10;
	private int transactionCount;
	private int transactionIdCnt = 20000;
	private int transactionsLimitCount;

	private static double salaryAccountInterest = 0.03;

	public SalaryAccount(String custumerName, String address, String dateOfBirth, long moNo, double pf) {
		super(custumerName, address, dateOfBirth, moNo);
		this.accountNo = AccountUtility.generateAccountNumber(accCnt++);
		this.pfAmount = pf;
		this.transactionCount = 0;
		this.transactionsLimitCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.setTransactions(new AccTransaction[50]);
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
		double oldBal = this.getBalance();
		this.setBalance(this.getBalance() + amount);
		this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Deposit",
				AccountUtility.currentDate(), oldBal, this.getBalance());
		System.out.println("Deposite successfull of amount : " + amount + " \n Balance : " + this.getBalance());

	}

	@Override
	public void withdraw(double amount) {

//		long months = AccountUtility.getDateDifferenseInMonths(this.getTransactions()[transactionCount-1].transactionDate);
		long mins = AccountUtility
				.getDateDifferenceInMinutes(this.getTransactions()[transactionCount - 1].transactionDate);

//		if (months >= 3) {
		if (mins >= 1) {
			this.setFreez();
			System.out.println("Account frozen. Cant do transaction contact to admin.");
		} else {
			// TODO Auto-generated method stub
			if (transactionsLimitCount >= transactionsLimit) {
				System.out.println("Transactions Limit reached  can't withdrow...!");
				return;
			} else if (this.getBalance() < amount) {
				System.out.println("InSufficient Balance  : " + this.getBalance());
				return;

			} else {
				transactionsLimitCount++;
				double oldBal = this.getBalance();
				System.out.println("Transaction Number : " + transactionsLimitCount);

				this.setBalance(this.getBalance() - amount);
				this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Withdrow",
						AccountUtility.currentDate(), oldBal, this.getBalance());
				System.out.println("Withdrowal success..!");
				System.out.println("Balance : " + this.getBalance());

			}
		}
	}

	@Override
	public void calculateIntrest() {
		double oldBal = this.getBalance();
		double intrest = this.getBalance() * (salaryAccountInterest / 100);
//		System.out.println("Interest Calculated: " + interest);
		this.setBalance(this.getBalance() + intrest);
		this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, intrest, "Deposit-INT",
				AccountUtility.currentDate(), oldBal, this.getBalance());
	}

	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type                : Salary Account");
		System.out.println("Account Number              : " + accountNo);
		System.out.println("PF Amount                   : " + pfAmount);
		System.out.println("Interest Rate               : " + (salaryAccountInterest * 100) + "%");
		System.out.println("Maximum Transaction Limit   : " + transactionsLimit);
		System.out.println("Number of Transactions Remaining : " + (transactionsLimit - transactionsLimitCount));
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
