package com.bnkmgmt.finixbank.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.bnkmgmt.account.AccTransaction;
import com.bnkmgmt.account.Account;
import com.bnkmgmt.account.CurrentAccount;
import com.bnkmgmt.account.LoanAccount;
import com.bnkmgmt.account.SalaryAccount;
import com.bnkmgmt.account.SavingAccount;

public final class BankUtils {

	static Scanner sc = new Scanner(System.in);

	public static Date formatDOB(String dateOfBirth2) {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		try {
			return formatter.parse(dateOfBirth2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int searchAccount(Account[] accs, int accountsIndex) {

		System.out.println("Enter Customer ID or Account Number: ");
		int accNo = sc.nextInt();
		for (int idx = 0; idx < accountsIndex; idx++) {
			if (accNo == accs[idx].getCustomerId() || accNo == accs[idx].getAccNo()) {
				return idx;
			}
		}
		return -1;
	}

	public static void accountLifeCycle(Account account) {
		account.accountInfo();
		AccTransaction[] trans = account.getTransactions();

		System.out.println(
				"Transaction Id  \t Transaction Date  \t Transaction Type  \t Amount \t Old Balance  \t New Balance");

		if (account.getTransactionCount() == 0) {
			System.out.println("Not enough data to display..!\n\n");
			System.out.println(
					"========================================================================================\n\n");
		} else {
			for (int transactionNo = 0; transactionNo < account.getTransactionCount(); transactionNo++) {
				trans[transactionNo].transactionInfo();
			}
			System.out.println(
					"========================================================================================\n\n");
		}

	}

	public static int hardcodedAccounnts(Account[] accs, int accountsIndex) {
		accs[accountsIndex++] = new SavingAccount("Bhagvat Mutthe", "Shivrai", "11102002", 840892107);
		accs[accountsIndex++] = new CurrentAccount("Ajay Palhal", "Sambhajinagar", "14042001", 736723688);
		accs[accountsIndex++] = new SalaryAccount("Ankush Pawar", "Sambhajinagar", "16012001", 732892379, 1234);
		accs[accountsIndex++] = new LoanAccount("Amol Pawar", "Sambhajinagar", "10102003", 983288922, 100000);
		return accountsIndex;

	}

	public static String datePrinter(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
		return formatter.format(date);
	}

	public static String dateOfBirthPrinter(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		return formatter.format(date);
	}

}
