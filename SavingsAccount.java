//********************************************************************
//
//Author:        Summer Davis
//
//Program #:     Eight
//
//File Name:     SavingsAccount.java
//
//Course:        ITSE 2321 Object-Oriented Programming
//
//Description:  SavingsAccount class will manage 1 static variable for all objects (accounts)
//				- annualInterestRate
//				and 2 instance variables for each object
//				- savingsBalance
//			    - accountName
//				** Constructor, setters/getters included for instance variables
//
//				Class will use several methods to manipulate object data
//				- calculateMonthlyInterest (calculates and adds to savingsBalance)
//				- depositAmount (deposits an amount to the savingsBalance - cannot accept negative values)
//				- withdrawAmount (withdraws an amount from the savingsBalance - cannot accept negative values)
//				- modifyInterestRate (static method that allows the bank to modify the 
//				   annual interest rate) 
//				- printMonthlyBalances (prints the balance of an account for each month of the year)
//				- printCurrentBalance (prints the current balance of the account)
//			    - toString (provides a string representation of the object)
//
//********************************************************************

public class SavingsAccount {
	
	// instance variables
	private static double annualInterestRate = 0;
	private double savingsBalance;
	private String accountName;
	
	
	
	// Declare constructor
	
	//***************************************************************
	//
	//  Method:       SavingsAccount
	// 
	//  Description:  The constructor of the class
	//				  - intakes accountName and savingsBalance
	//
	//  Parameters:   String, double
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public SavingsAccount(String accountName, double savingsBalance) {
		this.accountName = accountName;
		this.savingsBalance = savingsBalance;
		
		System.out.printf("%n%s account successfully created%n", accountName);
	} // end of constructor
	
	// Setters and Getters
	
	//***************************************************************
	//
	//  Method:       setSavingsBalance
	// 
	//  Description:  The setter for savingsBalance instance variable
	//
	//  Parameters:   double
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	} // end of setSavingsBalance
	
	//***************************************************************
	//
	//  Method:       getSavingsBalance
	// 
	//  Description:  The getter for savingsBalance instance variable
	//
	//  Parameters:   N/A
	//
	//  Returns:      double 
	//
	//**************************************************************
	public double getSavingsBalance() {
		return savingsBalance;
	} // end of getSavingsBalance
	
	//***************************************************************
	//
	//  Method:       setAccountName
	// 
	//  Description:  The setter for accountName instance variable
	//
	//  Parameters:   String
	//
	//  Returns:      N/A 
	//
	//**************************************************************
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	} // end of setAccountName
	
	//***************************************************************
	//
	//  Method:       getAccountName
	// 
	//  Description:  The getter for accountName instance variable
	//
	//  Parameters:   N/A
	//
	//  Returns:      String
	//
	//**************************************************************
	public String getAccountName() {
		return accountName;
	} // end of getAccountName
	
	//***************************************************************
	//
	//  Method:       calculateMonthlyInterest
	// 
	//  Description:  calculates monthly interest and adds to savingsBalance
	//
	//  Parameters:   N/A
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public void calculateMonthlyInterest() {
		double monthlyInterestRate = annualInterestRate / 12;
		double monthlyInterest = monthlyInterestRate * savingsBalance;
		savingsBalance += monthlyInterest;
	} // end of calculateMonthlyInterest
	
	//***************************************************************
	//
	//  Method:       depositAmount
	// 
	//  Description:  deposits an amount that increases the savingsBalance
	//				  - checks that the deposit amount is not negative
	//
	//  Parameters:   double
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public void depositAmount(double deposit) {
		// do not accept negative amount
		if (deposit < 0) {
			System.out.println("Cannot enter a negative amount. Exiting program.");
			System.exit(0);
		}
		savingsBalance += deposit;
		System.out.printf("%n$%,.02f successfully deposited to %s%n", deposit, accountName);
	} // end of depositAmount
	
	//***************************************************************
	//
	//  Method:       withdrawAmount
	// 
	//  Description:  withdraws an amount that decreases the savingsBalance
	//				  - checks that the withdraw amount is not negative
	//
	//  Parameters:   double
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public void withdrawAmount(double withdraw) {
		// do not accept a negative amount
		if (withdraw < 0) {
			System.out.println("Cannot enter a negative amount. Exiting program.");
			System.exit(0);
		}
		savingsBalance -= withdraw;
		System.out.printf("%n$%,.02f successfully withdrawn from %s%n", withdraw, accountName);
	} // end of withdrawAmount
	
	//***************************************************************
	//
	//  Method:       modifyInterestRate
	// 
	//  Description:  static - modifies the annual interest rate
	//				  - checks that the new interest rate is between 2 and 5
	//
	//  Parameters:   double
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public static void modifyInterestRate(double interestRate) {
		// only accept between 2 - 5
		if (interestRate < 2 || interestRate > 5) {
			System.out.println("Can only accept rates between 2 and 5. Exiting program.");
			System.exit(0);
		}
		annualInterestRate = interestRate / 100;
		System.out.printf("%nAnnual Interest Rate has been modified to %.01f%%%n", interestRate);
	} // end of modifyInterestRate
	
	//***************************************************************
	//
	//  Method:       printMonthlyBalances
	// 
	//  Description:  calculates and prints the account balance for each month of the year
	//
	//  Parameters:   N/A
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public void printMonthlyBalances() {
		// notify user that balances are being calculated
		System.out.printf("%nCalculating monthly balances for %s. . .%n%n", accountName);
		
		// calculate monthly interest for all 12 months
		for (int month = 1; month <= 12; month++) {
			this.calculateMonthlyInterest();
			switch (month) {
			case 1: System.out.printf("January   $%,.02f%n", savingsBalance);
					break;
			case 2: System.out.printf("February  $%,.02f%n", savingsBalance);
					break;
			case 3: System.out.printf("March     $%,.02f%n", savingsBalance);
					break;
			case 4: System.out.printf("April     $%,.02f%n", savingsBalance);
					break;
			case 5: System.out.printf("May       $%,.02f%n", savingsBalance);
					break;
			case 6: System.out.printf("June      $%,.02f%n", savingsBalance);
					break;
			case 7: System.out.printf("July      $%,.02f%n", savingsBalance);
					break;
			case 8: System.out.printf("August    $%,.02f%n", savingsBalance);
					break;
			case 9: System.out.printf("September $%,.02f%n", savingsBalance);
					break;
			case 10: System.out.printf("October   $%,.02f%n", savingsBalance);
					break;
			case 11: System.out.printf("November  $%,.02f%n", savingsBalance);
					break;
			case 12: System.out.printf("December  $%,.02f%n", savingsBalance);
					break; 
			default: System.out.println("Error calculating.");
					break;
			}
		}
	} // end of printMonthlyBalances
	
	//***************************************************************
	//
	//  Method:       printCurrentBalance
	// 
	//  Description:  prints the string representation of the account object
	//				  by calling toString()
	//
	//  Parameters:   N/A
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public void printCurrentBalance() {
		System.out.print(this.toString());
	} // end of printCurrentBalance
	
	
	//***************************************************************
	//
	//  Method:       toString
	// 
	//  Description:  provides a String representation of the account object
	//
	//  Parameters:   N/A
	//
	//  Returns:      N/A
	//
	//**************************************************************
	public String toString() {
		return String.format("%n%s: %s%n%s: $%,.02f%n", "Account", accountName, "Current Balance", savingsBalance);
	} // end of toString

}
