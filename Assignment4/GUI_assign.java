package Assignment4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI_assign extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel, lblNewLabel_1;
    private JTextField numtxt, nametxt;
    private JPanel panel2;
    private JRadioButton rbper, rbtemp, rbpt;
    private JComboBox<String> departmentComboBox;
    private JCheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI_assign frame = new GUI_assign();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI_assign() {
        setTitle("Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 858, 519);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // PANEL 1
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
        
        // PANEL 3
        JPanel panel3 = new JPanel();
        panel3.setBounds(209, 182, 417, 134);
        contentPane.add(panel3);
        panel3.setLayout(new GridLayout(3, 3, 0, 0));
        
        c1 = new JCheckBox("Programming");
        panel3.add(c1);
        
        c2 = new JCheckBox("Database");
        panel3.add(c2);
        
        c3 = new JCheckBox("Discrete Structure");
        panel3.add(c3);
        
        c4 = new JCheckBox("Networking");
        panel3.add(c4);
        
        c5 = new JCheckBox("Research");
        panel3.add(c5);
        
        c6 = new JCheckBox("Thesis");
        panel3.add(c6);
        
        c7 = new JCheckBox("Capstone Project");
        panel3.add(c7);
        
        c8 = new JCheckBox("Elective");
        panel3.add(c8);
        
        c9 = new JCheckBox("Modeling and Simulation");
        panel3.add(c9);
        
        // PANEL 2
        panel2 = new JPanel();
        panel2.setBounds(10, 78, 783, 150);
        contentPane.add(panel2);
        panel2.setLayout(new GridLayout(3, 4, 0, 0));
        
        JLabel lblstat = new JLabel("  Employment Status:");
        panel2.add(lblstat);
        
        rbper = new JRadioButton("Permanent");
        rbper.setSelected(true);
        
        rbtemp = new JRadioButton("Temporary");
        
        rbpt = new JRadioButton("Part - Time");
        
        panel2.add(rbper);
        panel2.add(rbtemp);
        panel2.add(rbpt);
        
     // Group the radio buttons
        ButtonGroup employmentStatusGroup = new ButtonGroup();
        employmentStatusGroup.add(rbper);
        employmentStatusGroup.add(rbtemp);
        employmentStatusGroup.add(rbpt);
        
        panel2.add(rbper);
        panel2.add(rbtemp);
        panel2.add(rbpt);
        
        JLabel lbldep = new JLabel("  Department:");
        panel2.add(lbldep);
        
        String[] departments = {"Computer Science", "Information Science", "Information Technology"};
        departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.addActionListener(new DepartmentComboBoxListener());
        departmentComboBox.setSelectedIndex(2);
        panel2.add(departmentComboBox);

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
        
        // PANEL 4
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
        
        // PANEL 5
        JPanel panel5 = new JPanel();
        panel5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel5.setBounds(115, 358, 584, 111);
        contentPane.add(panel5);
        panel5.setLayout(new BorderLayout(0, 0));
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
        textArea.setEditable(false);
        textArea.append(String.format("Employee Number Employee Name \tStatus \t\tDepartment \t\tSubjects\n"));

        // Add JScrollPane to text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel5.add(scrollPane, BorderLayout.CENTER);
    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String facultyNumber = numtxt.getText();
            String name = nametxt.getText();
            String status = rbper.isSelected() ? "Permanent" : (rbtemp.isSelected() ? "Temporary" : "Part - Time");
            String department = (String) departmentComboBox.getSelectedItem();
            StringBuilder subjects = new StringBuilder();
            if (c1.isSelected()) subjects.append("Programming, ");
            if (c2.isSelected()) subjects.append("Database, ");
            if (c3.isSelected()) subjects.append("Discrete Structure, ");
            if (c4.isSelected()) subjects.append("Networking, ");
            if (c5.isSelected()) subjects.append("Research, ");
            if (c6.isSelected()) subjects.append("Thesis, ");
            if (c7.isSelected()) subjects.append("Capstone Project, ");
            if (c8.isSelected()) subjects.append("Elective, ");
            if (c9.isSelected()) subjects.append("Modeling and Simulation, ");
            
            if (subjects.length() > 0) subjects.setLength(subjects.length() - 2); // Remove trailing comma and space
            
            textArea.append(String.format("%s\t\t%s\t\t%s\t%s\t%s\n",
                    facultyNumber, name, status, department, subjects.toString()));
        }
    }

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clearForm();
        }
    }

    private void clearForm() {
        numtxt.setText("");
        nametxt.setText("");
        rbper.setSelected(true);
        resetCheckBoxes();
        departmentComboBox.setSelectedIndex(2); // Default to Information Technology
    }
    
    private void resetCheckBoxes() {
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
    
    private class DepartmentComboBoxListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String selectedDepartment = (String) departmentComboBox.getSelectedItem();
            resetCheckBoxes();
            switch (selectedDepartment) 
            {
                case "Computer Science":
                    c3.setEnabled(false);
                    c4.setEnabled(false);
                    c9.setEnabled(false);
                    c5.setEnabled(false);
                    c7.setEnabled(false);
                    break;
                case "Information Science":
                    c9.setEnabled(false);
                    c7.setEnabled(false);
                    c6.setEnabled(false);
                    break;
                case "Information Technology":
                    c4.setEnabled(false);
                    c5.setEnabled(false);
                    c6.setEnabled(false);
                    break;
            }
        }
    }
}
