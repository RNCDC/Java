package MAY1424;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class final_act extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField val2;
	private JTextField val1;
	private JTextField val3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final_act frame = new final_act();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public final_act() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 450, 660);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 265, 231, 220);
		textArea.setEnabled(false);
		contentPane.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 77, 169, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel crs = new JLabel("Course: ");
		panel_1.add(crs);
		
		JRadioButton bsit = new JRadioButton("BSIT");
		panel_1.add(bsit);
		
		JRadioButton bscs = new JRadioButton("BSCS");
		panel_1.add(bscs);
		
		ButtonGroup group = new ButtonGroup();
		group.add(bsit);
		group.add(bscs);
		
		bsit.setSelected(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(355, 219, 2, 2);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 231, 57);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel studNum = new JLabel("Student Number:");
		panel.add(studNum);
		
		val1 = new JTextField();
		val1.setColumns(10);
		panel.add(val1);
		
		JLabel studName = new JLabel("Student Name: ");
		panel.add(studName);
		
		val2 = new JTextField();
		panel.add(val2);
		val2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_3.setBounds(10, 155, 170, 35);
		contentPane.add(panel_3);
		
		JLabel sec = new JLabel("Section: ");
		panel_3.add(sec);
		
		val3 = new JTextField();
		val3.setColumns(10);
		panel_3.add(val3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 102, 121, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel yr = new JLabel("Year: ");
		panel_2.add(yr, BorderLayout.NORTH);
		
		JComboBox year = new JComboBox();
		panel_2.add(year, BorderLayout.SOUTH);
		year.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th"}));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(15, 205, 231, 40);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2));
		
		JButton addButton = new JButton("ADD");
		panel_4.add(addButton);
		
		JButton ext = new JButton("CLOSE");
		panel_4.add(ext);
		ext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StringBuilder studentInfo = new StringBuilder();
				String studentNumber = val1.getText();
                String studentName = val2.getText();

             // Check if student number and student name are not empty
                if (!studentNumber.isEmpty() && !studentName.isEmpty()) {
                studentInfo.append("Student Number: ").append(val1.getText()).append("\n");
                studentInfo.append("Student Name: ").append(val2.getText()).append("\n");
                
                if (bscs.isSelected()) {
                    studentInfo.append("Course: ").append(bscs.getText()).append("\n");
                } else if (bsit.isSelected()) {
                    studentInfo.append("Course: ").append(bsit.getText()).append("\n");
                } else {
                    studentInfo.append("Course: No selection").append("\n");
                }

                studentInfo.append("Year: ").append(year.getSelectedItem().toString()).append("\n");
                studentInfo.append("Section: ").append(val3.getText()).append("\n");
                
                textArea.setText(studentInfo.toString());
                } else {
                    textArea.setText("Please Fill Up All The Fields Given Above!!!"); // Clear the text area if inputs are empty
                }
			}
		});
		
		
	}
}
