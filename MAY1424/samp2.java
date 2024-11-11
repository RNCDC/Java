package MAY1424;

import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")

public class samp2 extends JFrame{ //LABEL
	private JLabel lbl1, lbl2, lbl3;
	private Font font1 = new Font("Arial", Font.BOLD, 20); //para mapalitan ng font
	private Font font2 = new Font("Times New Roman", Font.ITALIC, 30);
	private Font font3 = new Font("Verdana", Font.ITALIC + Font.BOLD, 25);
	public samp2(String x)
	{
		super(x);
		Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		c.setLayout(new GridLayout(2,2)); //divided by 4 parts ung window
		//c.setLayout(new BorderLayout());
		c.setBackground(Color.green); //bg, can also use hexadecimal but no color keyword 4 digits ex.0000 
		lbl1 = new JLabel("Hello");
		lbl2 = new JLabel(" World!");
		lbl3 = new JLabel("How are your?");
		lbl1.setForeground(Color.blue); //to change the color of the text
		lbl1.setFont(font1); //to change the font of the text
		lbl2.setFont(font2);
		lbl3.setFont(font3);
		lbl2.setForeground(Color.red);
		lbl3.setForeground(Color.magenta);
		/*c.add(BorderLayout.NORTH, lbl1);
		c.add(BorderLayout.EAST, lbl2);
		c.add(BorderLayout.SOUTH, lbl3);*/
		c.add(lbl1); //to output the labels
		c.add(lbl2);
		c.add(lbl3);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		samp2 testlabel = new samp2("JLabel Sample");
		testlabel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
