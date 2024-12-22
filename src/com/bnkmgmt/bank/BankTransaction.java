package com.bnkmgmt.bank;

public class BankTransaction {
	static int tranNo = 9000;
	int tranID;
	int accNo;
	String tranType;
	int tranAmount;

	BankTransaction(int accNo, String type, int amount) {
		this.tranID = tranNo++;
		this.accNo = accNo;
		this.tranType = type;
		this.tranAmount = amount;
	}

	public int getTranID() {
		return tranID;
	}

	public int getAccNo() {
		return accNo;
	}

	public String getTranType() {
		return tranType;
	}

	public int getTranAmount() {
		return tranAmount;
	}

	public void transactionInfo() {
		System.out.println("Transactin Id         : " + tranID);
		System.out.println("Acount no Associiated : " + accNo);
		System.out.println("Type of Transaction   : " + tranType);
		System.out.println("Transactin Amount     : " + tranAmount);

	}
}
