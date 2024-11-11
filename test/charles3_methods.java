package test;

import java.util.*;

public class charles3_methods {

  static Scanner scan = new Scanner(System.in);
  static int start, end;
  
  // Problem 3
  // A
  public static void nicomachusInput() {
    System.out.print("Start number: ");
    start = scan.nextInt();
    System.out.print("End number: ");
    end = scan.nextInt();
  }

  // B
  public static void nicomachusSearch(int startRange, int endRange) {
    
    ArrayList<Integer> nicomachusArr = new ArrayList<>(); //line 122
    /*The line ArrayList<Integer> nicomachusArr = new ArrayList<>(); in Java means that you are creating a new ArrayList 
     named nicomachusArr that can hold Integer objects.

	Breaking it down:

	ArrayList<Integer>: This specifies the type of elements that the ArrayList will contain. In this case, it's Integer. 
	This means you can only add Integer objects (or subclasses of Integer) to this ArrayList. 
	The angle brackets <Integer> indicate a generic type declaration, allowing you to specify the type of objects the 
	ArrayList can hold.

	nicomachusArr: This is the name of the ArrayList. You can choose any valid identifier as the name.

	new ArrayList<>(): This part creates a new instance of the ArrayList class. The <> is a diamond operator introduced in 
	Java 7 which allows type inference. It means you don't have to specify the type again; it's automatically inferred 
	from the left side of the assignment (ArrayList<Integer>).

	Putting it all together, the line creates a new ArrayList named nicomachusArr that can hold Integer objects. 
	You can then add, remove, or manipulate Integer elements in this ArrayList using methods provided by the ArrayList class.*/
    
    try 
    {
      if (startRange > endRange) {
        throw new Exception("!!!Start number should be less than the end number!!!");
      }
      if (startRange < 100 || startRange > 999) {
        throw new Exception("!!!Invalid!!! Start number should be 3-digit number");
      }
      if (endRange < 100 || endRange > 999) {
        throw new Exception("!!!Invalid!!! End number should be 3-digit number");
      }
    } 
    catch (Exception e) 
    { /*catch (Exception e): This follows a try block and is used to catch exceptions. In this specific case, 
    Exception is the type of exception being caught, and e is the variable name that will refer to the exception object 
    if an exception occurs.*/
      System.out.println(e.getMessage());
      /*In Java, e.getMessage() is a method used to retrieve the error message associated with an exception object.
       getMessage(): This is a method provided by the Throwable class, which is the superclass of all Java exceptions. 
       This method returns a string containing a detailed message explaining the cause of the exception. */
      //nicomachusInput();
    }

    int y = endRange + 1;
    int nicomachus = 0;
    int power = 0;
    for (int x = startRange; x < y; x++) 
    {
      String num = Integer.toString(x);
      /*In Java, Integer.toString(x) is a method used to convert an integer value x into its string representation.

		Here's what it means:

		Integer: This is the wrapper class for the primitive type int in Java. It provides various utility methods for 
		working with integer values.

		toString(x): This is a static method of the Integer class. It converts the integer value x to its corresponding 
		string representation. The returned string contains the decimal representation of the integer value.

		So, String num = Integer.toString(x); means that the integer value x will be converted to a string and stored in 
		the variable num.*/
      int[] arrNum = new int[num.length()];
      for (int i = 0; i < arrNum.length; i++) 
      {
        arrNum[i] = Character.getNumericValue(num.charAt(i));
        /*The line arrNum[i] = Character.getNumericValue(num.charAt(i)); in Java is used to extract individual digits 
          from a string num and store them as integers in an array arrNum.

		Here's what it does:

		num.charAt(i): This retrieves the character at the i-th position in the string num. Strings in Java are zero-indexed, 
		meaning the first character is at index 0, the second character is at index 1, and so on.

		Character.getNumericValue(): This is a static method of the Character class in Java. It returns the numeric value of 
		the character as an integer. If the character represents a digit (0-9), it returns the numeric value of that digit. 
		If the character is not a digit, it returns -1.

		arrNum[i] = ...: This assigns the numeric value of the character at position i in the string num to the i-th element 
		of the integer array arrNum. */
        
        power = (int) Math.pow(arrNum[i], 3);
        /*calculates the cube of the integer value stored in the array arrNum at index i using the Math.pow() method, and then 
         converts the result to an integer.

		Here's what it does:

		arrNum[i]: This accesses the integer value stored in the array arrNum at index i.

		Math.pow(arrNum[i], 3): This calculates the value of arrNum[i] raised to the power of 3. Math.pow() is a 
		method provided by the Math class in Java for calculating powers.

		(int) ...: This casts the result of Math.pow(arrNum[i], 3) to an integer. The Math.pow() method returns a double value, 
		so this casting is done to convert it into an integer.

		power = ...: This assigns the resulting integer value to the variable power. */
        
        nicomachus += power;
      }
      if (nicomachus == x) 
      {
        nicomachusArr.add(x); //line 22
        /*The line nicomachusArr.add(x); in Java is used to add the integer value x to an ArrayList called nicomachusArr.

		Here's what it does:

		nicomachusArr: This is an ArrayList variable. ArrayList is a class in Java that provides a resizable array implementation 
		of the List interface. ArrayList allows dynamic resizing, which means elements can be added or removed from it.

		add(x): This is a method provided by the ArrayList class. It adds the specified element x to the end of the ArrayList 
		nicomachusArr. After this operation, the size of the ArrayList increases by 1. */
      }
      nicomachus = 0;
    }
    nicomachusOutput(nicomachusArr);
  }

  // C
  public static void nicomachusOutput(ArrayList<Integer> nicomachusArr) 
  {
    int index = nicomachusArr.size();
    ArrayList<Integer> reverse = new ArrayList<>();
    int[] rev = new int[3];
    int reverseNum;
    int count = 0;
    if (index != 0) {
      for (int i = 0; i < index; i++) 
      {
        int arrNum = nicomachusArr.get(i);
        reverseNum = 0;
        for (int j = 0; j < rev.length; j++) 
        {
          rev[j] = arrNum % 10;
          arrNum /= 10;
          reverseNum = reverseNum * 10 + rev[j];
        }
        reverse.add(reverseNum);
      }
      System.out.print("Nicomachus number/s: ");
      for (int nicoOut : nicomachusArr) 
      {
        if (nicomachusArr.size() - 1 == count) 
        {
          System.out.printf("%03d", nicoOut);
        } else 
        {
          System.out.printf("%03d ", nicoOut);
        }
        count++;
      }
      count = 0;
      System.out.print("\nReversed number/s:   ");
      for (int revOut : reverse) {
        if (reverse.size() - 1 == count) 
        {
        	System.out.printf("%03d\n", revOut);
        } else 
        {
        	System.out.printf("%03d ", revOut);
        }
        count++;
      }
    } 
    else 
    {
    	System.out.println("There are no Nicomachus number/s");
    }
  }
}

