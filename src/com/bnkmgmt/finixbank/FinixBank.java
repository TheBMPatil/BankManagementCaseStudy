package com.bnkmgmt.finixbank;

import java.util.Scanner;

import com.bnkmgmt.account.Account;
import com.bnkmgmt.finixbank.utils.BankUtils;

public class FinixBank {
	static int accountsIndex = 0;
	private static int adminPass = 8408;
	static Scanner sc = new Scanner(System.in);

	public static void StartBank() {
		Account[] accs = new Account[20];
		accountsIndex = BankUtils.hardcodedAccounnts(accs, accountsIndex);
		System.out.println("Welcome to Finix Bank");
		int loginChoice;
		do {
			System.out.println("1 : Login as Addmin  ");
			System.out.println("2 : View Account Life Cycle");

			System.out.println("3 : Exit");
			loginChoice = sc.nextInt();
			switch (loginChoice) {
			case 1:
				System.out.println("Enter Admin Password :");
				int userPass = sc.nextInt();
				if (userPass == adminPass) {
					accountsIndex = AdminOptions.adminOperations(accs, accountsIndex);

				} else {
					System.out.println("Wrong Password");
					break;
				}
				break;
			case 2:
				System.out.println("Account Life Cycle / Account Statement \n");
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				int index = BankUtils.searchAccount(accs, accountsIndex);
				if (index == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {
					BankUtils.accountLifeCycle(accs[index]);

				}
				break;
			case 3:
				System.out.println("Exiting...!");
				return;
			default:

				System.out.println("Invalid CChoice..!");
				break;
			}
		} while (loginChoice != 3);
	}

}
