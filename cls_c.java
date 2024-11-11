package act_4;

import java.util.Scanner;
//C Create transaction input
public class cls_c {
	static cls_a a = new cls_a();
	static cls_d d = new cls_d();
	static String transaction;
	static float amount, balance;
	static Scanner scan = new Scanner(System.in);

	public static void setInit() {
		balance = a.getBalance();
	}
	public static void transaction() {
		setInit();
		transactInput();
	}
	public static void transactInput() {
		try {
			System.out.print("Transaction: ");
			transaction = scan.nextLine();
			if (!transaction.equalsIgnoreCase("Deposit")
					&& !transaction.equalsIgnoreCase("Withdraw")) {
				throw new Exception("Transaction type unknown!");
			}
			amount();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void amount() {
		System.out.print("Amount: ");
		amount = scan.nextFloat();
		scan.nextLine();
		transacType(transaction, amount);
	}

	public static void transacType(String transaction, float amount) {
		if (transaction.equalsIgnoreCase("deposit")) {
			deposit(amount);
		} else if (transaction.equalsIgnoreCase("withdraw")) {
			withdraw(amount);
		}
		d.transactAgain();
	}

	public static void deposit(float amount) {
		balance += amount;
	}

	public static void withdraw(float amount) {
		try {
			if (balance >= amount) {
				balance -= amount;
			} else {
				throw new Exception("Insufficient balance");
			}
		} catch (Exception e) {
			System.out.println("Insufficient balance");
			System.exit(0); 
		}
		return;

	}

	public float getBalance() {
		return balance;
	}
}
