package MAY1424;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class samp4 extends JFrame //RADIO BUTTON
{
	private JLabel lbl1 = new JLabel("Choose your shoe brand: ");
	private JLabel lbl2 = new JLabel("You chose: ");
	private JTextField txt = new JTextField("", 10);
	private JRadioButton rbtn1 = new JRadioButton("Nike");
	private JRadioButton rbtn2 = new JRadioButton("Adidas");
	private JRadioButton rbtn3 = new JRadioButton("Fila");
	private JRadioButton rbtn4 = new JRadioButton("Converse");
	private JRadioButton rbtn5 = new JRadioButton("Puma");
	private JButton btn1 = new JButton("Click");
	private JButton btn2 = new JButton("Close");
	private String brand;
	
	public samp4(String s)
	{
		super(s);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lbl1);
		c.add(rbtn1); rbtn1.setSelected(true); //selected agad
		c.add(rbtn2); c.add(rbtn3); c.add(rbtn4); c.add(rbtn5);
		c.add(lbl2); c.add(txt); txt.setEditable(false); //para hindi maedit ung you choose
		c.add(btn1); c.add(btn2);
		rbtnEvent rbe = new rbtnEvent();
		rbtn1.addItemListener(rbe); rbtn2.addItemListener(rbe); //for radio button
		rbtn3.addItemListener(rbe); rbtn4.addItemListener(rbe);
		rbtn5.addItemListener(rbe);
		btnEvent be = new btnEvent();
		btn1.addActionListener(be); //for button
		btn2.addActionListener(be);
		setSize(300,400);
		setVisible(true);
		
	}
	
	public class btnEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == btn1)
				txt.setText(brand);
			else
				System.exit(DISPOSE_ON_CLOSE);
		}
	}
	
	public class rbtnEvent implements ItemListener
	{
		public void itemStateChanged(ItemEvent ie)
		{
			if(ie.getSource() == rbtn1)
			{	
				brand = rbtn1.getText();
				rbtn2.setSelected(false);
				rbtn3.setSelected(false);
				rbtn4.setSelected(false);
				rbtn5.setSelected(false);
			}
			
			else if(ie.getSource() == rbtn2)
			{	
				brand = rbtn2.getText();
				rbtn1.setSelected(false);
				rbtn3.setSelected(false);
				rbtn4.setSelected(false);
				rbtn5.setSelected(false);
			}
			
			else if(ie.getSource() == rbtn3)
			{	
				brand = rbtn3.getText();
				rbtn1.setSelected(false);
				rbtn2.setSelected(false);
				rbtn4.setSelected(false);
				rbtn5.setSelected(false);
			}
			else if(ie.getSource() == rbtn4)
			{	
				brand = rbtn4.getText();
				rbtn1.setSelected(false);
				rbtn2.setSelected(false);
				rbtn3.setSelected(false);
				rbtn5.setSelected(false);
			}
			else 
			{
				brand = rbtn5.getText();
				rbtn1.setSelected(false);
				rbtn2.setSelected(false);
				rbtn3.setSelected(false);
				rbtn4.setSelected(false);
			}
		}
	}
	public static void main(String[] args) {
		samp4 rb = new samp4("Sample RadioButton");
		rb.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
