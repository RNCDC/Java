package DAY2;

import java.util.Scanner;

public class inheritance extends totaltuition 
{
	static Scanner scan = new Scanner(System.in);
	static int unit,bfee,mfee,tfee;
	static String studname;
	public static void main(String[] args) 
	{ //1.a
		System.out.print("Student Name: ");
		studname = scan.nextLine();
		innum();
		basefee();
		misfee();
		totcomp(unit,bfee,mfee);
		totfee(studname,tfee);
	}
}