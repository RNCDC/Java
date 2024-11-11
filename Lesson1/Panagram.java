package Lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Panagram 
{
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		String msg;
		int count = 0;
		System.out.print("Sentence: ");
		msg = scan.nextLine();
		char [] kar = new char[msg.length()];
		kar = msg.toCharArray();
		
		Arrays.sort(kar);
		for (int i = 0; i < kar.length-1; i++)
		{
			if (kar[i] != kar[i+1])
				count ++;
		}
		
		if (count == 26)
			System.out.println("Sentence is Panagram");
		else
			System.out.println("Sentence is not Panagram");
	}

}
