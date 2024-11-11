package APRIL2324;

import java.util.Scanner;
import java.util.InputMismatchException;

public class act 
{
	static Scanner scan = new Scanner(System.in);
	static constructor cons = new constructor();
	static depwith dw = new depwith();
	static outstandingbal ob = new outstandingbal();
	static 	float amount;
	public static void main(String[] args) 
	{
		method_input();
	}

	public static void method_input() //B
	{
		int anu;
		String ana;
		float indep;
		
		try
		{
			System.out.print("Account Number: "); 
			anu = scan.nextInt();
			scan.nextLine();
			System.out.print("Account Name: ");
			ana = scan.nextLine();
			System.out.print("Initial Deposit: ");
			indep = scan.nextInt();
			scan.nextLine();
			cons.setanu(anu);
			cons.setana(ana);
			cons.setindep(indep);
			method_transaction();
			
		}
		
		catch(InputMismatchException e)
		{
			System.out.println("Input mismatch exception: Please enter a valid Account Number!");
		}
		
		finally
		{
			System.out.println(" ");
		}
	}
	
	public static void method_transaction() //C
	{
		String trans, cont;
		System.out.print("Transaction: "); 
		trans = scan.nextLine();
		System.out.print("Amount: "); 
		amount = scan.nextFloat();
		scan.nextLine();
		
		if (trans.equalsIgnoreCase("deposit"))
		{
			dw.deposit(amount);
		}
		else if (trans.equalsIgnoreCase("withdraw")) 
		{
			dw.withdraw(amount);
        } 
		else 
		{
            System.out.println("Invalid transaction type");
            return;
		}
		
		System.out.print("Another Transaction? (Y-Yes , N-No): "); 
		cont = scan.nextLine().toUpperCase();
		switch(cont)
		{
		case "Y":
			method_transaction();
			break;
		case "N":
			method_output();
			break;
		}
	}
	
	public static void method_output() //D
	{
		System.out.println("Account Number: " + cons.getanu());
		System.out.println("Account Name: " + cons.getana());
		System.out.println("Outstanding Balance: " + cons.getob());
	}
}
