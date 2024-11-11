package MAY1424;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")

public class activity extends JFrame 
{ 
	private JLabel lbl1 = new JLabel("Student Number: ");
	private JLabel lbl2 = new JLabel("Student Name: ");
	private JTextField txt1 = new JTextField(25);
	private JTextField txt2 = new JTextField(25);
	private JPanel p1 = new JPanel();
	private JLabel lbl3 = new JLabel("  Course: ");
	private JRadioButton rbtn1 = new JRadioButton("BSIT");
	private JRadioButton rbtn2 = new JRadioButton("BSCS");
	private JPanel p2 = new JPanel();
/*	private JLabel lbl4 = new JLabel("Year: ");
	private JPanel p3 = new JPanel();
	
	private JPanel p4 = new JPanel();*/
	
	private GridLayout l1 = new GridLayout(2,2);
	private BorderLayout l2 = new BorderLayout();
	private FlowLayout l3 = new FlowLayout();
	
    public activity(String s)
    { 
    	super(s);
    	Container info = getContentPane();
		p1.setLayout(l1);
		p1.add(lbl1);	p1.add(txt1);
		p1.add(lbl2);   p1.add(txt2);
		
		p2.setLayout(l3);
		p2.add(lbl3); p2.add(rbtn1); p2.add(rbtn2);
		
		info.setLayout(new FlowLayout());
		info.add(p1);
		info.add(p2);
	/*	Container year = getContentPane();
		year.setLayout(new BorderLayout());
		year.add(lbl4);*/
    	setVisible(true); //para makita ung window\
    	setSize(500,500); // size nung window
    	
    }
    //@SuppressWarnings("deprecation")
	public static void main(String args[])
    {  activity act = new activity("My Frame"); //pinaka title ng window
       //test.show();
       act.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
