package Lesson2;

//just like a function in a seperate file, without function calls or anything
//connected to Call_Abstract
public class Abstract 
{
	public long method_OverLoad(int no1, int no2)
	{
		return (no1 * no2);
	}
	
	public void method_OverLoad(int no[])
	{
		float quo = (float) no[0] / no[1];
		System.out.println("Quotient: " + quo);
	}
}
