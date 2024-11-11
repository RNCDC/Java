package Assignment;

import java.util.Scanner;

public class Number6 
{
	static Scanner scan = new Scanner (System.in);
	static String name, type;
	static double distance, tf; 
	
	public static void main(String[] args) 
	{
		Number5 over = new Number5();
		inputInfo();
		tf = over.totalfare(distance);
		over.offreceipt(distance, tf, type);
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
	
}
