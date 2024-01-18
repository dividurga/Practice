package bankingApplication;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Properties;
import bankingApplication.BankOTP2;
import bankingApplication.User;
import bankingApplication.CheckingsAccount;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Get system properties
       
		ArrayList<User> userList = new ArrayList<User>();
		System.out.println("Welcome to Bank of Divija");
		Scanner sc = new Scanner(System.in);
		int userchoice = 0;
		do {
			System.out.println("Enter name of user: ");

			String name = sc.next();
			System.out.println("Enter email of user: ");

			String email=sc.next();
			CheckingsAccount C1 = new CheckingsAccount();

			User U = new User(name, email,C1);
			System.out.println("Checkings Account number is: " + C1.getAccnumber());
			// System.out.println("Savings Account number is: " + C1.accnumber);
			System.out.println("1: Create new account\n2: Banking Operation (withdraw/deposit/get balance)");
			userchoice = sc.nextInt();
			userList.add(U);
			while (userchoice == 2) {

				System.out.println("Enter account number: ");
				long accnumber = sc.nextLong();
				boolean found = false;
				for (User a : userList) {
					if (a.user_C1.getAccnumber() == accnumber) {
						found = true;
						System.out.println("Enter operation:\n1.Deposit\n2. Withdraw\n3. Get Information");
						int opchoice = sc.nextInt();
						if (opchoice == 1) {
							System.out.println("Enter amount: ");

							a.user_C1.deposit(sc.nextDouble());
							System.out.println(a.user_C1.getBalance());

						}

						else if (opchoice == 2) {
						
							System.out.println("Enter amount: ");
							double amt=sc.nextDouble();
							String otpsent= BankOTP2.sendOTP(a.user_email);
							System.out.println("Enter OTP: ");
							String otp= sc.next();
							if (otp.equals(otpsent)){
								a.user_C1.withdraw(amt);
								System.out.println(a.user_C1.getBalance());
							}
							else System.out.println("Wrong OTP");
							

						} else if (opchoice == 3) {
							System.out.println("Name: " + a.user_name + "\nBalance: " + a.user_C1.getBalance());

						}
						System.out
								.println("1: Create new account\n2: Banking Operation (withdraw/deposit/get balance)");
						userchoice = sc.nextInt();
					}
				}

				if (!found)
					System.out.println("Account not found");

			}

		} while (userchoice == 1);

	}



	
	}

	


