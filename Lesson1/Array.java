package Lesson1;

import java.io.*;
//import java.lang.reflect.Array;
import java.util.*;

public class Array 
{	//BufferedReader reads a couple of characters from the specified stream and stores it in a buffer. 
	//InputStreamReader reads only one character from specified stream and remaining characters still remain in the stream.
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException
	{
		int [] numbers = new int [5];
		int sum = 0;
		
		System.out.print("input numbers: ");
		for (int i = 0; i<5; i++)
		{	//parseInt - convert strings into integers, keyword 'parse'
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.print("Contents of array: \n");
		for (int i = 0; i<5; i++)
		{	
			System.out.print(numbers[i] + "\t");
			sum += numbers[i]; 
		}
		
		System.out.println("\nsum = " + sum);
		
		Arrays.sort(numbers);
		System.out.print("Contents of array in Ascending Order: \n");
		for (int i = 0; i<5; i++)
		{	
			System.out.print(numbers[i] + "\t");
			sum += numbers[i]; 
		}
	}
}
