package APRIL0224_samp3;

import java.util.*;
//import java.io.*;

public class cls_StudGrade {
	static Scanner scan = new Scanner(System.in);
	static cls_Class2  objCls2 = new cls_Class2();
	static cls_Subjects objSubjects = new cls_Subjects();
	static int[] units = new int[5];
	static String subj_code[] = new String[5];
	static String subj[] = new String[5];
	static float[] midtermgrd = new float[5];
	static float finalgrd[] = new float[5];
	static int i;
	
	 
	public static void main(String[] args) {
		String studNum, studName;
		for (i = 0; i < 10; i++) 
		{
			System.out.println("\nStudent " + (i+1));
			studNum = method_InputStudNum();
			studName = method_InputStudName();
			method_InputSubjCode();
			method_callClassSubjectsNumber(studNum);
			method_callClassSubjectsName(studName);
			objSubjects.method_call_clsComputeGenAve();
			objSubjects.methodOutputs();
		}
	}
	
	public static String method_InputStudNum()
	{
		String sno;
		System.out.print("Student Number: ");
		sno = scan.nextLine();
		return sno;
	}
	
	private static String method_InputStudName() 
	{
		String sna;
		System.out.print("Student Name: ");
		sna = scan.nextLine();
		return sna;
	}
	
	
	private static void method_InputSubjCode() 
	{
		for(i=0; i<5; i++)
		{
			System.out.print("Subject Code: ");
			subj_code[i] = scan.nextLine();
			method_InputSubjects();
			objCls2.call_clsSubjects(subj_code[i], subj[i], units[i], midtermgrd[i], finalgrd[i]);
			objCls2.call_clsSubjects(midtermgrd[i], finalgrd[i]);
		}	
	}

	private static void method_InputSubjects() 
	{
		System.out.print("Subject Description: ");
		subj[i] = scan.nextLine();
		method_InputUnits();
	}

	private static void method_InputUnits() 
	{
		System.out.print("Number of Units: ");
		units[i] = scan.nextInt();
		method_InputGrades();
	}

	private static void method_InputGrades() 
	{
		System.out.print("Midterm Grade: ");
		midtermgrd[i] = scan.nextFloat();
		System.out.print("Final Grade: ");
		finalgrd[i] = scan.nextFloat();
		scan.nextLine();
	}

	private static void method_callClassSubjectsName(String sna) 
	{
		objSubjects.studName(sna);		
	}

	private static void method_callClassSubjectsNumber(String sno)
	{
		objSubjects.studNumber(sno);
	}

	

	
}