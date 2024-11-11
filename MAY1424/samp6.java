package MAY1424;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class samp6  extends JFrame //COMBO BOX
	{
		JLabel lbl1 = new JLabel("Choose your destination: ");
		String[] destination = {"Boracay", "Palawan", "Bohol", 
				"Batanes", "Ilocos", "Baguio", "Cebu", "Davao"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cmb = new JComboBox(destination);
		JButton btnCls = new JButton("Close");
		JTextField txt = new JTextField("", 30);
		public samp6(String str)
		{
			super(str);
			Container c = getContentPane();
			c.setLayout(new GridLayout(2,2)); 
			cmb.setBounds(50, 100, 90, 25);
			c.add(lbl1); c.add(cmb);
			c.add(txt); c.add(btnCls); txt.setEnabled(false);
			btnAction btnClose = new btnAction();
			cmbAction combox = new cmbAction();
			btnCls.addActionListener(btnClose);
			cmb.addItemListener(combox);
			setSize(300,500);
			setVisible(true);
		}
		
		public class btnAction implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource() == btnCls)
					System.exit(DISPOSE_ON_CLOSE);;
			}			
		}
		
		public class cmbAction implements ItemListener
		{
			public void itemStateChanged(ItemEvent ie)
			{
				if(cmb.getSelectedIndex() == 0)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 1)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 2)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 3)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 4)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 5)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 6)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
				else if(cmb.getSelectedIndex() == 7)
					txt.setText((String) cmb.getItemAt(cmb.getSelectedIndex()));
			}
		}
		public static void main(String[] args) 
		{
			samp6 combo = new samp6("Sample Combo Box");
			combo.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		}

}
