package Assignment;

import java.util.Scanner;

public class Number2 
{
	static Scanner scan = new Scanner (System.in);
	static String name, type;
	static double distance,tf;
	
	public static void main(String[] args) 
	{
		inputInfo();
		tf = totalfare(distance);
		offreceipt(distance, tf, type);
	}

	public static void inputInfo()
	{
		System.out.print("Passenger Name: ");
		name = scan.nextLine();
		System.out.print("Distanced Travel: ");
		distance = scan.nextFloat();
		scan.nextLine();
		System.out.print("Type of Passenger (Regular, Senior, PWD, Student): ");
		type = scan.nextLine();
	}
	
	public static double totalfare(double distance)
	{
		double fee=60;
		double extra=0;
		if (distance > 2)
		{	/*Math. ceil() converts the number the nearest integer greater than or equal to the given number
			if an integer is passed as an argument the result of Math. ceil() will be the same integer 
			Math. ceil() returns a double value the integer will be typecasted to double.*/
			extra = Math.ceil(distance) - 2;
			tf = (7.50 * extra) + fee;
		}
		return tf;
	}
	
	public static void offreceipt(double distance, double tf, String type)
	{
		double discount = 0.00;
		switch (type.toUpperCase())
		{
			case "SENIOR": 
				discount = tf * .20;
				break;
			case "PWD": 
				discount = tf * .15;
				break;
			case "STUDENT": 
				discount = tf * .10;
				break;
		}
		System.out.println("\nOfficial Receipt");
		System.out.println("Passenger Name: " + name);
		System.out.println("Type of Passenger: " + type);
		System.out.println("Total Fare: " + tf);
		System.out.println("Discount: " + discount);
		double ta = tf - discount;
		//String formatTa = String.format("%.2f", ta);
		//System.out.println("Total Amount to be Paid: %.2f",formatTa);
		System.out.printf("Total Amount to be Paid: %.2f",ta);
	}
}
