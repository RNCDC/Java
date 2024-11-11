package Assignment_3_1;

import java.util.Scanner;

public class Main 
{
	static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
        // Array to store patient records
        patient_record[] records = new patient_record[5];

        // Input patient records
        for (int i = 0; i < records.length; i++) 
        {
            System.out.println("\nEnter details for patient #" + (i + 1) + ":");
            try 
            {
                System.out.print("Patient Number: ");
                int patientNumber = Integer.parseInt(scan.nextLine());

                System.out.print("Patient Name: ");
                String patientName = scan.nextLine();

                System.out.print("Address: ");
                String address = scan.nextLine();

                System.out.print("Birthday: ");
                String birthday = scan.nextLine();

                System.out.print("Contact Number: ");
                String contactNumber = scan.nextLine();

                // Create and store patient record
                records[i] = new patient_record(patientNumber, patientName, address, birthday, contactNumber);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number for Patient Number.");
                i--; // Re-prompt for the same record
            }
        }

        // Display patient records
        System.out.println("\n--- Patient Records ---");
        for (patient_record record : records) 
        {
            record.displayRecord();
        }
    }
}
