package Assignment_5;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class New extends JFrame {
	private JTextField txtStudNum;
	private JTextField txtStudName;
	private String data;
	
	JCheckBox[] chBox = new JCheckBox[14];
	String[] strChBox = {"Programming", "Discrete Structure", "Database", "Data Structure", "English", "Filipino", "Political Science", "History", "Physical Education", "Elective", "Economics" 
			, "Thesis", "Accounting", "Statistics"};
	
	StringBuilder subjBuilder = new StringBuilder();

	public New(String title) {
		super(title);
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new GridLayout(0, 2));

		JLabel studnum = new JLabel("Student Number:");
		con.add(studnum);

		txtStudNum = new JTextField();
		con.add(txtStudNum);

		JLabel studname = new JLabel("Student Name:");
		con.add(studname);

		txtStudName = new JTextField();
		con.add(txtStudName);

		JLabel subs = new JLabel("Subjects Enrolled:");
		con.add(subs);
		
		JPanel consume = new JPanel();
		con.add(consume);

		for (int i = 0; i < strChBox.length; i++) {
			chBox[i] = new JCheckBox(strChBox[i]);			
			con.add(chBox[i]);
		}
		
		Button Save = new Button("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File studfile = new File("Subjects.txt");
				try {
					studfile.createNewFile();
					String strSaveSubject = "";
					String num = txtStudNum.getText();
					String name = txtStudName.getText();
					
					
					if (num.isEmpty() || name.isEmpty()) {
						throw new Exception("Fill all fields"); 
					}
					
					ArrayList<String> saveSubject = new ArrayList<>();
					for (int i = 0; i < strChBox.length; i++) {
						if (chBox[i].isSelected()) {
							saveSubject.add(chBox[i].getText());
							strSaveSubject += chBox[i].getText() + "\t";
						}
					}
					
					if (saveSubject.size() == 0) {
						throw new Exception("Check a box"); 
					}
					
					BufferedWriter bw = new BufferedWriter(new FileWriter(studfile, true));
					data = MessageFormat.format(" {0}\t{1}\t{2}\n", 
							num, name, strSaveSubject);
					System.out.println(data);
					bw.append(data);	
					
					for (int i = 0; i < strChBox.length; i++) {
						chBox[i].setSelected(false);
					}
					
					txtStudNum.setText("");
					txtStudName.setText("");
					JOptionPane.showMessageDialog(null, "Student Added!");
					bw.close();
				}
				catch (Exception z) 
				{
					JOptionPane.showMessageDialog(null, z.getMessage(),
							 "Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		con.add(Save);

		Button Back = new Button("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		con.add(Back);

	}
}
