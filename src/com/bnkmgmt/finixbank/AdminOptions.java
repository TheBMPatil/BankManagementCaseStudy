package com.bnkmgmt.finixbank;

import java.util.Scanner;

import com.bnkmgmt.account.Account;
import com.bnkmgmt.account.CurrentAccount;
import com.bnkmgmt.account.LoanAccount;
import com.bnkmgmt.account.SalaryAccount;
import com.bnkmgmt.account.SavingAccount;
import com.bnkmgmt.finixbank.transactions.BankAccountsCreated;
import com.bnkmgmt.finixbank.transactions.BankTransaction;
import com.bnkmgmt.finixbank.utils.BankUtils;

public class AdminOptions {
	static AdminOptions admin = new AdminOptions();
	static Scanner sc = new Scanner(System.in);
	static BankTransaction[] transactionOfDay = new BankTransaction[50];
	static BankAccountsCreated[] accountCreatedToday = new BankAccountsCreated[50];
//	static int accountIndexHelper = 0;
	static int accountsCreatedIndex = 0;
	static int transactionOfDayIndex = 0;

	public static int adminOperations(Account[] AllAccounts, int accountsIndex) {
		int adminChoice;
		int accInd;
//		accountIndexHelper = accountsIndex;

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
				return accountsIndex;
			case 1: {
				System.out.println("Account creaation");
				Account temp = admin.createAccount();

				if (temp == null) {
					System.out.println("Faild to creaate account.");
				} else {
					AllAccounts[accountsIndex++] = temp;
					System.out.println("Account created successfully. \n Your customer ID is :" + temp.getCustomerId());

					accountCreatedToday[accountsCreatedIndex++] = new BankAccountsCreated(temp.getAccNo(),
							temp.getType(), temp.getCustomerId());
//					accountsIndex = accountIndexHelper;
				}
			}

				break;

			case 2:
				System.out.println("Freezing Process :");

				accInd = BankUtils.searchAccount(AllAccounts, accountsIndex);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {
					admin.freezUnFreez(AllAccounts[accInd]);
				}
				break;

			case 3:
				accInd = BankUtils.searchAccount(AllAccounts, accountsIndex);
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
				accInd = BankUtils.searchAccount(AllAccounts, accountsIndex);
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
				accInd = BankUtils.searchAccount(AllAccounts, accountsIndex);
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
				admin.calculateIntrestForAll(AllAccounts, accountsIndex);

				break;

			case 7:
				admin.endOfTheDayTransactions(transactionOfDay, accountCreatedToday);
				break;
			case 8:
				admin.displayAllAccountList(AllAccounts, accountsIndex);
				break;
			default:
				System.out.println("Invalid Choice");

			}

//		displayAllAccountList(AllAccounts);
		} while (adminChoice != 0);
		return accountsIndex;
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

	private void endOfTheDayTransactions(BankTransaction[] transactionsOfDay, BankAccountsCreated[] accountsCreated) {

		System.out.println("EOD Transactions");

		double totalDeposite = 0;
		double totalWithdrow = 0;
		System.out.println("\n========================== Transactions of Day ===================================\n");

		if (transactionOfDayIndex == 0) {
			System.out.println("Not enough data to display...!");
		} else {
			System.out.println(
					"Transactin Id  \t Acount no Associiated \t Type of Transaction   \t Transactin Amount     \n");
			for (int iter = 0; iter < transactionOfDayIndex; iter++) {
				transactionsOfDay[iter].transactionInfo();
				if (transactionsOfDay[iter].getTranType().equals("Deposit")) {
					totalDeposite += transactionsOfDay[iter].getTranAmount();
				} else if (transactionsOfDay[iter].getTranType().equals("Withdrow")) {
					totalWithdrow += transactionsOfDay[iter].getTranAmount();
				}
			}
		}

		System.out
				.println("\n========================== Accounts created of Day ===================================\n");
		int totalAccCreated = 0;

		if (accountsCreatedIndex == 0) {
			System.out.println("Not enough data to display...!");
		} else {

			System.out.println(
					"Type of Account created    \t Transaction ID \t Customer Id \t Acount no Associiated 		\n");

			for (; totalAccCreated < accountsCreatedIndex; totalAccCreated++) {
				accountsCreated[totalAccCreated].transactionInfo();
			}
		}

		System.out
				.println("\n_______________________________________________________________________________________\n");

		System.out.println("Total : ----------------------------------------------------");
		System.out.println("\nAccount Created : " + totalAccCreated + "\t Total Deposit : " + totalDeposite
				+ "\t Total Withdrowlas : " + totalWithdrow);
		System.out
				.println("\n_______________________________________________________________________________________\n");

	}

	private void calculateIntrestForAll(Account[] allAccounts, int accountsIndex) {

		for (int iter = 0; iter < accountsIndex; iter++) {
//			System.out.println("Account : " + (iter + 1));
			allAccounts[iter].calculateIntrest();

		}

	}

	private void freezUnFreez(Account account) {
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

	private Account createAccount() {

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
//			allAccounts[accountsIndex] = new LoanAccount(name, add, dob, mono, extraAmt);
			return new LoanAccount(name, add, dob, mono, extraAmt);

//			return allAccounts[accountsIndex - 1].getCustomerId();
		} else if (acType.equalsIgnoreCase("E")) {
			System.out.println("Enter PF Amount : ");
			extraAmt = sc.nextDouble();
//			allAccounts[accountsIndex++] = new SalaryAccount(name, add, dob, mono, extraAmt);
			return new SalaryAccount(name, add, dob, mono, extraAmt);
//			return allAccounts[accountsIndex - 1].getCustomerId();

		} else if (acType.equalsIgnoreCase("S")) {
//			allAccounts[accountsIndex] = new SavingAccount(name, add, dob, mono);
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

	private void displayAllAccountList(Account[] accs, int accountsIndex) {
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
