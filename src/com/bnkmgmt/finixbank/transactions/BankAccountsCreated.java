package com.bnkmgmt.finixbank.transactions;

public class BankAccountsCreated {
	static int tranNo = 7000;
	int tranID;
	int accNo;
	int customerId;
	String accountType;

	public BankAccountsCreated(int accNo, String type, int customerId) {
		this.tranID = tranNo++;
		this.accNo = accNo;
		this.accountType = type;
		this.customerId = customerId;
	}

	public int getTranID() {
		return tranID;
	}

	public int getAccNo() {
		return accNo;
	}

	public static int getTranNo() {
		return tranNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setTranID(int tranID) {
		this.tranID = tranID;
	}

	public void transactionInfo() {

		System.out.println(accountType + "\t" + tranID + "\t" + customerId + "\t" + accNo + "\n");

//		System.out.println("Type of Account creaated    : " + accountType);
//		System.out.print("\t Transactin Id         		: " + tranID);
//		System.out.print("Customer Id					: " + customerId);
//		System.out.print("\t Acount no Associiated 		: " + accNo + "\n");

	}
}
