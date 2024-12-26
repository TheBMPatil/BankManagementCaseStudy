package com.bnkmgmt.account;

import java.util.Date;

public final class AccTransaction {

	int transactionId;
	double amount;
	String transactionType;
	Date transactionDate;
	double oldBal;
	double newBal;

	public AccTransaction(int transactionId, double amount, String transactionType, Date transactionDate,
			double oldBal, double newBal) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.oldBal = oldBal;
		this.newBal = newBal;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void transactionInfo() {
		System.out.println(transactionId + " \t " + transactionDate.toString() + "\t " + transactionType + "\t " + amount
				+ "\t" + oldBal + "\t" + newBal + "\t");
	}
}
