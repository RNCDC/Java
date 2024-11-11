package test;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
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

public class testing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing frame = new testing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public testing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 634);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea(); // last part
		textArea.setBounds(10, 259, 231, 220);
		contentPane.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 77, 169, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
/*		JLabel lblCourse = new JLabel("Course: ");
		panel_1.add(lblCourse);
		
		JRadioButton bsit = new JRadioButton("BSCS");
		panel_1.add(bsit);
		
		JRadioButton bscs = new JRadioButton("BSIT");
		panel_1.add(bscs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(355, 219, 2, 2);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 231, 57);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblSubjects = new JLabel("Student Number:");
		panel.add(lblSubjects);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblStudentName = new JLabel("Student Name: ");
		panel.add(lblStudentName);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 102, 121, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblYear = new JLabel("Year: ");
		panel_2.add(lblYear, BorderLayout.NORTH);
		
		JComboBox year = new JComboBox();
		panel_2.add(year, BorderLayout.SOUTH);
		year.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th"}));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_3.setBounds(10, 155, 161, 30);
		contentPane.add(panel_3);
		
		JLabel lblSection = new JLabel("Section: ");
		panel_3.add(lblSection);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 200, 231, 49);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnNewButton = new JButton("ADD");
		panel_4.add(btnNewButton);
		
		JButton btnExit = new JButton("CLOSE");
		panel_4.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (bscs.isSelected()) {
                    textArea.setText("Course: " + bscs.getText());
                } else if (bsit.isSelected()) {
                    textArea.setText("Course: " + bsit.getText());
                } else {
                    textArea.setText("No selection");
                }
//				textArea.setText(num.getText()+name.getText());
			}
		});*/
		
		
	}
}
