package Activity3;

public class LetterC 
{
	static double noHrs, rph;
	// accept number of hours
	public void numHours(double hrs) 
	{
		noHrs = hrs;
	}
		
	// accept rate per hour
	public void ratepH (double rateperhour) 
	{
		rph = rateperhour;
	}
		
	// return grosspay
	public double grosspay() 
	{
		return((noHrs*rph));
	}
}
