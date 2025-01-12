package com.bnkmgmt.account;

import java.util.Date;
import java.util.Scanner;

import com.bnkmgmt.finixbank.utils.BankUtils;

public abstract class Account {
Scanner sc = new Scanner(System.in);
	private static int cidcnt = 1000;
	int accountNo;

	private int customerId;
	private String custumerName;
	private double balance;
	private String address;
	private Date creationDate;
	private Date dateOfBirth;
	private long mobileNumber;

	boolean freez = false;
	private static String branchCode = "FinixFB1110";
	private static String IFSC = "FINX0008408";
	private AccTransaction[] transactions;

	public Account(String custumerName, String address, String dateOfBirth, long moNo) {
		this.custumerName = custumerName;
		this.address = address;
		this.dateOfBirth = BankUtils.formatDOB(dateOfBirth);
		this.mobileNumber = moNo;

		this.customerId = AccountUtility.generateCustomerID(cidcnt++);
		this.balance = 0.00;
//		LocalDate lclDate=  LocalDate.now(); 
		this.creationDate = AccountUtility.currentDate();
//				new SimpleDateFormat("yyyy-MM-dd").parse(lclDate.toString());

//				Date.from(lclDate.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static String getBranchCode() {
		return branchCode;
	}

	public static String getIFSC() {
		return IFSC;
	}

	public int getCustomerId() {
		return customerId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAccNo() {
		return this.accountNo;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean freezStatus() {
		return freez;
	}

	public void freezUnFreez() {
		this.freez = (!this.freez);
	}

	public void setFreez() {
		this.freez = true;
	}

	// Abstract methods thet will be implemented by derived classes
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract void calculateIntrest();

	public abstract String getType();

	public abstract void checkBalance();

	public abstract int getTransactionCount();

	public AccTransaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(AccTransaction[] trans) {
		transactions = trans;
	}

	public void accountInfo() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Bank Name             : Finix Bank");
		System.out.println("Branch Code           : " + branchCode);
		System.out.println("IFSC Code             : " + IFSC);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Customer ID           : " + this.customerId);
		System.out.println("Account Holder Name   : " + this.custumerName);
		System.out.println("DOB                   : " + BankUtils.dateOfBirthPrinter(dateOfBirth));
		System.out.println("Contact               : " + this.mobileNumber);
		System.out.println("Address               : " + this.address);
		System.out.println("Account Creation Date : " + BankUtils.datePrinter(creationDate));
		System.out.println("--------------------------------------------------------------------");
	}

}
