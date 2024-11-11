package act_4;

import java.util.Scanner;

//D Output all inputs on the constructor
public class cls_d {
	static Scanner scan = new Scanner(System.in);
	static cls_a a = new cls_a();
	static cls_c c = new cls_c();
	static int times = 0;

	public void output() {
		String accname = a.getAccountName();
		int accno = a.getAccountNumber();
		float bal = c.getBalance();

		System.out.println("\nAccount Number:\t\t" + accno);
		System.out.println("Account Name:\t\t" + accname);
		System.out.println("Outstanding Balance:\t" + bal);
	}

	public void transactAgain() {

		String x;
		System.out.print("Transact again? y/n");
		x = scan.next().toLowerCase();
		if (x.equals("y")) {
			c.transactInput();
		} else {
			output();
		}
	}

}
