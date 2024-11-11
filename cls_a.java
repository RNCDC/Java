package act_4;

public class cls_a {
	// A Create constructor
	static int accno;
	static String accname;
	static float init_deposit;
	static cls_c c = new cls_c();
	public void setAccount(int accountNumber, String accountName,
			float initialDeposit) {
		accno = accountNumber;
		accname = accountName;
		init_deposit = initialDeposit;
	}

	public int getAccountNumber() {
		return accno;
	}

	public String getAccountName() {
		return accname;
	}

	public float getBalance() {
		return init_deposit;
	}
}
