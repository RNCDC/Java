package MAY1424;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class samp5 extends JFrame //CHECK BOX
{
	private JLabel lbl1 = new JLabel("Choose your favorite ice cream flavor/s: ");
	private JLabel lbl2 = new JLabel("Your favorite is/are: ");
	private JTextArea txtArea = new JTextArea(10,15);
	private JButton btn1 = new JButton("Click");
	private JButton btn2 = new JButton("Close");
	private JCheckBox chk1 = new JCheckBox("Cookies and Cream");
	private JCheckBox chk2 = new JCheckBox("Rocky Road");
	private JCheckBox chk3 = new JCheckBox("Chocolate");
	private JCheckBox chk4 = new JCheckBox("Mango");
	private JCheckBox chk5 = new JCheckBox("Coffee Truffle");
	private GridLayout layout1 = new GridLayout(3,2);
	private BorderLayout layout2 = new BorderLayout();
	private FlowLayout layout3 = new FlowLayout();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private String flavor, msg1, msg2, msg3, msg4, msg5;
	
	public samp5(String s)
	{
		super(s);
		Container con =  getContentPane();
		panel1.setLayout(layout2);
		panel1.add(lbl1);
		
		panel2.setLayout(layout1);
		panel2.add(chk1); panel2.add(chk2); 
		panel2.add(chk3); panel2.add(chk4); 
		panel2.add(chk5);
		
		panel3.setLayout(layout3);
		panel3.add(lbl2); panel3.add(txtArea); 
		txtArea.setEnabled(false);
		
		panel4.setLayout(new GridLayout(1,1));
		panel4.add(btn1); panel4.add(btn2);
		
		con.setLayout(new FlowLayout());
		con.add(panel1);
		con.add(panel2); con.add(panel3);
		con.add(panel4);
		ButtonHandler btnclick = new ButtonHandler();
		btn1.addActionListener(btnclick);
		btn2.addActionListener(btnclick);
		CheckHandler choose = new CheckHandler();
		chk1.addItemListener(choose);
		chk2.addItemListener(choose);
		chk3.addItemListener(choose);
		chk4.addItemListener(choose);
		chk5.addItemListener(choose);
		setSize(700,300);
		setVisible(true);
	}
	
	public class ButtonHandler implements ActionListener
	{   @Override
		public void actionPerformed(ActionEvent ae) 
		{
			flavor = msg1 + msg2 + msg3 + msg4 + msg5;
			txtArea.setText(null);
			if(ae.getSource() == btn1)
				txtArea.setText(flavor);
			else
				System.exit(DISPOSE_ON_CLOSE);
		}
	}
	
	public class CheckHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent ie)
		{
			if(chk1.isSelected())
				msg1 = chk1.getText() + "\n";
			else msg1 = "";
			if(chk2.isSelected())
				msg2 = chk2.getText() + "\n";
			else msg2 = "";
			if(chk3.isSelected())
				msg3 = chk3.getText() + "\n";
			else msg3 = "";
			if(chk4.isSelected())
				msg4 = chk4.getText() + "\n";
			else msg4 = "";
			if(chk5.isSelected())
				msg5= chk5.getText() + "\n";
			else msg5 = "";
		}
	}
	
	public static void main(String args[])
	{
		samp5 check = new samp5("Sample Checkbox");
		check.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

