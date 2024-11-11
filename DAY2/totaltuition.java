package DAY2;

import java.util.Scanner;

public class totaltuition 
{
	static Scanner scan = new Scanner(System.in);
	static int unit,bfee,mfee,tfee;
	static String studname;
	public static void main(String[] args) 
	{ //1.a
		//String studname;
		System.out.print("Student Name: ");
		studname = scan.nextLine();
		innum();
		basefee();
		misfee();
		totcomp(unit,bfee,mfee);
		totfee(studname,tfee);
	}

	public static void innum()
	{ //1.b
		System.out.print("Number of Units: ");
		unit = scan.nextInt();
		//return(unit);
	}
	
	public static void basefee()
	{ //1.c
		System.out.print("Base fee: ");
		bfee = scan.nextInt();
		//return(bfee);
	}
	
	public static void misfee()
	{ //1.d
		System.out.print("Miscellaneous fee: ");
		mfee = scan.nextInt();
		//return(mfee);
	}
		
	public static int totcomp(int unit, int bfee, int mfee)
	{ //1.e
		tfee = unit * bfee + mfee;
		return(tfee);
	}
	
	public static void totfee(String name, int tfee)
	{ //1.e
		System.out.println(name);
		System.out.println(tfee);
	}
}
