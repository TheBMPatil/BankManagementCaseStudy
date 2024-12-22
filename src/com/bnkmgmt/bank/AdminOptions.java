package com.bnkmgmt.bank;

import java.util.Scanner;

import com.bnkmgmt.acount.Account;
import com.bnkmgmt.acount.CurrentAccount;
import com.bnkmgmt.acount.LoanAccount;
import com.bnkmgmt.acount.SalaryAccount;
import com.bnkmgmt.acount.SavingAccount;

public class AdminOptions {
	static Scanner sc = new Scanner(System.in);
	BankTransaction[] transactionOfDay = new BankTransaction[50];
	static int accountsIndex = 0;
	static int transactionIndex = 0;

	static void hardcodedAccounnts(Account[] accs) {
		accs[accountsIndex++] = new SavingAccount("Bhagvat Mutthe", "Shivrai", "11102002", 840892072);
		accs[accountsIndex++] = new CurrentAccount("BM Patil", "Sambhajinagar", "11102002", 840892107);
		accs[accountsIndex++] = new SalaryAccount("BM Patil 2", "Sambhajinagar", "11102002", 840892107, 1234);
		accs[accountsIndex++] = new LoanAccount("BM Patil3", "Sambhajinagar", "11102002", 840892107, 100000);

	}

	private static void displayAllAccountList(Account[] accs) {
		for (int iter = 0; iter < accountsIndex; iter++) {
			System.out.println("Account : " + (iter + 1));
			accs[iter].accountInfo();
		}
	}

	public static void adminOperations(Account[] AllAccounts) {
		int adminChoice;

		hardcodedAccounnts(AllAccounts);
		do {

			System.out.println("\n\n++++++++__ Welcom to Admin Panel __++++++++\n");
			System.out.println(".......................................................");
			System.out.println("1 : Add New Account \t 2) Deactivate account ");
			System.out.println("3 : Search account \t 4) Deposite ");
			System.out.println("5 : Withdrow       \t 6) Freez / Activate");
			System.out.println("7 : EOD Report     \t 0) Exit ");
			System.out.println(".......................................................");
			System.out.println("Enter Your choice : ");
			adminChoice = sc.nextInt();

			switch (adminChoice) {
			case 0:
				System.out.println("Logging out......!\n\n");
				return;
			case 1:
				System.out.println("Account creaation");
				int custId = createAccount(AllAccounts);
				if (custId == -1) {
					System.out.println("Faild to creaate account.");
				} else {
					System.out.println("Account created successfully. \n Your customer ID is :" + custId);
				}

				break;
			case 3:
				int accInd = searchAccount(AllAccounts);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {
					System.out.println("Account details are : ");
					AllAccounts[accInd].accountInfo();
				}
				break;
			case 8:

				displayAllAccountList(AllAccounts);
				break;
			default:
				System.out.println("Invalid Choice");

			}

//		displayAllAccountList(AllAccounts);
		} while (adminChoice != 0);
	}

	private static int createAccount(Account[] allAccounts) {

		System.out.println("Enter your name : ");
		String name = sc.next();
		System.out.println("Enter Mobile Number: ");
		long mono = sc.nextLong();
		System.out.println("Enter your Address :");
		String add = sc.next();
		System.out.println("Enter Your DOB (ddmmyyyy) (eg:11102002): ");
		String dob = sc.next();
		System.out.println("Enter Type of Account :(Savings : S ,Loan : L, Current :C, Salary : E");
		String acType = sc.next();
		double extraAmt = 0;
		if (acType.charAt(0) == 'L' || acType.charAt(0) == 'l') {
			System.out.println("Enter Loan Amount : ");
			extraAmt = sc.nextDouble();
			allAccounts[accountsIndex++] = new LoanAccount(name, add, dob, mono, extraAmt);
			return allAccounts[accountsIndex - 1].getCustomerId();
		} else if (acType.equalsIgnoreCase("E")) {
			System.out.println("Enter PF Amount : ");
			extraAmt = sc.nextDouble();
			allAccounts[accountsIndex++] = new SalaryAccount(name, add, dob, mono, extraAmt);
			return allAccounts[accountsIndex - 1].getCustomerId();

		} else if (acType.equalsIgnoreCase("S")) {
			allAccounts[accountsIndex++] = new SavingAccount(name, add, dob, mono);
			return allAccounts[accountsIndex - 1].getCustomerId();
		} else if (acType.equalsIgnoreCase("C")) {
			allAccounts[accountsIndex++] = new CurrentAccount(name, add, dob, mono);
			return allAccounts[accountsIndex - 1].getCustomerId();
		} else {
			System.out.println("Invalid Choice..!");
		}
		return -1;
	}

	public static int searchAccount(Account[] accs) {

		System.out.println("Enter Customer id or accNo: ");
		int accNo = sc.nextInt();
		for (int idx = 0; idx < accountsIndex; idx++) {
			if (accNo == accs[idx].getCustomerId() || accNo == accs[idx].getAccNo()) {
				return idx;
			}
		}
		return -1;
	}

}
