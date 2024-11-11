package Lesson2;

import java.util.Scanner;

//connected to Abstract
public class Call_Abstract 
{
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		//classname varname = new classname();
		Abstract over = new Abstract(); //creates object for Abstract
		int no1, no2;
		System.out.print("Number 1: ");
		no1 = scan.nextInt();
		System.out.print("Number 2: ");
		no2 = scan.nextInt();
		
		long prod = over.method_OverLoad(no1, no2); //3rd method
		System.out.println("Product: " + prod);
		
		int [] val = {no1, no2}; 
		over.method_OverLoad(val); // 4th method
	}

}
