package com.bnkmgmt.account;

public final class CurrentAccount extends Account {

	private static int accNoCnt = 1100;
	private static String type = "Current";
	private double overDraftLimit;
	private static double currentAccountInterest = 0.07;
	private int transactionIdCnt = 800000;
	private int transactionCount;
	private double outstandingOverdraft; // To track unpaid overdraft

	public CurrentAccount(String custumerName, String address, String dateOfBirth, long moNo) {
		super(custumerName, address, dateOfBirth, moNo);

		this.accountNo = AccountUtility.generateAccountNumber(accNoCnt++);
		this.overDraftLimit = assignOverDraftLimit();
		this.transactionCount = 0;
		this.transactionIdCnt += this.accountNo;
		this.setTransactions(new AccTransaction[50]);
		this.outstandingOverdraft = 0;
	}

	// Assign overdraft limit
	private double assignOverDraftLimit() {
		return this.getBalance() * 1; // Example: Overdraft is equal to balance
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
		double oldBal = this.getBalance();

		// Check if there is an outstanding overdraft
		if (outstandingOverdraft > 0) {

			System.out.println("Outstanding overdraft: " + outstandingOverdraft);

			if (amount >= outstandingOverdraft) {
				amount -= outstandingOverdraft;
				outstandingOverdraft = 0;
				System.out.println("Overdraft fully repaid.");
			} else {
				outstandingOverdraft -= amount;
				System.out.println("Partial overdraft repayment. Remaining overdraft: " + outstandingOverdraft);
				return;
			}
		}

		// Proceed with normal deposit
		this.setBalance(this.getBalance() + amount);
		this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Deposit",
				AccountUtility.currentDate(), oldBal, this.getBalance());

		// Recalculate overdraft limit if outstanding overdraft is fully repaid
		if (outstandingOverdraft == 0) {
			overDraftLimit = assignOverDraftLimit();
		}

		System.out.println("Deposit successful. Amount: " + amount + " | Balance: " + this.getBalance()
				+ " | Overdraft Limit: " + overDraftLimit);
	}

	@Override
	public void withdraw(double amount) {
		if (outstandingOverdraft > 0) {
			System.out.println(
					"Cannot withdraw until the outstanding overdraft of " + outstandingOverdraft + " is repaid.");
			return;
		}

		overDraftLimit = assignOverDraftLimit();
		System.out.println("Available funds (balance + overdraft): " + (this.getBalance() + overDraftLimit));
		double oldBal = this.getBalance();

		if (amount <= this.getBalance()) {
			this.setBalance(this.getBalance() - amount);
			System.out.println("Withdrawal successful. Remaining balance: " + this.getBalance());
			this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Withdraw",
					AccountUtility.currentDate(), oldBal, this.getBalance());

		} else if (amount <= this.getBalance() + overDraftLimit) {
			double overdraftUsed = amount - this.getBalance();
			this.setBalance(0);
			this.outstandingOverdraft += overdraftUsed;
			this.overDraftLimit -= overdraftUsed;

			this.getTransactions()[transactionCount++] = new AccTransaction(transactionIdCnt++, amount, "Withdraw",
					AccountUtility.currentDate(), oldBal, this.getBalance());
			System.out.println("Withdrawal successful using overdraft. Outstanding overdraft: " + outstandingOverdraft);
		} else {
			System.out.println("Insufficient balance or overdraft limit exceeded.");
		}
	}

	@Override
	public void calculateIntrest() {
		// Interest calculation is not applicable for current accounts.
	}

	public void checkBalance() {
		System.out.println("Balance: " + this.getBalance() + " | Outstanding Overdraft: " + outstandingOverdraft);
	}

	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("Account Type          : Current Account");
		System.out.println("Account Number        : " + accountNo);
		System.out.println("Overdraft Limit       : " + overDraftLimit);
		System.out.println("Outstanding Overdraft : " + outstandingOverdraft);
		System.out.println("Interest Rate         : " + (currentAccountInterest * 100) + "%");
		System.out.println("====================================================================");
	}

	@Override
	public String getType() {
		return this.type;
	}

	public int getTransactionCount() {
		return transactionCount;
	}
}
