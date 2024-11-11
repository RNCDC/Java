package MAY1424;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.KeyEvent;
import java.awt.event.*;
//import javax.swing.event.*;

@SuppressWarnings("serial")

public class samp3 extends JFrame { //BUTTON
	private JLabel lbl1 = new JLabel("Name: ");
	private JTextField txt = new JTextField(20);
	private JButton btn1 = new JButton("Okay");
	private JButton btn2 = new JButton("Close");
	
	public samp3(String x)
	{
		super(x);
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,2));
		c.add(lbl1); c.add(txt);
		c.add(btn1); c.add(btn2);
		btn1.setMnemonic(KeyEvent.VK_O);
		btn2.setMnemonic(KeyEvent.VK_C);
		Bhandler clicked = new Bhandler();
		btn1.addActionListener(clicked);
		btn2.addActionListener(clicked);
		setSize(300, 300);
		setVisible(true);
	}
	
	private class Bhandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == btn1)
				JOptionPane.showMessageDialog(null, "Hello " + txt.getText(), "Sample", JOptionPane.INFORMATION_MESSAGE);
			else
				System.exit(EXIT_ON_CLOSE);
		}
	}
	
	public static void main(String[] args)
	{
		samp3 button = new samp3("Sample Button");
		button.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

