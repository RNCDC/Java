package test;

import java.util.ArrayList;
import java.util.Scanner;

public class kris_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<PatientRecord> patients = inputPatientRecords(scanner);
        ArrayList<RoomRecord> rooms = inputRoomRecords(scanner);
        ArrayList<ServiceRecord> services = inputServiceRecords(scanner);

        assignRoomToPatient(scanner, patients, rooms);

        computeTotalBill(patients, rooms, services);

        scanner.close();
    }

    // Method for inputting patient records
    public static ArrayList<PatientRecord> inputPatientRecords(Scanner scanner) {
        ArrayList<PatientRecord> patients = new ArrayList<>();
        System.out.println("Input patient Records ");
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("Patient Number: ");
                int patnum = Integer.parseInt(scanner.nextLine());
                System.out.println("Patient Name: ");
                String patname = scanner.nextLine();
                System.out.println("Enter Address: ");
                String add = scanner.nextLine();
                System.out.println("Enter Birthday: ");
                String bday = scanner.nextLine();
                System.out.println("Contact Number: ");
                String conNum = scanner.nextLine();
                PatientRecord patient = new PatientRecord(patnum, patname, add, bday, conNum);
                patients.add(patient);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
                i--;
            }
        }
        return patients;
    }

    // Method for inputting room records
    public static ArrayList<RoomRecord> inputRoomRecords(Scanner scanner) {
        ArrayList<RoomRecord> rooms = new ArrayList<>();
        System.out.println("\nInput Room Records ");
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Room Type: ");
                String roomType = scanner.nextLine();
                System.out.println("Room Number: ");
                int roomNum = Integer.parseInt(scanner.nextLine());
                System.out.println("Price per Day: ");
                double pricePerDay = Double.parseDouble(scanner.nextLine());
                RoomRecord room = new RoomRecord(roomType, roomNum, pricePerDay);
                rooms.add(room);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid Number");
                i--;
            }
        }
        return rooms;
    }

    // Method for inputting service records
    public static ArrayList<ServiceRecord> inputServiceRecords(Scanner scanner) {
        ArrayList<ServiceRecord> services = new ArrayList<>();
        System.out.println("\nInput Service Records ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Service Type: ");
            String serviceType = scanner.nextLine();
            System.out.println("Service Name: ");
            String serviceName = scanner.nextLine();
            ServiceRecord service = new ServiceRecord(serviceType, serviceName);
            services.add(service);
        }
        return services;
    }

    // Method for assigning room to a patient
    public static void assignRoomToPatient(Scanner scanner, ArrayList<PatientRecord> patients, ArrayList<RoomRecord> rooms) {
        System.out.println("\nAssigning Room to Patients");
        for (PatientRecord patient : patients) {
            System.out.println("\nInput Patient Number: " + patient.patnum);
            int patnum = patient.patnum;
            RoomRecord room = searchRoom(scanner, rooms);
            if (room != null) {
                System.out.println("Number of days: ");
                int daysStayed = Integer.parseInt(scanner.nextLine());
                System.out.println("Patient " + patient.patname + " stayed in Room " + room.roomNum + " for " + daysStayed + " days.");
            } else {
                System.out.println("Patient does not exist!");
            }
        }
    }

    // Method for searching a room
    public static RoomRecord searchRoom(Scanner scanner, ArrayList<RoomRecord> rooms) {
        System.out.println("Room Number: ");
        int roomNum = Integer.parseInt(scanner.nextLine());
        for (RoomRecord room : rooms) {
            if (room.roomNum == roomNum) {
                return room;
            }
        }
        System.out.println("Room does not exist!");
        return null;
    }

    // Method for computing total bill
    public static void computeTotalBill(ArrayList<PatientRecord> patients, ArrayList<RoomRecord> rooms, ArrayList<ServiceRecord> services) {
        System.out.println("\nComputing Total Bill for Each Patient");
        for (PatientRecord patient : patients) {
            double totalBill = 0;
            System.out.println("\nPatient Number: " + patient.patnum);
            // Calculate room charges
            for (RoomRecord room : rooms) {
                totalBill += room.pricePerDay; // Add price per day
            }
            // Display service charges
            for (ServiceRecord service : services) {
                System.out.println("Patient Number: " + patient.patnum);
                System.out.println("Service Name: " + service.serviceName);
                // Assuming you have a method to get service price
                double servicePrice = getServicePrice(service);
                System.out.println("Price: " + servicePrice);
                totalBill += servicePrice; // Add service price to total bill
            }
            System.out.println("Total Bill: " + totalBill);
        }
    }

    // Method to get service price (can be replaced with actual implementation)
    public static double getServicePrice(ServiceRecord service) {
        // This is a placeholder method. Replace it with actual logic to get service price.
        // For simplicity, returning a fixed price here.
        return 0; // Placeholder value
    }
}

class PatientRecord {
    int patnum;
    String patname;
    String add;
    String bday;
    String conNum;

    public PatientRecord(int patnum, String patname, String add, String bday, String conNum) {
        this.patnum = patnum;
        this.patname = patname;
        this.add = add;
        this.bday = bday;
        this.conNum = conNum;
    }
}

class RoomRecord {
    String roomType;
    int roomNum;
    double pricePerDay;

    public RoomRecord(String roomType, int roomNum, double pricePerDay) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.pricePerDay = pricePerDay;
    }
}

class ServiceRecord {
    String serviceType;
    String serviceName;

    public ServiceRecord(String serviceType, String serviceName) {
        this.serviceType = serviceType;
        this.serviceName = serviceName;
    }
}
