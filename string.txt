package Lesson1;

import java.util.Scanner;

public class Strings 
{
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		char [] msg = {'i', ' ', 'm', 'i', 's', 's', ' ', 'y', 'o', 'u'};
		System.out.print("String 1: ");
		String str1 = scan.nextLine();
		System.out.print("String 2: ");
		String str2 = scan.nextLine();
		
		//+ is to connect 2 strings 
		//ex. str1 = hi  str2 = yanna  out: hi yanna
		String str3 = str1 + str2;
		
		//concat is to connect 2 strings, the one inside the () is what you will add to the stated variable
		//ex. str1 = hi  str2 = yanna  out: hiyanna
		String str4 = str1.concat(str2); 

		//the word 'new' will change the object/ data type to a new one
		//ex. from char [] msg to String msg
		String str5 = new String(msg);
				
		System.out.println("String 3: " + str3);
		System.out.println("String 4: " + str4);
		System.out.println("String 5: " + str5);
		
		//len is declared as integer variable
		//keyword is '.length' and its for counting the characters 
		int len = str5.length();
		System.out.println("Length of String 5: " + len);
		
		//kar1 is declared as character variable
		//keyword is '.charAt(x)' and its for outputting the character at the given index
		char kar1 = str4.charAt(10);
		System.out.println("Character at index 10: " + kar1);
		
		//keyword is '.substring(x)' and its about what is left after the given index
		//ex.  str1 = hi  str2 = yanna  str3 = hiyanna   out:na
		String str6 = str3.substring(5);
		System.out.println("Substring of String 3: " + str6);
		
		//keyword is '.indexOf(x)' and its about how many index before the character you declare 
		//ex.  str5 = i miss you   out:7
		int index = str5.indexOf("y");
		System.out.println("Index of 'y': " + index);
		
		//keyword is '.lastIndexOf(x)' and its about how many index before the LAST character you declare
		//ex.  str3 = welcomeyanna   out:11
		int ind = str3.lastIndexOf("a");
		System.out.println("Last index of 'a': " + ind); 
		
		System.out.print("St1: ");
		String st1 = scan.nextLine();
		System.out.print("St2: ");
		String st2 = scan.nextLine();
		
		//keyword is 'boolean' and its a condition statement to check if the value are the same
		//ex.  st1 = welcome  st2 = Welcome  bool1: false  bool2: true
		boolean bool1 = st1.equals(st2);
		boolean bool2 = st1.equalsIgnoreCase(st2);
		System.out.println("Boolean 1: " + bool1);
		System.out.println("Boolean 2: " + bool2);
		
		//keyword is '.toUpperCase()' and '.toLowerCase()' common sense!!
		//ALL characters will change
		String str7 = str3.toUpperCase();
		String str8 = str5.toLowerCase();
		System.out.println("String 7: " + str7);
		System.out.println("String 8: " + str8);
		
		//keyword is '.compareTo(var)' and 'st1.compareToIgnoreCase(var)' 
		//compare the ascii of the first character
		//ex. st1 = Wel  st2= wel  comp1 = -32  comp2 = 0
		int comp1 = st1.compareTo(st2);
		int comp2 = st1.compareToIgnoreCase(st2);
		System.out.println("Comp 1: " + comp1);
		System.out.println("Comp 2: " + comp2);
		
		System.out.print("St3: ");
		String st3 = scan.nextLine();
		
		//keyword is '.trim()'
		//removing the spaces at front and end
		//ex. ( _ is space )  _ _ _ _hello yanna _ _. _ _ _   out: hello yanna _ _.
		System.out.println("Trim st3: " + st3.trim());
		
		//keyword is ' .replace('char', 'replacement') '
		//replacing the declared character with different character
		//ex. st3 = hello yanna  out: h*llo yanna
		System.out.println("Replace 'e': " + st3.replace('e','*')); 
		
		//printing of array of characters with for loop
		char [] kar2 = new char[st1.length()];
		kar2 = st1.toCharArray();
		System.out.println("Array of Characters: ");
		for (int i=0; i<st1.length(); i++)
			System.out.println(kar2[i]); 
		
		//keyword is '.contains' common sense!!!
		System.out.println("\nString contains 'you': " + str5.contains("you"));
	}
}
