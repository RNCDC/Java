package Assignment_3_2;

import java.util.Scanner;

public class Main 
{
	static Scanner scanner = new Scanner(System.in);
	static int i;
	
    public static void main(String[] args) 
    {
    	try 
    	{
    		// Array to store patient records
    		patient_record[] patientRecords = new patient_record[2];
    		// Array to store room records
    		room_record[] roomRecords = new room_record[3];

    		// Input patient records
    		for (i = 0; i < patientRecords.length; i++) //no.1
    		{
    			System.out.println("\nEnter details for patient #" + (i + 1) + ":");
    			System.out.print("Patient Number: ");
    			int patientNumber = Integer.parseInt(scanner.nextLine());

    			System.out.print("Patient Name: ");
    			String patientName = scanner.nextLine();

    			System.out.print("Address: ");
    			String address = scanner.nextLine();

    			System.out.print("Birthday: ");
    			String birthday = scanner.nextLine();

    			System.out.print("Contact Number: ");
    			String contactNumber = scanner.nextLine();

    	       // Create and store patient record
    			patientRecords[i] = new patient_record(patientNumber, patientName, address, birthday, contactNumber);
    		}

    		// Input room records
    		for (i = 0; i < roomRecords.length; i++)
    		{
    			System.out.println("\nEnter details for room #" + (i + 1) + ":");
    			System.out.print("Room Type: ");
    			String roomType = scanner.nextLine();

    			System.out.print("Room Number: ");
    			int roomNumber = Integer.parseInt(scanner.nextLine());

    			System.out.print("Price per Day: ");
    			double pricePerDay = Double.parseDouble(scanner.nextLine());

    			// Create and store room record
    			roomRecords[i] = new room_record(roomType, roomNumber, pricePerDay);
    		}

    		// Search for a patient
    		System.out.print("\nInput patient number: ");
    		int searchPatientNumber = Integer.parseInt(scanner.nextLine());
    		patient_record foundPatient = null;
    		for (patient_record patient : patientRecords) 
    		{
    			if (patient.getPatientNumber() == searchPatientNumber) 
    			{
    				foundPatient = patient;
    				break;
    			}
    		}

    		if (foundPatient != null) 
    		{
    			System.out.print("Room Number: ");
    			int roomNumber = Integer.parseInt(scanner.nextLine());
            
    			// Check if room number exists
    			boolean roomFound = false;
            	for (room_record room : roomRecords) 
            	{
            		if (room.getRoomNumber() == roomNumber) 
            		{
            			roomFound = true;
                    	break;
            		}
            	}

            	if (roomFound) 
            	{
            		System.out.print("Number of days: ");
            		int daysStayed = Integer.parseInt(scanner.nextLine());
                	foundPatient.setAssignedRoomNumber(roomNumber); 
            	}  
            
            	else 
            	{
            		System.out.println("Room not found.");
            	}
    		} 
        
    		else 
    		{
    			System.out.println("Patient not found.");
    			return;
    		}

        	// Display patient records
        	System.out.println("\n\n--- Patient Records ---");
        	for (patient_record record : patientRecords) 
        	{
            	record.displayRecord();
        	}
        
    	} 
    	catch (NumberFormatException e) 
    	{
            System.out.println("Invalid input. Please enter a valid number.");
        }
    	catch (Exception e) 
    	{
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
      }
}


/*	double price = 0.0;
// Get the price based on room number
switch (roomNumber) 
   {
       case 101:
           price = 500.00;
           break;
       case 102:
           price = 550.00;
           break;
       case 103:
           price = 400.00;
           break;
       case 201:
           price = 750.00;
           break;
       case 202:
           price = 900.00;
           break;
       case 301:
           price = 1200.00;
           break;
       case 302:
           price = 1500.00;
           break;
       case 305:
           price = 600.00;
           break;
       case 401:
           price = 5000.00;
           break;
       case 402:
           price = 600.00;
           break;
       default:
           System.out.println("Invalid room number.");
           return;
   }

//	double totalCost = daysStayed * roomRecords[roomNumber - 1].getPricePerDay(); //error
double totalCost = daysStayed * price;
System.out.printf("Total cost for the stay: %.2f", totalCost);*/