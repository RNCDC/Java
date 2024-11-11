package APRIL0224_samp2;

import java.util.*;

public class cls_ObjMulti 
{
	static Scanner scan = new Scanner(System.in);
	static cls_Multithread multi = new cls_Multithread();
	static String studNum, studName;
	static float midGrade, finGrade, aveGrade;
	public static void main(String[] args) 
	{
		 method_inputNumName();
		 method_inputGrades();
		 method_Multithread();	 
	}
	
	public static void method_inputNumName()
	{
		System.out.print("Student Number: ");
		studNum = scan.nextLine();
		System.out.print("Student Name: ");
		studName = scan.nextLine();
	}

	private static void method_inputGrades() 
	{
		System.out.print("Midterm Grade: ");
		midGrade = scan.nextFloat();
		System.out.print("Final Grade: ");
		finGrade = scan.nextFloat();	
	}
	
	private static void method_Multithread() 
	{
		multi.studNumber(studNum);
		multi.studName(studName);
		multi.method_ComputeGrades(midGrade, finGrade);
		multi.method_Outputs();
	}

}
