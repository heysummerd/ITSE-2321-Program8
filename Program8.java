//********************************************************************
//
//Author:        Summer Davis
//
//Program #:     Eight
//
//File Name:     Program8.java
//
//Course:        ITSE 2321 Object-Oriented Programming
//
//Description:   Program8 leverages the SavingsAccount class to accomplish the following:
//				 - Creates two savings account objects (saver1, saver2)
//      	     - Modifies annual interest rate to 4%
//				 - Calculates & prints monthly interest for 12 months in each account
//				 - Deposits $1,500 to saver1
//				 - Withdraws $550 from saver2
//				 - Modifies annual interest rate to 5%
//				 - Calculates next month's interest & prints new balance for each account
//
//********************************************************************

// imports
import java.util.Scanner;

// main
public class Program8 {
	//***************************************************************
	//
	//  Method:       main
	// 
	//  Description:  The main method of the program
	//
	//  Parameters:   String array
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public static void main(String[] args) {
		
		// display developer info
		developerInfo();
		
		// create Scanner to obtain input
		Scanner input = new Scanner(System.in);
		
		// instantiate objects
		SavingsAccount saver1 = new SavingsAccount("Saver 1", 2000);
		SavingsAccount saver2 = new SavingsAccount("Saver 2", 3000);
		
		// set annual interest rate
		SavingsAccount.modifyInterestRate(4);
		
		// calculate monthly interest for all 12 months, for each account
		// print new balances for each month
		saver1.printMonthlyBalances();
		saver2.printMonthlyBalances();
		
		// deposit $1500 to saver1
		saver1.depositAmount(1500);
		
		// withdraw $550 from saver2
		saver2.withdrawAmount(550);
		
		// set annual interest rate 
		SavingsAccount.modifyInterestRate(5);
		
		// calculate monthly interest for each account
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		// print new balance for each account
		saver1.printCurrentBalance();
		saver2.printCurrentBalance();
		

	} // end of main method
	
	//***************************************************************
	//
	//  Method:       developerInfo
	// 
	//  Description:  The developer information method of the program
	//
	//  Parameters:   None
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public static void developerInfo() {
	   System.out.println("Name:    Summer Davis");
	   System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
	   System.out.println("Program: Eight \n");

	} // End of developerInfo method


} 
