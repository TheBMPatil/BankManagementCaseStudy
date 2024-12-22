package com.bnkmgmt.finixbank;

import java.util.Scanner;

import com.bnkmgmt.account.Account;
import com.bnkmgmt.account.CurrentAccount;
import com.bnkmgmt.account.LoanAccount;
import com.bnkmgmt.account.SalaryAccount;
import com.bnkmgmt.account.SavingAccount;
import com.bnkmgmt.finixbank.transactions.BankAccountsCreated;
import com.bnkmgmt.finixbank.transactions.BankTransaction;

public class AdminOptions {
	static Scanner sc = new Scanner(System.in);
	static BankTransaction[] transactionOfDay = new BankTransaction[50];
	static BankAccountsCreated[] accountCreatedToday = new BankAccountsCreated[50];
	static int accountsIndex = 0;
	static int accountsCreatedIndex = 0;
	static int transactionOfDayIndex = 0;

	public static void adminOperations(Account[] AllAccounts) {
		int adminChoice;
		int accInd;

		hardcodedAccounnts(AllAccounts);
		System.out.println("\n\n++++++++__ Welcom to Admin Panel __++++++++\n");
		do {

			System.out.println(".......................................................");
			System.out.println("1 : Add New Account \t 2 Freez / Activate ");
			System.out.println("3 : Search account \t 4) Deposite ");
			System.out.println("5 : Withdrow       \t 6) Calculatte Intrest ");
			System.out.println("7 : EOD Report     \t 0) Exit ");
			System.out.println(".......................................................");
			System.out.println("Enter Your choice : ");
			adminChoice = sc.nextInt();

			switch (adminChoice) {
			case 0:
				System.out.println("Logging out......!\n\n");
				return;
			case 1: {
				System.out.println("Account creaation");
				Account temp = createAccount(AllAccounts);

				if (temp == null) {
					System.out.println("Faild to creaate account.");
				} else {
					AllAccounts[accountsIndex++] = temp;
					System.out.println("Account created successfully. \n Your customer ID is :" + temp.getCustomerId());

					accountCreatedToday[accountsCreatedIndex++] = new BankAccountsCreated(temp.getAccNo(),
							temp.getType(), temp.getCustomerId());
				}
			}

				break;

			case 2:
				System.out.println("Freezing Process :");

				accInd = searchAccount(AllAccounts);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {
					freezUnFreez(AllAccounts[accInd]);
				}
				break;

			case 3:
				accInd = searchAccount(AllAccounts);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {
					System.out.println("Account details are : ");
					AllAccounts[accInd].accountInfo();
				}
				break;

			case 4:
				System.out.println("Deposite");
				accInd = searchAccount(AllAccounts);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {

					AllAccounts[accInd].accountInfo();
					System.out.println("Enter Amount to deposite..!");
					double amount = sc.nextDouble();
					AllAccounts[accInd].deposit(amount);

					transactionOfDay[transactionOfDayIndex++] = new BankTransaction(AllAccounts[accInd].getAccNo(),
							"Deposit", amount);
				}

				break;

			case 5:
				System.out.println("Withdrow");
				accInd = searchAccount(AllAccounts);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {

					AllAccounts[accInd].accountInfo();
					System.out.println("Enter Amount to Withdrow..!");
					double amount = sc.nextDouble();
					AllAccounts[accInd].withdraw(amount);
					transactionOfDay[transactionOfDayIndex++] = new BankTransaction(AllAccounts[accInd].getAccNo(),
							"Withdrow", amount);

				}
				break;
			case 6:
				System.out.println("Calculating intrest for all..!");
				calculateIntrestForAll(AllAccounts);

				break;

			case 7:
				endOfTheDayTransactions(transactionOfDay, accountCreatedToday);
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

//	private static int searchAccountByCID(int custId,Account[] accs) {
//		// TODO Auto-generated method stub
//		for (int idx = 0; idx < accountsIndex; idx++) {
//			if (custId == accs[idx].getCustomerId() ) {
//				return idx;
//			}
//		}
//		return -1;
//		
//	}

	private static void endOfTheDayTransactions(BankTransaction[] transactionsOfDay,
			BankAccountsCreated[] accountsCreated) {

		System.out.println("EOD Transactions");

		double totalDeposite = 0;
		double totalWithdrow = 0;
		System.out.println("========================== Transactions of Day ===================================");

		if (transactionOfDayIndex == 0) {
			System.out.println("Not enough data to display...!");
		} else {
			for (int iter = 0; iter < transactionOfDayIndex; iter++) {
				transactionsOfDay[iter].transactionInfo();
				if (transactionsOfDay[iter].getTranType().equals("Deposit")) {
					totalDeposite += transactionsOfDay[iter].getTranAmount();
				} else if (transactionsOfDay[iter].getTranType().equals("Withdrow")) {
					totalWithdrow += transactionsOfDay[iter].getTranAmount();
				}
			}
		}

		System.out.println("========================== Accounts created of Day ===================================");
		int totalAccCreated = 0;

		if (accountsCreatedIndex == 0) {
			System.out.println("Not enough data to display...!");
		} else {
			for (; totalAccCreated < accountsCreatedIndex; totalAccCreated++) {
				accountsCreated[totalAccCreated].transactionInfo();
			}
		}

		System.out.println("_______________________________________________________________________________________");

		System.out.println("Total : ----------------------------------------------------");
		System.out.println("\nAccount Created : " + totalAccCreated + "\tTotal Deposit : " + totalDeposite
				+ "\tTotal Withdrowlas : " + totalWithdrow);
		System.out.println("_______________________________________________________________________________________");

	}

	private static void calculateIntrestForAll(Account[] allAccounts) {

		for (int iter = 0; iter < accountsIndex; iter++) {
			System.out.println("Account : " + (iter + 1));
			allAccounts[iter].calculateIntrest();
			;
		}

	}

	private static void freezUnFreez(Account account) {
		String freezChoice;
		if (account.freezStatus()) {
			System.out.println("Account is currentlly Freez. \n Do you want to unFreeez ? (y/n)");
			freezChoice = sc.next();
			if (freezChoice.equals("y")) {
				account.freezUnFreez();
			} else {
				System.out.println("Account is still Freez..!");
				return;
			}
		} else {
			System.out.println("Account is Active.");
			System.out.println("Do you want to Freeez ? (y/n)");
			freezChoice = sc.next();
			if (freezChoice.equals("y")) {
				account.freezUnFreez();
			} else {
				System.out.println("Account is active..!");
				return;
			}
		}

	}

	private static Account createAccount(Account[] allAccounts) {

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
			return new LoanAccount(name, add, dob, mono, extraAmt);

//			return allAccounts[accountsIndex - 1].getCustomerId();
		} else if (acType.equalsIgnoreCase("E")) {
			System.out.println("Enter PF Amount : ");
			extraAmt = sc.nextDouble();
//			allAccounts[accountsIndex++] = new SalaryAccount(name, add, dob, mono, extraAmt);
			return new SalaryAccount(name, add, dob, mono, extraAmt);
//			return allAccounts[accountsIndex - 1].getCustomerId();

		} else if (acType.equalsIgnoreCase("S")) {
			allAccounts[accountsIndex++] = new SavingAccount(name, add, dob, mono);
			return new SavingAccount(name, add, dob, mono);
//			return allAccounts[accountsIndex - 1].getCustomerId();
		} else if (acType.equalsIgnoreCase("C")) {
//			allAccounts[accountsIndex++] = new CurrentAccount(name, add, dob, mono);
			return new CurrentAccount(name, add, dob, mono);
//			return allAccounts[accountsIndex - 1].getCustomerId();
		} else {
			System.out.println("Invalid Choice..!");
		}
		return null;
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

}

//
//{
//	System.out.println("Deactivation process");
//	int accIndex = searchAccount(AllAccounts);
//	AllAccounts[accIndex].accountInfo();
//	
//	System.out.println("Confirm deactivation ? (y/n)");
//	String confirm = sc.next();
//	if(confirm.equals("y")) {
//		System.out.println("Deleting account..!");
//		Account accc = AllAccounts[accIndex];
//		
//	}}
