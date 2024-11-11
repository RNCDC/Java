package ACT6; //BY PAIR, NOT OURS?

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class JMenuSample extends JFrame {

    JMenuBar main = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newFrame = new JMenuItem("New");
    JMenuItem showInfo = new JMenuItem("Show");
    JMenuItem exit = new JMenuItem("Exit");
    static Frame2 frame2 = new Frame2("New Frame");
    JTextArea txtInfo = new JTextArea(30, 20);
    private final JMenu mnNewMenu = new JMenu("Grades");
    private final JMenu mnNewMenu_1 = new JMenu("Fees");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem index = new JMenuItem("Topics");
    JMenuItem about = new JMenuItem("About");
    JMenuItem openGrades = new JMenuItem("Open Grades");
    JMenuItem openFees = new JMenuItem("Open Fees");

    private double averageGrade = 0.0;
    private double totalFees = 0.0;

    public JMenuSample(String str) {
        super(str);
        Container con = getContentPane();
        con.setLayout(new BorderLayout(20, 15));
        con.add(new JScrollPane(txtInfo), BorderLayout.CENTER);
        con.add(new JLabel(""), BorderLayout.NORTH);
        con.add(new JLabel(""), BorderLayout.SOUTH);
        con.add(new JLabel(""), BorderLayout.EAST);
        con.add(new JLabel(""), BorderLayout.WEST);
        txtInfo.setEnabled(false);

        setJMenuBar(main);
        main.add(fileMenu);
        fileMenu.add(newFrame);
        fileMenu.add(showInfo);
        fileMenu.add(exit);

        main.add(mnNewMenu);
        mnNewMenu.add(openGrades);

        main.add(mnNewMenu_1);
        mnNewMenu_1.add(openFees);

        main.add(helpMenu);
        helpMenu.add(index);
        helpMenu.add(about);

        menuActions menuActs = new menuActions();
        newFrame.addActionListener(menuActs);
        showInfo.addActionListener(menuActs);
        exit.addActionListener(menuActs);
        index.addActionListener(menuActs);
        about.addActionListener(menuActs);
        openGrades.addActionListener(menuActs);
        openFees.addActionListener(menuActs);
        setSize(900, 500);
        setVisible(true);
    }

    public class menuActions implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == newFrame) {
                if (!frame2.isVisible()) {
                    frame2 = new Frame2("New Frame");
                }
            } else if (ae.getSource() == showInfo) {
                if (frame2.isVisible()) {
                    String studInfo = Frame2.getInfo();
                    
                    // Remove course, section, and year from the info
                    String[] lines = studInfo.split("\n");
                    StringBuilder filteredInfo = new StringBuilder();
                    boolean headerPrinted = false;
                    for (String line : lines) {
                        if (line.contains("Student No:") || line.contains("Student Name:") ||
                                line.contains("Average Grade:") || line.contains("Total Fees:")) {
                            // Extracting required information and constructing header
                            if (!headerPrinted) {
                                filteredInfo.append("Student No.\tStudent Name:\tAverage\tTotal Fees\n");
                                headerPrinted = true;
                            }
                            // Appending student information
                            filteredInfo.append(line.replaceAll("[A-Za-z]+:", "").trim()).append("\t");
                        }
                    }
                    txtInfo.setText(filteredInfo.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Frame2 is not visible!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (ae.getSource() == exit) {
                dispose();
                System.exit(0);
            } else if (ae.getSource() == index) {
                JOptionPane.showInputDialog(null, "Search topic: ", "Topic",
                        JOptionPane.QUESTION_MESSAGE);
            } else if (ae.getSource() == about) {
                JOptionPane.showMessageDialog(null, "Program by: ME\n"
                        + "This is a sample Menu Program", "About",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (ae.getSource() == openGrades) {
                Grades gradesFrame = new Grades(JMenuSample.this);
                gradesFrame.setVisible(true);
            } else if (ae.getSource() == openFees) {
                Fees feesFrame = new Fees(JMenuSample.this);
                feesFrame.setVisible(true);
            }
        }
    }

    public void setAverageGrade(double average) {
        this.averageGrade = average;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public static void main(String[] args) {
        JMenuSample menu = new JMenuSample("Sample Menu");
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setVisible(false);
        menu.setVisible(true);
    }
}
