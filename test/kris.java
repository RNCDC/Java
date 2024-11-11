package test;

import java.util.Scanner;
public class kris 
{
	String studentNumber;
	String name;
	Subject[] subjects;
	
	kris(String studentNumber, String name) 
	{
		this.studentNumber = studentNumber;
		this.name = name;
		this.subjects = new Subject[5];
	}
	

}

class Subject 
{
	String code;
	String description;
	int units;
	double midgrade;
	double fingrade;
	
	Subject(String code, String description, int units) 
	{
		this.code = code;
		this.description = description;
		this.units = units;
	}
}

 class StudentGrades {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		kris [] students = new kris [10];
		double totalweightAve = 0;
		int passcount = 0;
		int failcount = 0;
		
		//student record
		for (int i =0; i < students.length; i++) {
			System.out.println("Enter details for Students" + (i + 1) + ":");
			System.out.print("Student Number" + (i + 1) + ":");
			scanner.next();
			String studentNumber = scanner.nextLine();
			System.out.print("Name" + (i + 1) +  ":");
			String name = scanner.nextLine();
			students[i] = new kris(studentNumber, name);
			for (int j =0; j < students[i].subjects.length; j++) {
				System.out.println("Enter details for Subject" + (j + 1) + ":");
				System.out.print("Code: ");
				String code = scanner.next();
				scanner.nextLine();
				System.out.print("Description: ");
				String description = scanner.nextLine();
				System.out.print("Number of Units: ");
				int units = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Midterm Grades: ");
				double midgrade = scanner.nextDouble();
				System.out.print("Final Grade: ");
				double fingrade = scanner.nextDouble();
				students[i].subjects[j] = new Subject(code, description, units);
				students[i].subjects[j].midgrade = midgrade;
				students[i].subjects[j].fingrade = fingrade;
			}
		}
		
		//calculate weighted average and count pass/fail per sub
		for (kris student : students) {
			double totalgradepoints = 0;
			int totalunits = 0;
			boolean passed = true;
			for (Subject subject : student.subjects) {
				double subjectGrade = (subject.midgrade + subject.fingrade) /2;
				totalgradepoints += subjectGrade * subject.units;
				totalunits += subject.units;
				if (subjectGrade < 75) {
					passed = false;
				}
			}
			
			double weightedAve = totalgradepoints / totalunits;
			weightedAve += weightedAve;
			if (passed) {
				passcount++;
			} else  {
				failcount++;
			}
		}
		
		//display pass/fail per sub
		System.out.println("Pass/Fail per Sub: ");
		System.out.println("Subject\t\tPass\tFail");
		//System.out.println("------------------------");
		System.out.println("COMP 123\t" + passcount + "\t" + failcount);
		System.out.println("ACCT 100\t" + passcount + "\t" + failcount);
		System.out.println("MATH 143\t" + passcount + "\t" + failcount);
		System.out.println("PE 003\t\t" + passcount + "\t" + failcount);
		System.out.println("NATSCI 378\t" + passcount + "\t" + failcount);
		
		//calculate and display gen weight ave
		double genWeightedAve = totalweightAve / students.length;
		System.out.println("\nGeneral Weighted Average: " + genWeightedAve);
	}
	
}



