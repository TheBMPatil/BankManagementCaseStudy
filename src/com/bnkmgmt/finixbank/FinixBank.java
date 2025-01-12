package com.bnkmgmt.finixbank;

import java.util.Scanner;

import com.bnkmgmt.account.Account;
import com.bnkmgmt.exceptions.MenuChoiceException;
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
			System.out.println("3 : Cheack balance");

			System.out.println("5 : Exit");
			loginChoice = sc.nextInt();
			if (loginChoice >= 5 || loginChoice <= 0) {
				try {
					throw new MenuChoiceException("Invalid Choice ");
				} catch (MenuChoiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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
				System.out.println("Cheac Balance");
				int accInd = BankUtils.searchAccount(accs, accountsIndex);
				if (accInd == -1) {
					System.out.println("No Customer found for given data");
					break;
				} else {
					accs[accInd].checkBalance();
				}
				break;
			case 5:
				System.out.println("Exiting...!");
				return;

			default:
				System.out.println("Invalid Choice..!");
				break;
			}
		} while (loginChoice != 5);
	}

}
