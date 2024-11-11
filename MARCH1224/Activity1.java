package MARCH1224;

import java.util.Scanner;

public class Activity1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;
		System.out.print("Sentence: ");
		input = scan.nextLine().replaceAll("\\s+","");
		char[] charRev = input.toCharArray();
		char[] rev = new char[input.length()];
		
		int word = input.length() -1;
		for(int x=0; x<=input.length()-1; x++)
		{
			rev[x] = charRev[word];
			word--;
			
		}
		
		for(int x=0; x<=input.length()-1; x++)
		{
			if (charRev[x]==rev[x])
			{
				System.out.print("Palindrome");
				break;
			}
			else
			{
				System.out.print("Not Palindrome");
				break;
			}
		}
	}
}
