package com.bnkmgmt.acount;

import java.util.Date;

public abstract class Account {

	int customerId;
	String custumerName;
	double balance;
	String address;
	Date creationDate;

	public Account(int customerId, String custumerName, double balance, String address, Date creationDate) {
		this.customerId = customerId;
		this.custumerName = custumerName;
		this.balance = balance;
		this.address = address;
		this.creationDate = creationDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustumerName() {
		return custumerName;
	}

	public void setCustumerName(String custumerName) {
		this.custumerName = custumerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public abstract void depositeAmount(double amount);

}
