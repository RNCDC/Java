package Lesson1;

import java.util.*;

public class Reverse 
{
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		String word; int j = 0;
		System.out.print("String: ");
		word = scan.nextLine();
		char rev[] = new char[word.length()];
		char revWord[] = new char[word.length()];
		
		System.out.println("Original String: " + word);
		rev = word.toCharArray();
		for (int i = rev.length-1; i > -1; i--)
		{
			revWord[j] = rev[i];
			j++;
		}
		
		System.out.print("Reverse String: ");
		for (int i = 0; i < revWord.length; i++)
			System.out.print(revWord[i]);
	}

}
