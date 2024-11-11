package Assignment;

import java.io.IOException;

public class Number4 extends Number1
{  // inherited the Method	
	public static void main(String[] args) throws IOException
	{ 
		System.out.print("Enter the Salesman Name: ");
		sname = scan.nextLine();
		System.out.print("Enter the Quarterly Sales: ");
		for (int i = 0; i < 4; i++)
		{
			qsales[i] = Double.parseDouble(br.readLine());
		}
		totsales = returnts(qsales);
		comm = commission(totsales);
		outDisplay();
	}
}
