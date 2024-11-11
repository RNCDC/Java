package Lesson2;

import java.util.Scanner;

/*Method overloading in Java means having two or more methods (or functions) in a class with the same name and different arguments 
(or parameters). It can be with a different number of arguments or different data types of arguments.*/
public class OverLoading 
{
	static Scanner scan = new Scanner (System.in);
	static int num1, num2; //global declaration
	
	public static void main(String[] args) 
	{
		System.out.print("First Number: ");
		num1 = scan.nextInt();
		System.out.print("Second Number: ");
		num2 = scan.nextInt();
		method_OverLoad(); // 1st method
		
		int diff = method_OverLoad(num1); //2nd method
		System.out.println("Difference: " + diff); 
		
		//long is like int, just different size
		//example is float and double
		long prod = method_OverLoad(num1, num2); //3rd method
		System.out.println("Product: " + prod);
		
		int numbers[] = {num1, num2}; 
		method_OverLoad(numbers); // 4th method
	}
	
	public static void method_OverLoad()
	{
		int sum = num1 + num2;
		System.out.println("Sum: " + sum);
	}

	public static int method_OverLoad(int no)
	{
		return (no - num2);
	}
	
	public static long method_OverLoad(int no1, int no2)
	{
		return (no1 * no2);
	}
	
	public static void method_OverLoad(int no[])
	{
		float quo = (float) no[0] / no[1];
		System.out.println("Quotient: " + quo);
	}
}
