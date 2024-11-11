package Lesson1;

import java.util.*;

public class LongestWord 
{
	
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		String sentence;
		System.out.print("Input Sentence: ");
		sentence = scan.nextLine();
		String words[] = sentence.split(" ");
		for (int i = 0; i < words.length; i++)
			System.out.print(words[i] + "\t");
		System.out.println();
		
		int[] len = new int[words.length];
		for (int i = 0; i < words.length; i++)
			len[i] = words[i].length();
		
		int longLength = len[0];
		for (int i = 1; i < len.length; i++)
			if(len[i] > longLength)
				longLength = len[i];
		
		System.out.print("Longest Word/s: ");
		for (int i = 0; i < words.length; i++)
		{
			if (words[i].length() == longLength)
				System.out.print(words[i] + "\t");
		}
	}

}
