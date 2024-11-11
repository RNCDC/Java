package Lesson1;

import java.util.Scanner;

public class CharOccurence 
{

	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		String sentence;
		int vowel = 0, cons = 0, digit = 0, special = 0, space = 0;
		System.out.print("Sentence: ");
		sentence = scan.nextLine();
		for (int i = 0; i < sentence.length(); i++)
		{
			if ((sentence.charAt(i) >= 'a') && (sentence.charAt(i) <= 'z'))
				if ((sentence.charAt(i) == 'a') || (sentence.charAt(i) == 'e') || (sentence.charAt(i) == 'i') || (sentence.charAt(i) == 'o') || (sentence.charAt(i) == 'u'))
					vowel ++;
				else
					cons ++;
			else if ((sentence.charAt(i) >= '0') && (sentence.charAt(i) <= '9'))
				digit ++;
			else if (sentence.charAt(i) == ' ')
				space ++;
			else
				special ++;
		}
		System.out.println("Vowel: " + vowel);
		System.out.println("Consonant: " + cons);
		System.out.println("Digit: " + digit);
		System.out.println("Space: " + space);
		System.out.println("Special Character: " + special);
	}

}
