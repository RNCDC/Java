package Assignment_5;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input_Grade extends JFrame {
	private JTextField txtName;
	private JTextField txtMid;
	private JTextField txtFin;
	private JTextField txtAve;
	public String data;
	public JComboBox<String> cmBox = new JComboBox();
	List list = new List();
	ArrayList<String> studentInfo;
	public String txtNum = "";

	public Input_Grade(String title) {
		super(title);
		setSize(288, 290);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container con = getContentPane();
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 251, 44);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2));

		JLabel Studnum = new JLabel("Student Number:");
		panel.add(Studnum);
		
		cmBox.addActionListener(new ActionListener() {
			String[] courses = { "Programming", "Database", "English", "Political Science", "Physical Education",
					"Economics", "Accounting", "Discrete Structures", "Data Structure", "Filipino", "History",
					"Elective", "Thesis", "Statistics" };

			public void actionPerformed(ActionEvent e) {
				String SelectStudent = (String) cmBox.getSelectedItem();
				String name = "";
				String[] selected = new String[20];
				boolean indexCourse = false;
				for (String info : studentInfo) {
					selected = info.split("\t");
					if (SelectStudent.equals(selected[0])) {
						txtNum = SelectStudent;
						break;
					}
				}
				list.removeAll();
				int i = 0;
				for (String info : selected) {
					for (String course : courses) {
						if (info.equals(course)) {
							list.add(course);
							indexCourse = true;
							System.out.println(course);
						}
					}
					if (!indexCourse && i > 0)
						name += info + " ";
					i++;
				}
				txtName.setText(name);

			}
		});

		panel.add(cmBox);

		JLabel Studname = new JLabel("Student Name:");
		panel.add(Studname);
		txtName = new JTextField();
		panel.add(txtName);
		txtName.setEditable(false);

		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 55, 251, 63);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		JLabel subs = new JLabel("Subjects Enrolled:");
		panel2.add(subs);
		list.setBounds(125, 0, 125, 63);
		panel2.add(list);

		JPanel panel3 = new JPanel();
		panel3.setBounds(10, 118, 251, 95);
		getContentPane().add(panel3);
		panel3.setLayout(new GridLayout(0, 2));

		JLabel Mid = new JLabel("Midterm Grade:");
		panel3.add(Mid);

		txtMid = new JTextField();
		panel3.add(txtMid);

		JLabel Fin = new JLabel("Final Grade");
		panel3.add(Fin);

		txtFin = new JTextField();
		panel3.add(txtFin);

		JLabel Ave = new JLabel("Average Grade:");
		panel3.add(Ave);

		txtAve = new JTextField();
		txtAve.setEditable(false);
		panel3.add(txtAve);

		Button Compute = new Button("Compute");
		Compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float mid = Float.parseFloat(txtMid.getText());
					float fin = Float.parseFloat(txtFin.getText());
					float ave = (mid + fin) / 2;
					data = MessageFormat.format("{0}", ave);
					txtAve.setText(data);
				} catch (Exception z) {
					JOptionPane.showMessageDialog(null, z.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		panel3.add(Compute);

		Button Save = new Button("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File studfile = new File("Grades.txt");
				try {
					studfile.createNewFile();
					if (txtNum.isEmpty() || txtAve.getText().isEmpty() || txtMid.getText().isEmpty()
							|| txtFin.getText().isEmpty() || list.getSelectedItem() == null)
						throw new Exception("Fill all fields");
					BufferedWriter bw = new BufferedWriter(new FileWriter(studfile, true));
					String selectList = (String) list.getSelectedItem();
					System.out.println("selected " + selectList);
					data = MessageFormat.format("{0}\t{1}\t{2}\t{3}\t{4}\t{5}\n", txtNum, txtName.getText(),
							(String) list.getSelectedItem(), txtMid.getText(), txtFin.getText(), txtAve.getText());
					bw.append(data);
					System.out.println("data " + data);
					JOptionPane.showMessageDialog(null, "Record successfully added!", "Save",
							JOptionPane.INFORMATION_MESSAGE);
					cmBox.setSelectedIndex(0);
					txtName.setText("");
					list.removeAll();
					txtMid.setText("");
					txtFin.setText("");
					txtAve.setText("");
					bw.close();
				} catch (Exception z) {
					JOptionPane.showMessageDialog(null, z.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel3.add(Save);

		Button Back = new Button("Back");
		Back.setBounds(56, 219, 163, 22);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		con.add(Back);
	}

	public void setStudentInfo(ArrayList<String> studentInfo) {
		this.studentInfo = studentInfo;
		for (String si : studentInfo) {
			String[] temp = si.split("\t");
			cmBox.addItem(temp[0]);
		}
		cmBox.setSelectedIndex(0);
		txtName.setText("");
		list.removeAll();
	}
}

