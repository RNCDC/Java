package Activity3;

import java.util.*;

public class cls_main  //A
{
	static Scanner scn = new Scanner(System.in);
		
	static LetterB letB = new LetterB();
	static LetterC letC = new LetterC();
	static LetterD letD = new LetterD();
		
	static double grossp;
	public static void main(String[] args) 
	{
		String empnum, empname;
		double deduct, hours, rate;
			
		//Input
		System.out.print("Employee number: ");	
		empnum=scn.nextLine();
		System.out.print("Employee name: ");	
		empname=scn.nextLine();
		System.out.print("No. of Hours Worked: ");	
		hours=scn.nextDouble();
		System.out.print("Rate per Hour: ");	
		rate=scn.nextDouble();
		System.out.print("Amount of Deductions: ");
		deduct=scn.nextDouble();
			
		//accessing classes/objects
		NumName(empnum, empname);
		RateHour(rate, hours);
		deductions(deduct);
	}
	
	//Display for B
	public static void NumName(String eno, String ena)
	{	String enumb, ename;
		letB.empNumber(eno);
		enumb = letB.empNo();
		System.out.println("\nEmployee Name: " + enumb);
		letB.empName(ena);
		ename = letB.empNa();
		System.out.println("Employee Name: " + ename);
	}
	
	//Display for C
	public static void RateHour(double rph, double hour)
	{	//double grossp;
		letC.numHours(hour);
		letC.ratepH(rph);
		grossp = letC.grosspay();
		System.out.println("Gross Pay: " + grossp);
	}
	
	//Display for D
	public static void deductions(double deduct)
	{	double minus;
		letD.grossPay(grossp);
		letD.deduction(deduct);
		minus = letD.netpay();
		System.out.println("Net Pay: " + minus);
	}

}