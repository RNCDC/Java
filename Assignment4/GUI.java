package Assignment4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;


public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1;
	private JTextField numtxt, nametxt;
	private JPanel panel2;
	private JRadioButton rbper, rbtemp, rbpt;
	private JComboBox<String> comboBox;
	private JCheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public GUI() {
		setTitle("Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PANEL 1
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 427, 73);
		contentPane.add(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		lblNewLabel = new JLabel("Faculty Number: ");
		panel1.add(lblNewLabel);
		
		numtxt = new JTextField();
		panel1.add(numtxt);
		numtxt.setColumns(20);
		
		lblNewLabel_1 = new JLabel("Faculty Name:     ");
		panel1.add(lblNewLabel_1);
		
		nametxt = new JTextField();
		panel1.add(nametxt);
		nametxt.setColumns(20);
		
		//PANEL 3
		JPanel panel3 = new JPanel();
		panel3.setBounds(209, 182, 417, 134);
		contentPane.add(panel3);
		panel3.setLayout(new GridLayout(3, 3, 0, 0));
		
		JCheckBox c1 = new JCheckBox("Proggramming");
		panel3.add(c1);
		
		JCheckBox c2 = new JCheckBox("Database");
		panel3.add(c2);
		
		JCheckBox c3 = new JCheckBox("Discrete Structure");
		panel3.add(c3);
		
		JCheckBox c4 = new JCheckBox("Networking");
		panel3.add(c4);
		
		JCheckBox c5 = new JCheckBox("Research");
		panel3.add(c5);
		
		JCheckBox c6 = new JCheckBox("Thesis");
		panel3.add(c6);
		
		JCheckBox c7 = new JCheckBox("Capstone Project");
		panel3.add(c7);
		
		JCheckBox c8 = new JCheckBox("Elective");
		panel3.add(c8);
		
		JCheckBox c9 = new JCheckBox("Modeling and Simulation");
		panel3.add(c9);
		
		//PANEL 2
		panel2 = new JPanel();
		panel2.setBounds(10, 78, 783, 150);
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(3, 4, 0, 0));
		
		JLabel lblstat = new JLabel("  Employment Status:");
		panel2.add(lblstat);
		
		JRadioButton rbper = new JRadioButton("Permanent");
		rbper.setSelected(true);
		
		JRadioButton rbtemp = new JRadioButton("Temporary");
		
		JRadioButton rbpt = new JRadioButton("Part - Time");
		
		panel2.add(rbper);
		panel2.add(rbtemp);
		panel2.add(rbpt);
		
		JLabel lbldep = new JLabel("  Department:");
		panel2.add(lbldep);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Computer Science", "Information Science", "Information Technology"}));
		comboBox.setSelectedIndex(2);		
		panel2.add(comboBox);
		
		JLabel label = new JLabel("");
		panel2.add(label);
		
		JLabel label_1 = new JLabel("");
		panel2.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Subjects Taught:");
		panel2.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("");
		panel2.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panel2.add(label_3);
		
		//PANEL 4
		JPanel panel4 = new JPanel();
		panel4.setBounds(116, 312, 583, 48);
		contentPane.add(panel4);
		panel4.setLayout(null);

		JButton btn1 = new JButton("ADD");
		btn1.setMnemonic('A');
		btn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn1.addActionListener(new AddButtonListener());		
		btn1.setBounds(58, 11, 135, 29);
		panel4.add(btn1);
		
		JButton btn2 = new JButton("CLEAR");
		btn2.setMnemonic('C');
		btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn2.addActionListener(new ClearButtonListener());
		btn2.setBounds(230, 11, 135, 29);
		panel4.add(btn2);
		
		JButton btn3 = new JButton("EXIT");
		btn3.setMnemonic('E');
		btn3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn3.addActionListener(e -> System.exit(0));
		btn3.setBounds(400, 11, 135, 29);
		panel4.add(btn3);
		
		//PANEL 5
		JPanel panel5 = new JPanel();
		panel5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel5.setBounds(115, 358, 584, 111);
		contentPane.add(panel5);
		panel5.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setEditable(false);
		panel5.add(textArea, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		panel5.add(scrollBar, BorderLayout.SOUTH);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		panel5.add(scrollBar_1, BorderLayout.EAST);
	}
	
	private class AddButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String facultyNumber = numtxt.getText();
            String name = nametxt.getText();
            String status = rbper.isSelected() ? "Permanent" : "Temporary";
            String department = (String) comboBox.getSelectedItem();
            StringBuilder subjects = new StringBuilder();
            if (c1.isSelected()) subjects.append("Programming, ");
            if (c2.isSelected()) subjects.append("Database, ");
            if (c3.isSelected()) subjects.append("Discrete, ");
            if (c4.isSelected()) subjects.append("Networking, ");
            if (c5.isSelected()) subjects.append("Modelling, ");
            if (c6.isSelected()) subjects.append("Elective, ");
            if (c7.isSelected()) subjects.append("Thesis, ");
            if (c8.isSelected()) subjects.append("Research, ");
            if (c9.isSelected()) subjects.append("Capstone, ");
            
            if (subjects.length() > 0) subjects.setLength(subjects.length() - 2); // Remove trailing comma and space
            
            textArea.append(String.format("Faculty Number: %s\nName: %s\nStatus: %s\nDepartment: %s\nSubjects Taught: %s\n\n",
                    facultyNumber, name, status, department, subjects.toString()));
        }
    }
    
    private class ClearButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            clearForm();
        }
    }
	
	private void clearForm() 
	{
        numtxt.setText("");
        nametxt.setText("");
        rbper.setSelected(true);
        comboBox.setSelectedIndex(2); // Default to Information Technology
        
        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
        c5.setSelected(false);
        c6.setSelected(false);
        c7.setSelected(false);
        c8.setSelected(false);
        c9.setSelected(false);
        
        // Enable/disable checkboxes based on the default selection (Information Technology)
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        c5.setEnabled(true);
        c6.setEnabled(true);
        c7.setEnabled(true);
        c8.setEnabled(true);
        c9.setEnabled(true);
    }
}
