package Lesson2;

//if public final can't be use anymore
//class_name of the class_currently_on then the class_name of the class you want to inherit
public class Call_Method extends Method // inherited the Method
{	
	public static void main(String[] args) 
	{
		//call the method inputNumber from the Method
		int number = Method.inputNumber(); 
		System.out.print("Input Value is: " + number + "\n");
		
		// Method. or (class_name).  like the hpw you use correlation name/function in mysql
		Method.factors(number); 
		Method.count = Method.determine(number); 
		Method.primeCompo(); 
	}
}
