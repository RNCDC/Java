package Activity3;

public class LetterD 
{ 
	static LetterC getC = new LetterC();
	static double gpay, ded, NP;
	
	//accept grosspay from LetterC
	public void grossPay(double gp) 
	{
		gpay = gp;

	}

	//accept amount of deduction
	public void deduction(double dc) 
	{
		ded = dc;
	}
		
	//compute the netpay
	public double netpay() 
	{
		NP = gpay - ded;
		return NP;
	}
}
