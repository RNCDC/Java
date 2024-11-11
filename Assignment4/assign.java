package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class assign extends JFrame {
    private JTextField facultyNumberField, nameField;
    private JRadioButton permanentButton, temporaryButton, ptButton;
    private JComboBox<String> departmentComboBox;
    private JCheckBox programmingCheckBox, databaseCheckBox, discreteCheckBox, 
                      networkingCheckBox, modellingCheckBox, electiveCheckBox, 
                      thesisCheckBox, researchCheckBox, capstoneCheckBox;
    private JTextArea outputTextArea;
    
    public assign() {
        // Panel 1: Faculty Number and Name
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(new JLabel("Faculty Number:"));
        facultyNumberField = new JTextField(10);
        panel1.add(facultyNumberField);
        panel1.add(new JLabel("Name:"));
        nameField = new JTextField(10);
        panel1.add(nameField);
        
        // Panel 2: Status, Department, Subjects Taught
        JPanel panel2 = new JPanel(new GridLayout(3, 4));
        panel2.add(new JLabel("Status:"));
        permanentButton = new JRadioButton("Permanent");
        temporaryButton = new JRadioButton("Temporary");
        ptButton = new JRadioButton("Part-Time");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(permanentButton);
        statusGroup.add(temporaryButton);
        statusGroup.add(ptButton);
        panel2.add(permanentButton);
        panel2.add(temporaryButton);
        panel2.add(ptButton);
        
        panel2.add(new JLabel("Department:"));
        String[] departments = {"Computer Science", "Information Science", "Information Technology"};
        departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.addActionListener(new DepartmentComboBoxListener());
        panel2.add(departmentComboBox);
        
        panel2.add(new JLabel("Subjects Taught:"));
        panel2.add(new JLabel("")); // Placeholder to align the layout
        
        // Panel 3: CheckBoxes for Subjects
        JPanel panel3 = new JPanel(new GridLayout(3, 3));
        programmingCheckBox = new JCheckBox("Programming");
        databaseCheckBox = new JCheckBox("Database");
        discreteCheckBox = new JCheckBox("Discrete");
        networkingCheckBox = new JCheckBox("Networking");
        modellingCheckBox = new JCheckBox("Modelling");
        electiveCheckBox = new JCheckBox("Elective");
        thesisCheckBox = new JCheckBox("Thesis");
        researchCheckBox = new JCheckBox("Research");
        capstoneCheckBox = new JCheckBox("Capstone");

        panel3.add(programmingCheckBox);
        panel3.add(databaseCheckBox);
        panel3.add(discreteCheckBox);
        panel3.add(networkingCheckBox);
        panel3.add(modellingCheckBox);
        panel3.add(electiveCheckBox);
        panel3.add(thesisCheckBox);
        panel3.add(researchCheckBox);
        panel3.add(capstoneCheckBox);
        
        // Panel 4: Buttons
        JPanel panel4 = new JPanel();
        JButton addButton = new JButton("ADD");
        JButton clearButton = new JButton("CLEAR");
        JButton exitButton = new JButton("EXIT");
        
        addButton.addActionListener(new AddButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        exitButton.addActionListener(e -> System.exit(0));
        
        panel4.add(addButton);
        panel4.add(clearButton);
        panel4.add(exitButton);
        
        // Panel 5: TextArea with ScrollBars
        JPanel panel5 = new JPanel(new BorderLayout());
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        panel5.add(scrollPane, BorderLayout.CENTER);
        
        // Add panels to the frame
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        add(panel4, BorderLayout.EAST);
        add(panel5, BorderLayout.WEST);
        
        
        // Set default state
        clearForm();
        
        // Frame settings
        setTitle("Faculty Information Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void clearForm() {
        facultyNumberField.setText("");
        nameField.setText("");
        permanentButton.setSelected(true);
        departmentComboBox.setSelectedIndex(2); // Default to Information Technology
        resetCheckBoxes();
    }
    
    private void resetCheckBoxes() {
        programmingCheckBox.setSelected(false);
        databaseCheckBox.setSelected(false);
        discreteCheckBox.setSelected(false);
        networkingCheckBox.setSelected(false);
        modellingCheckBox.setSelected(false);
        electiveCheckBox.setSelected(false);
        thesisCheckBox.setSelected(false);
        researchCheckBox.setSelected(false);
        capstoneCheckBox.setSelected(false);
        
        // Enable/disable checkboxes based on the default selection (Information Technology)
        programmingCheckBox.setEnabled(true);
        databaseCheckBox.setEnabled(true);
        discreteCheckBox.setEnabled(true);
        networkingCheckBox.setEnabled(false);
        modellingCheckBox.setEnabled(true);
        electiveCheckBox.setEnabled(true);
        thesisCheckBox.setEnabled(false);
        researchCheckBox.setEnabled(false);
        capstoneCheckBox.setEnabled(true);
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
                	discreteCheckBox.setEnabled(false);
                    networkingCheckBox.setEnabled(false);
                    modellingCheckBox.setEnabled(false);
                    researchCheckBox.setEnabled(false);
                    capstoneCheckBox.setEnabled(false);
                    thesisCheckBox.setEnabled(true);
                    break;
                case "Information Science":
                    networkingCheckBox.setEnabled(true);
                    modellingCheckBox.setEnabled(false);
                    researchCheckBox.setEnabled(true);
                    capstoneCheckBox.setEnabled(false);
                    thesisCheckBox.setEnabled(false);
                    break;
                case "Information Technology":
                    networkingCheckBox.setEnabled(false);
                    modellingCheckBox.setEnabled(true);
                    researchCheckBox.setEnabled(false);
                    capstoneCheckBox.setEnabled(true);
                    thesisCheckBox.setEnabled(false);
                    break;
            }
        }
    }
    
    private class AddButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String facultyNumber = facultyNumberField.getText();
            String name = nameField.getText();
            String status;
            if (permanentButton.isSelected()) {
                status = "Permanent";
            } else if (temporaryButton.isSelected()) {
                status = "Temporary";
            } else {
                status = "Part-time";
            }
            String department = (String) departmentComboBox.getSelectedItem();
            StringBuilder subjects = new StringBuilder();
            if (programmingCheckBox.isSelected()) subjects.append("Programming, ");
            if (databaseCheckBox.isSelected()) subjects.append("Database, ");
            if (discreteCheckBox.isSelected()) subjects.append("Discrete, ");
            if (networkingCheckBox.isSelected()) subjects.append("Networking, ");
            if (modellingCheckBox.isSelected()) subjects.append("Modelling, ");
            if (electiveCheckBox.isSelected()) subjects.append("Elective, ");
            if (thesisCheckBox.isSelected()) subjects.append("Thesis, ");
            if (researchCheckBox.isSelected()) subjects.append("Research, ");
            if (capstoneCheckBox.isSelected()) subjects.append("Capstone, ");
            
            if (subjects.length() > 0) subjects.setLength(subjects.length() - 2); // Remove trailing comma and space
            
            //outputTextArea.append(String.format("Faculty Number: \tName: \tStatus: \tDepartment: \tSubjects Taught: \t\n"));
            outputTextArea.append(String.format("%s\t %s\t %s\t %s\t %s\t\n\n",
                    facultyNumber, name, status, department, subjects.toString()));
        }
    }
    
    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clearForm();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(assign::new);
    }
}

