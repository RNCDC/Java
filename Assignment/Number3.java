package Assignment;

import java.util.*;

public class Number3 
{
	static Scanner scan = new Scanner(System.in);
	static int start, end;
	
	public static void main(String[] args) 
	{
		Input();
		find(start, end);
	}

	public static void Input() 
	{//A
	    System.out.print("Start number: ");
	    start = scan.nextInt();
	    System.out.print("End number: ");
	    end = scan.nextInt();
	}
	
	public static void find(int start, int end) 
	{//B
	    ArrayList<Integer> valueArray = new ArrayList<>(); 
	    //used to extract individual digits from a string num and store them as integers in an array 
	    
	    try 
	    { // for invalids
	      if (start > end) 
	     // {
	        throw new Exception("Invalid! END number should be HIGHER than START number!");
	     // }
	      if (start < 100 || start > 999) 
	     // {
	        throw new Exception("Invalid! START number must contain a 3-digit integer value");
	     // }
	      if (end < 100 || end > 999) 
	     // {
	        throw new Exception("Invalid! END number must contain a 3-digit integer value");
	     // }
	    } 
	    
	    catch (Exception invalids) 
	    { 
	      System.out.println(invalids.getMessage());
	      return;
	    }

	    for (int x = start; x <= end; x++) 
	    { //calculate the cube of a integer
	    	int num = x, sum = 0;
	    	while (num != 0) 
	    	{
                int digit = num % 10;
                sum += digit * digit * digit;
                num /= 10; 
                //performs integer division by 10, effectively removing the rightmost digit from the number num
            }
            if (sum == x) 
           // {
                valueArray.add(x);
           // }
	    }
	    output(valueArray);
	}
	
	public static void output(ArrayList<Integer> valueArray) 
	{//C
		if (valueArray.isEmpty()) 
		{
            System.out.println("There are NO NICOMACHUS number/s");
            return;
        }

        System.out.print("Nicomachus number/s: ");
        for (int valoutput : valueArray) 
        	/*an enhanced for loop, also known as a for-each loop. It iterates over each element in the ArrayList valueArray and assigns each 
        	  element to the variable valoutput successively.*/
       // {
            System.out.printf("%03d ", valoutput);
       // }

        System.out.print("\nReversed number/s:   ");
        for (int num : valueArray) 
        {
            int reverse = 0, originalNum = num;
            while (originalNum != 0) 
            {
                int digit = originalNum % 10;
                reverse = reverse * 10 + digit;
                originalNum /= 10;
            }
            System.out.printf("%03d ", reverse); } } }
