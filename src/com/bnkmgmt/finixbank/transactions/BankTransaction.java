package com.bnkmgmt.finixbank.transactions;

public class BankTransaction {
	static int tranNo = 9000;
	int tranID;
	int accNo;
	String tranType;
	double tranAmount;

	public BankTransaction(int accNo, String type, double amount) {
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

	public double getTranAmount() {
		return tranAmount;
	}

	public void transactionInfo() {

		System.out.println(tranID + "\t" + accNo + "\t" + tranType + "\t" + tranAmount + "\n");

//		System.out.println("Transactin Id         : " + tranID);
//		System.out.print("\tAcount no Associiated : " + accNo);
//		System.out.println("Type of Transaction   : " + tranType);
//		System.out.print("\nTransactin Amount     : " + tranAmount);

	}
}
