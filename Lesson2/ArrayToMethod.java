package Lesson2;

import java.io.*;

public class ArrayToMethod 
{
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	//IOException is a checked exception in Java 
	//indicates a problem while performing Input/Output (I/O) operations. 
	public static void main(String[] args) throws IOException
	{
		int numbers [] = new int [10];
		int low;
		method_inputs(numbers);
		System.out.print("Input Values: ");
		for (int i = 0; i < 10; i++)
		{
			System.out.print(numbers[i] + "\t");
		}
		
		low = method_getLow(numbers);
		System.out.print("\nLowest Value: " + low);
	}
	
	public static void method_inputs(int[] num) throws IOException
	{
		System.out.print("Input numbers: ");
		for (int i = 0; i < 10; i++)
		{
			num [i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static int method_getLow(int no[])
	{
		int lo = no[0], high;
		for (int i = 1; i < 9; i++)
			if (lo > no[i])
				lo = no[i];
		
		high = method_getHigh(no);
		System.out.print("\nHighest Value: " + high);
		return (lo);
	}
	
	public static int method_getHigh(int no[])
	{
		int hi = no[0];
		for (int i = 1; i < 9; i++)
			if (hi < no[i])
				hi = no[i];
		
		return (hi);
	}
}
