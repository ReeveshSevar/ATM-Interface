package atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(27201, 0001);
				data.put(27202, 0002);
				data.put(27203, 0003);
				data.put(27204, 0004);
				data.put(27205, 0005);
				data.put(27206, 0006);
				data.put(27207, 0007);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("WELCOME TO THE PROJECT");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("Enter your customer Number:-");
				setCustomerNumber(menuInput.nextInt());

				System.out.print("Enter your PIN Number:-     ");
				setPinNumber(menuInput.nextInt());
				System.out.println();
			} catch (Exception e) {
				System.out.print("\n" + "Invalid Character(s). Only Numbers." + "\n");
				x = 2;
			}
			/*
			 * for(Map.Entry<Integer,Integer> it : data.entrySet()){
			 * if(it.getkey()==getCustomerNumber() && it.getValue()==getPinNumber){
			 * getAccountType(); } }
			 */
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			if (data.containsKey(cn) && data.get(cn) == pn) {
				getAccountType();
			} else
			{
				System.out.println("--------------------------");
				System.out.print("Invalid Accont:- \n");
				System.out.println("Please Enter Valid Account");
			}
		} while (x == 1);
	}

	public void getAccountType() {
		System.out.println();
		System.out.println("***************************************");
		System.out.println("DEAR CUSTOMER WELCOME TO OUR BANK");
		System.out.println("***************************************");
		System.out.println("Select the Account you Want to Access: ");
		System.out.println(" Type 1 - Checking Account");
		System.out.println(" Type 2 - Saving Account");
		System.out.println(" Type 3 - Exit");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			getChecking();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("Thank You for using this ATM, bye.  \n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			break;

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getAccountType();
		}
	}

	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println(" Type 1 - View Balance");
		System.out.println(" Type 2 - Withdraw Funds");
		System.out.println(" Type 3 - Deposit Funds");
		System.out.println(" Type 4 - Exit");
		System.out.print("Choice: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;

		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("Thank You for using this ATM, bye.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			break;

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getChecking();
		}
	}

	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println(" Type 1 - View Balance");
		System.out.println(" Type 2 - Withdraw Funds");
		System.out.println(" Type 3 - Deposit Funds");
		System.out.println(" Type 4 - Exit");
		System.out.print("Choice: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;

		case 2:
			getsavingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getSavingDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("Thank You for using this ATM, bye.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			break;

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getChecking();
		}
	}



	
}
