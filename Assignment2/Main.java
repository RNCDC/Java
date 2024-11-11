package Assignment2; //Number 1

import java.util.Scanner;

public class Main 
{
	static Scanner scan = new Scanner(System.in);
	static int[] units = new int[50];
	static String subj_code[] = new String[50];
	static String subj[] = new String[50];
	static float[] midtermgrd = new float[50];
	static float finalgrd[] = new float[50];
	static int i;
	static float gwa;
	static int passedCount = 0;
    static int failedCount = 0;
	static cls_Class2  objCls2 = new cls_Class2();
	static cls_Subjects objSubjects = new cls_Subjects();
	
	public static void main(String[] args) 
	{
		int b;
		for (b = 0; b < 10; b++) 
		{
			String studNum = method_InputStudNum();
			String studName = method_InputStudName();
			method_InputSubjCode();
			method_callClassSubjectsNumber(studNum);
			method_callClassSubjectsName(studName);
			gwa = objSubjects.method_call_clsGenAve();
			//gwa = objSubjects.getGenAve(); // Assigning GWA
            objSubjects.methodOutputs();
            
            if (gwa <= 3) {
                passedCount++; // Increment passed count
            } else {
                failedCount++; // Increment failed count
            }
            System.out.printf("Total number of Students: %d\n\n",b+1);
        }

        // Displaying the number of students who passed and failed
        System.out.println("Total Number of Students Passed: " + passedCount);
        System.out.println("Total Number of Students Failed: " + failedCount);
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
			System.out.print("\nSubject Code: ");
			subj_code[i] = scan.nextLine();
			method_InputSubjects();
			objCls2.call_clsSubjects(units[i], midtermgrd[i], finalgrd[i]);
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
