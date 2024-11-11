package act_4;
import java.util.InputMismatchException;
import java.util.Scanner;
//B Create method inputs
public class cls_b {
    static cls_a a = new cls_a();
    static cls_c c = new cls_c();
    static cls_d d = new cls_d();
    static int accno;
    static float deposit;
    static String accname;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        inputAccNum();
        inputAccName();
        inputInitDep();
        a.setAccount(accno, accname, deposit);
        c.transaction();
    }

    public static void inputAccNum() {
        try {
            System.out.print("Account Number: ");
            accno = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Account Number!");
            System.exit(0); 
        }
    }

    public static void inputAccName() {
        try {
            scan.nextLine();
            System.out.print("Account Name: ");
            accname = scan.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid Account Name!");
            System.exit(0); 
        }
    }

    public static void inputInitDep() {
        try {
            System.out.print("Initial Deposit: ");
            deposit = scan.nextFloat();
        } catch (Exception e) {
            System.out.println("Invalid Initial Deposit!");
            System.exit(0); 
        }
    }
}
