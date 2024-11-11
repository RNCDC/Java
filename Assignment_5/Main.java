package Assignment_5; //BY PAIR

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Main extends JFrame {
	// private JFrame frame;
	New newInfo = new New("New Information");
	Input_Grade InputGrade = new Input_Grade("Input Grade");

	public Main(String title) throws IOException {
		super(title);

		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 564, 317);
		getContentPane().add(scrollPane);
		
		File gradesfile = new File("Grades.txt");
		gradesfile.createNewFile();

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu newMenu = new JMenu("File");
		menuBar.add(newMenu);

		JMenuItem NewInfo = new JMenuItem("New Information");
		NewInfo.setMnemonic('I'); // Set the mnemonic to 'I'
		NewInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newInfo.setVisible(true);
			}
		});
		newMenu.add(NewInfo);
		
		
		
		JMenuItem ItemInputGrade = new JMenuItem("Input Grades");
		ItemInputGrade.setMnemonic('G'); // Set the mnemonic to 'G'
		ItemInputGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File SubjectsFile = new File("Subjects.txt");
				ArrayList<String> studentInfo = new ArrayList<>(); 
				try {
					BufferedReader br = new BufferedReader(new FileReader(SubjectsFile));
					while (br.read() != -1) {
						studentInfo.add(br.readLine());
					}
					br.close();
				} catch (IOException z) {
					JOptionPane.showMessageDialog(null, z.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				InputGrade.setStudentInfo(studentInfo);
				InputGrade.setVisible(true);
			}
		});
		newMenu.add(ItemInputGrade);

		JMenuItem MenuExit = new JMenuItem("Exit");
		MenuExit.setMnemonic('x'); // Set the mnemonic to 'x'
		MenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		newMenu.add(MenuExit);

		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);

		JMenuItem MenuInfo = new JMenuItem("By Information");
		MenuInfo.setMnemonic('I'); // Set the mnemonic to 'I'
		MenuInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File gradesfile = new File("Subjects.txt");
				try {
					
					textArea.setText(null);
					BufferedReader br = new BufferedReader(new FileReader(gradesfile));
					while (br.read() != -1) {
						textArea.append(br.readLine() + "\n");
					}
					br.close();
				} 
				catch(IOException ie) {
					JOptionPane.showMessageDialog(null, "Records displayed!", "Output",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		viewMenu.add(MenuInfo);

		JMenuItem MenuCG = new JMenuItem("By Computed Grades");
		MenuCG.setMnemonic('C'); // Set the mnemonic to 'C'
		MenuCG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File gradesFile = new File("Grades.txt");
				try {
					
					textArea.setText(null);
					BufferedReader bg = new BufferedReader(new FileReader(gradesFile));
					while (bg.read() != -1) {
						textArea.append(bg.readLine() + "\n");
					}
					bg.close();
				} 
				catch(IOException ie) {
					JOptionPane.showMessageDialog(null, "Records displayed!", "Output",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		viewMenu.add(MenuCG);

		JMenuItem MenuAll = new JMenuItem("All");
		MenuAll.setMnemonic('A'); // Set the mnemonic to 'A'
		MenuAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File SubjectsFile = new File("Subjects.txt");
				File gradesFile = new File("Grades.txt");
				try {
					
					textArea.setText(null);
					BufferedReader br = new BufferedReader(new FileReader(SubjectsFile));
					BufferedReader bg = new BufferedReader(new FileReader(gradesFile));
					while (br.read() != -1) {
						textArea.append(br.readLine() + "\n");
					}
					
					while (bg.read() != -1) {
						textArea.append(bg.readLine() + "\n");
					}
					
					br.close();
					bg.close();
				} 
				catch(IOException ie) {
					JOptionPane.showMessageDialog(null, "Records displayed!", "Output",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		viewMenu.add(MenuAll);

		JMenu MenuHelp = new JMenu("Help");
		menuBar.add(MenuHelp);

		JMenuItem MenuTopics = new JMenuItem("Topics");
		MenuTopics.setMnemonic('T'); // Set the mnemonic to 'T'
		MenuTopics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(null, "Search topic: ", "Topic", JOptionPane.QUESTION_MESSAGE);
            }
        });
		MenuHelp.add(MenuTopics);

		JMenuItem MenuAbout = new JMenuItem("About");
		MenuAbout.setMnemonic('A'); // Set the mnemonic to 'A'
		MenuAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Program by: Dela Cruz & Valladores\n" +
                        "Assignment 5", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		MenuHelp.add(MenuAbout);
	}

	public static void main(String[] args) throws Exception {
		Main f = new Main("Main");
		f.setVisible(true);
	}

}

