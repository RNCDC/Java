package Assignment_3_2;

public class patient_record 
{

    private int patientNumber;
    private String patientName;
    private String address;
    private String birthday;
    private String contactNumber;
    private int assignedRoomNumber; // Added for room assignment

    // Constructor
    public patient_record(int patientNumber, String patientName, String address, String birthday, String contactNumber) 
    {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.address = address;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.assignedRoomNumber = -1; // Initialized to -1 indicating no room assigned initially
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
    }
}


