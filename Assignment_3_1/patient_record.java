package Assignment_3_1; //1

//import java.util.Scanner;

public class patient_record 
{
    private int patientNumber;
    private String patientName, address,birthday, contactNumber;

    // Constructor
    public patient_record(int patientNumber, String patientName, String address, String birthday, String contactNumber) 
    {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.address = address;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
    }

    // Display the patient record
    public void displayRecord() 
    {
        System.out.println("\nPatient Number: " + patientNumber);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Address: " + address);
        System.out.println("Birthday: " + birthday);
        System.out.println("Contact Number: " + contactNumber);
    }

    // Getter methods
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
}

