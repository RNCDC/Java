package assignment1;
import java.util.*;

public class num2 {
	static Scanner scn = new Scanner(System.in);
	static String pName;
	static double distance;
	static String pType;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		double fare = tot(distance);
		display(distance,fare,pType);
	}
		//a
		public static void input() {
			System.out.printf("Passenger Name: ");
			pName = scn.nextLine();
			System.out.printf("Distance Traveled: ");
			distance = scn.nextFloat();
			scn.nextLine();
			System.out.printf("Type of Passenger: ");
			pType = scn.nextLine();
		}
		//b
		public static double tot(double d) {
			return (d > 2) ?  ((Math.ceil(d)-2) * 7.5) + 60 : 60;
		}
		//c
		public static void display(double d, double f, String p) {
			double disc = 0;
			switch (p) {
			case "Senior": disc = f * 0.2; break;
			case "PWD": disc = f * 0.15; break;
			case "Student": disc = f * 0.10; break;
			}
			System.out.printf("Official Receipt\n\tPassenger Name: %s\n\tType of Passenger: %s\n\tTotal Fare: %.2f\n\tDiscount: %.2f\n\tTotal Amount to be Paid: %.2f",pName,p,f,disc,f-disc);
		}
}
