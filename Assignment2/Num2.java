package Assignment2; //2

import java.util.Scanner;

public class Num2 
{
	static Scanner scan = new Scanner (System.in);
	static String fno[] = new String[20];
	static String fna[] = new String[20];
	static String department[] = new String[20];
	static String stats[] = new String[20];
	static int i;
	static cls2 seccls = new cls2();

	
	public static void main(String[] args) 
	{
     // Input 20 records of faculty
		for (i = 0; i < 20; i++) 
        {
            InputFNumName();
            Inputdepstat();
            clsout();
        }
	}
	public static void InputFNumName()
	{
		System.out.println("Faculty " + (i + 1));
		System.out.print("Faculty Number: ");
		fno[i] = scan.nextLine();
		System.out.print("Faculty Name: ");
		fna[i] = scan.nextLine();
		seccls.setFNum(fno[i]);
		seccls.setFName(fna[i]);
	}
	
	private static void Inputdepstat() 
	{
		System.out.print("Department (Computer, Mathematics, Filipino, English): ");
		department[i] = scan.nextLine().toUpperCase();
		System.out.print("Status (Regular, Temporary, Part Time): ");
		stats[i] = scan.nextLine().toUpperCase();
		seccls.setDept(department[i]);
		seccls.setStatus(stats[i]);
	}
	
	private static void clsout() 
	{
		seccls.details();
	}
}
