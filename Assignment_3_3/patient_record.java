package Assignment_3_3;

import java.util.ArrayList;
import java.util.List;

public class patient_record 
{
    private int patientNumber;
    private String patientName;
    private String address;
    private String birthday;
    private String contactNumber;
    private int assignedRoomNumber;
    private double room;
    private List<ServiceRecord> services; // List to store services for each patient

    // Constructor
    public patient_record(int patientNumber, String patientName, String address, String birthday, String contactNumber) 
    {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.address = address;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.assignedRoomNumber = -1;
        this.services = new ArrayList<>();
    }
    
    public patient_record(double costForRoom)
    {
    	this.room = costForRoom;
    }

    // Getter and setter methods
    public int getPatientNumber() 
    {
        return patientNumber;
    }

    public String getPatientName() 
    {
        return patientName;
    }

    public String getAddress() 
    {
        return address;
    }

    public String getBirthday() 
    {
        return birthday;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }

    public int getAssignedRoomNumber() 
    {
        return assignedRoomNumber;
    }

    public void setAssignedRoomNumber(int assignedRoomNumber) 
    {
        this.assignedRoomNumber = assignedRoomNumber;
    }

    public List<ServiceRecord> getServices() 
    {
        return services;
    }

    // Add service to the patient's record
   
    
    public void addService(ServiceRecord serviceRecord) 
    {
    	services.add(serviceRecord);
	}

    // Display the patient record
    public void displayRecord() 
    {
        System.out.println("\nPatient Number: " + patientNumber);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Address: " + address);
        System.out.println("Birthday: " + birthday);
        System.out.println("Contact Number: " + contactNumber);
        if (assignedRoomNumber != -1) 
        {
            System.out.println("Assigned Room Number: " + assignedRoomNumber);
        } 
        else 
        {
            System.out.println("Room not assigned yet.");
        }
    

      System.out.println("Services:");
        for (ServiceRecord service : services) 
        {
            System.out.println("- " + service.getServiceName() + ": " + service.getPrice());
        }
        System.out.println("Total Bill for Services: " + calculateTotalBill());
    }

    // Calculate total bill for the patient
   public double calculateTotalBill() 
    {
        double Bill = 0, total = 0;
        for (ServiceRecord service : services) 
        {
            Bill += service.getPrice();
            total = room + Bill;
        }
        return total; 
    }
}

