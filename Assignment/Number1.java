package Assignment;

import java.io.*;
import java.util.Scanner;

public class Number1 
{
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static Scanner scan = new Scanner (System.in);
	static double qsales [] = new double [4], totsales, comm; //global declaration
	static String sname;
	
	public static void main(String[] args) throws IOException
	{ //A.
		System.out.print("Enter the Salesman Name: ");
		sname = scan.nextLine();
		System.out.print("Enter the Quarterly Sales: ");
		for (int i = 0; i < 4; i++)
		{
			qsales[i] = Double.parseDouble(br.readLine());
		}
		totsales = returnts(qsales);
		comm = commission(totsales);
		outDisplay();
	}
	
	public static double returnts(double qsales[])//B.
	{
		for (int i = 0; i < 4; i++)
		{
			totsales += qsales[i];
		}
		return totsales;
	}
	
	public static double commission(double totsales)//C.
	{
		double percent=0;
		if (totsales <= 5000.00)
		{
			percent = 0.15;
			comm = totsales * percent;
		}
		else if (totsales <= 10000.00)
		{
			percent = 0.20;
			comm = totsales * percent;
		}
		else if (totsales <= 15000.00)
		{
			percent = 0.25;
			comm = totsales * percent;
		}
		else if (totsales <= 20000.00)
		{
			percent = 0.30;
			comm = totsales * percent;
		}
		else
		{
			percent = 0.40;
			comm = totsales * percent;
		}
		return comm;
	}
	
	public static void outDisplay()//D.
	{
		System.out.println("\nSalesman Name: " + sname);
		System.out.println("Total Sales: " + totsales);
		System.out.println("Commission: " + comm);
	}
}
