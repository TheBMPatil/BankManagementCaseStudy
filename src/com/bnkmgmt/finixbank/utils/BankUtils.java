package com.bnkmgmt.finixbank.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		System.out.println("Enter Customer id or accNo: ");
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

		System.out
				.println("transactionId  \t transactionDate  \t transactionType  \t   amount \t  oldBal  \t newBal \t");
		if (account.getTransactionCount() == 0) {
			System.out.println("Not enough data to display..!\n\n");
			System.out.println(
					"========================================================================================\n\n");
		} else {
			for (int trnsactionNo = 0; trnsactionNo < account.getTransactionCount(); trnsactionNo++) {
				trans[trnsactionNo].transactionInfo();
//			account.getTransactions()[trnsactionNo].transactionInfo();
			}
			System.out.println(
					"========================================================================================\n\n");
		}
	}

	public static int hardcodedAccounnts(Account[] accs, int accountsIndex) {
		accs[accountsIndex++] = new SavingAccount("Bhagvat Mutthe", "Shivrai", "11102002", 840892072);
		accs[accountsIndex++] = new CurrentAccount("BM Patil", "Sambhajinagar", "11102002", 840892107);
		accs[accountsIndex++] = new SalaryAccount("BM Patil 2", "Sambhajinagar", "11102002", 840892107, 1234);
		accs[accountsIndex++] = new LoanAccount("BM Patil3", "Sambhajinagar", "11102002", 840892107, 100000);
		return accountsIndex;

	}

}
