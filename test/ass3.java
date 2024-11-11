package test;

import java.util.Scanner;

public class ass3 {
    static Scanner scan = new Scanner(System.in);
    static int passedCount = 0;
    static int failedCount = 0;
    static int b;
    static String studNum, studName;
    public static void main(String[] args) {
        for (int b = 0; b < 3; b++) {
            inputStudentData();
        }
        System.out.println("\nTotal Number of Students Passed: " + passedCount);
        System.out.println("Total Number of Students Failed: " + failedCount);
    }

    public static void inputStudentData() {
        studNum = input("Student Number");
        studName = input("Student Name");

        for (int i = 0; i < 5; i++) 
        {
            String subjCode = input("Subject Code");
            String subjDesc = input("Subject Description");
            int units = Integer.parseInt(input("Number of Units"));
            float midtermGrd = Float.parseFloat(input("Midterm Grade"));
            float finalGrd = Float.parseFloat(input("Final Grade"));
            float aveGrade = (midtermGrd + finalGrd) / 2;
            System.out.println("Student Number" + studNum);
            System.out.println("Student Name" + studName);
            System.out.println("Average: " + aveGrade);
            float genAve = aveGrade * units;

            /*for(b = 0; b < 3; b++)
            {
            	
            }*/
        }
    }

    public static String input(String prompt) {
        System.out.print(prompt + ": ");
        return scan.nextLine();
    }
}

