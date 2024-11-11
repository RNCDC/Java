package Assignment_3_3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main 
{
	static Scanner scanner = new Scanner(System.in);
	static int i;
	
    public static void main(String[] args) 
    {
    	try 
    	{
    		// ArrayList to store patient records
            ArrayList<patient_record> patientRecords = new ArrayList<>();
            // ArrayList to store room records
            ArrayList<room_record> roomRecords = new ArrayList<>();
            // ArrayList to store service records
            ArrayList<ServiceRecord> serviceRecords = new ArrayList<>();

            // Input patient records
            for (i = 0; i < 2; i++) //no.1
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
            	patientRecords.add(new patient_record(patientNumber, patientName, address, birthday, contactNumber));
            }

            // Input room records
            for (i = 0; i < 3; i++)
            {
            	System.out.println("\nEnter details for room #" + (i + 1) + ":");
            	System.out.print("Room Type: ");
            	String roomType = scanner.nextLine();

            	System.out.print("Room Number: ");
            	int roomNumber = Integer.parseInt(scanner.nextLine());

            	System.out.print("Price per Day: ");
            	double pricePerDay = Double.parseDouble(scanner.nextLine());

            	// Create and store room record
            	roomRecords.add(new room_record(roomType, roomNumber, pricePerDay));
            }
		
            // Search for a patient 
            for (i = 0; i < 2; i++) 
            {
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

            		// Define room prices
            		Map<Integer, Double> roomPrices = new HashMap<>();
            		roomPrices.put(101, 500.00);
            		roomPrices.put(102, 550.00);
            		roomPrices.put(103, 400.00);
            		roomPrices.put(201, 750.00);
            		roomPrices.put(202, 900.00);
            		roomPrices.put(301, 1200.00);
            		roomPrices.put(302, 1500.00);
            		roomPrices.put(305, 600.00);
            		roomPrices.put(401, 5000.00);
            		roomPrices.put(402, 600.00);

            		if (roomFound) 
            		{
            			System.out.print("Number of days: ");
            			int daysStayed = Integer.parseInt(scanner.nextLine());

            			double price = roomPrices.getOrDefault(roomNumber, 0.0);
            			if (price != 0.0) 
            			{
            				double costForRoom = daysStayed * price;
            				System.out.printf("Cost for the Room: %.2f\n", costForRoom);
            				patientRecords.add(new patient_record(costForRoom));
            				foundPatient.setAssignedRoomNumber(roomNumber);
            			} 
            			
            			else 
            			{
            				System.out.println("Invalid room number.");
            			}
            		} 
            		
            		else 
            		{
            			System.out.println("Room not found.");
            			return;
            		}

            	} 
    
            	else 
            	{
            		System.out.println("Patient not found.");
            		return;
            	}
            }

            // Input service records
            for (i = 0; i < 3; i++) 
            {
            	System.out.println("\nEnter details for service #" + (i + 1) + ":");
            	System.out.print("Service Type: ");
            	String serviceType = scanner.nextLine();

            	System.out.print("Service Name: ");
            	String serviceName = scanner.nextLine();

            	// Create and store service record
            	serviceRecords.add(new ServiceRecord(serviceType, serviceName));
            }

            // Input services for each patient and compute total bill
            for (i = 0; i < 2; i++)
            {
            	patient_record patient = patientRecords.get(i);
            	System.out.println("\nEnter services for patient " + patient.getPatientName() + ": (Enter 'done' to finish)");
            	while (true) 
            	{
            		System.out.print("Service Name: ");
            		String serviceName = scanner.nextLine();
            		if (serviceName.equalsIgnoreCase("done")) 
            		{
            			break;
            		}

            		boolean serviceFound = false;
            		for (ServiceRecord service : serviceRecords) 
            		{
            			if (service.getServiceName().equalsIgnoreCase(serviceName)) 
            			{
            				serviceFound = true;
            				System.out.print("Price for " + service.getServiceName() + ": ");
            				double serprice = Double.parseDouble(scanner.nextLine());
            				patient.addService(new ServiceRecord(service.getServiceType(),serviceName));
            				patient.addService(new ServiceRecord(serprice));
            				break;
            			}
            		}
            		if (!serviceFound) 
            		{
            			System.out.println("Service not found.");
            		}
            	}
            }  

        	// Display patient records with total bill
        	System.out.println("\n--- Patient Records ---");
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


