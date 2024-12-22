package com.bnkmgmt.bank;

import java.util.Scanner;

import com.bnkmgmt.acount.Account;

public class FinixBank {

	private static int adminPass = 8408;
	static Scanner sc = new Scanner(System.in);

	public static void StartBank() {
		Account[] accs = new Account[20];
		System.out.println("Welcome to Finix Bank");
		int loginChoice;
		do {
			System.out.println("1 : Login as Addmin  ");
			System.out.println("2 : View Account Life Cycle");
			
			System.out.println("3 : Exit");
			loginChoice = sc.nextInt();
			switch (loginChoice) {
			case 1:
				System.out.println("Enter Admon Password :");
				int userPass = sc.nextInt();
				if (userPass == adminPass) {
					AdminOptions.adminOperations(accs);
				} else {
					System.out.println("Wrong Password");
					break;
				}
				break;
			case 2:
				System.out.println("Acc Life Cycle");
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
