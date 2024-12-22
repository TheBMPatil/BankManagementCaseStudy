package com.bnkmgmt.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class Account {
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

	public Account(String custumerName, String address, String dateOfBirth, long moNo) {
		this.custumerName = custumerName;
		this.address = address;
		this.dateOfBirth = formatDOB(dateOfBirth);
		this.mobileNumber = moNo;

		this.customerId = createCID();
		this.balance = 0.00;
//		LocalDate lclDate=  LocalDate.now(); 
		this.creationDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

//				new SimpleDateFormat("yyyy-MM-dd").parse(lclDate.toString());

//				Date.from(lclDate.atZone(ZoneId.systemDefault()).toInstant());
	}

	private Date formatDOB(String dateOfBirth2) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		try {
			return formatter.parse(dateOfBirth2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getBranchCode() {
		return branchCode;
	}

	public static String getIFSC() {
		return IFSC;
	}

	private int createCID() {

		return cidcnt++;
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

	// Abstract methods thet will be implemented by derived classes
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract void calculateIntrest();

	public abstract String getType();

	public abstract void checkBalance();

	public void accountInfo() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Bank Name : Finix Bank ");
		System.out.println("Branch code: " + branchCode);
		System.out.println("IFSC code: " + IFSC);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Customer ID : " + this.customerId);
		System.out.println("Aaccount Holder Name : " + this.custumerName);
		System.out.println("DOB : " + this.dateOfBirth);
		System.out.println("Contact : " + this.mobileNumber);
		System.out.println("Address : " + this.address);
		System.out.println("Account creation Date : " + this.creationDate);
		System.out.println("--------------------------------------------------------------------");

	}

}
