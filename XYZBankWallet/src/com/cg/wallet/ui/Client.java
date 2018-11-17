package com.cg.wallet.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.capg.paymentwallet.bean.CustomerBean;
import com.cg.wallet.bean.BalanceBean;
import com.cg.wallet.bean.Customer;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;



public class Client {
	IWalletService service = new WalletServiceImpl();
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		char ch;
		Client client = new Client();
		do {
			System.out.println("*******Payment Wallet Application*******");
			System.out.println("1. Create Account ");
			System.out.println("2. Show Balance ");
			System.out.println("3. Deposit ");
			System.out.println("4. Withdraw ");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("7. Exit");
			System.out.println("Choose an option");
			int option = client.scanner.nextInt();
			switch(option) {
			case 1:
				
				break;
			case 2:
				
				break;

			case 3:
				

				break;

			case 4:
				

				break;

			case 5:
				

				break;

			case 6:
				

				break;
			case 7:
				System.exit(0);

				break;

			default:
				System.out.println("invalid option");
				break;
			}
			System.out.println("Do you want to continue press Y/N");
			ch = client.scanner.next().charAt(0);

		} 
		while (ch == 'y' || ch == 'n');
	}
	void create() {
		System.out.print("Enter the Customer First Name \t  :\t");
		String firstName = scanner.next();

		System.out.print("Enter the Customer Last Name \t :\t ");
		String lastName = scanner.next();

		System.out.print("Enter the  Customer  E-mail ID \t :\t ");
		String emailID = scanner.next();

		System.out.print("Enter the  Customer Contact Number \t :\t ");
		String PhoneNum = scanner.next();

		System.out.print("Enter the Customer PAN Number \t : \t");
		String permanantAccNum = scanner.next();

		System.out.print("Enter the Customer Address \t : \t");
		
		String address = scanner.next();
		System.out.println("Enter the location \t:\t");
		String location = scanner.next();

		Customer customer = new Customer();
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailID(emailID);
		customer.setLocation(location);
		customer.setPermanantAccNum(permanantAccNum);
		customer.setPhoneNum(PhoneNum);
		System.out.print("Enter Date of Opening (DD/MM/YYYY) \t :\t ");
		String accDateInput = scanner.next();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date dateOfOpeining = sdf.parse(accDateInput);

		System.out.print("Enter balance to create account\t: \t");
		double balance = scanner.nextDouble();
	}
	
}



		
