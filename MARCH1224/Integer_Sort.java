package MARCH1224;

import java.util.Scanner;

public class Integer_Sort 
{
	public static void main(String[] args) 
	{	
		Scanner scan = new Scanner(System.in);
		int[] num = new int[10];
		
		for(int x=0; x<10; x++)
		{
			System.out.print("No.(" + (x+1) + "): ");
			num[x] = scan.nextInt();
		}
		
		int high = num[0];
		int low = num[0];
		int highind = 0;
		int lowind = 0;
	
		for(int x=1; x<10; x++)
		{
			if(num[x]>high)
			{
				high=num[x];
				highind=x;
			}
			if(num[x]<low)
			{
				low=num[x];
				lowind=x;
			}
		}
		
		System.out.println("Highest: " + high + " Index: " + highind);
		System.out.println("Lowest: " + low + " Index: " + lowind);
	}
}
