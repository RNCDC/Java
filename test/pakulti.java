package test;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pakulti extends JFrame {
    public JTextField facultyNoField, nameField;
    public JRadioButton permaButton, tempoButton, pTimeButton;
    public JComboBox<String> departmentComboBox;
    public JCheckBox progCheckBox, databaseCheckBox, discreteCheckBox,
    networkingCheckBox, modellingCheckBox, electiveCheckBox, 
    thesisCheckBox, researchCheckBox, capstoneCheckBox;
    public JTextArea textArea;

    public pakulti() {
        setTitle("Faculty Information");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Faculty Number
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Faculty Number:"), gbc);
        gbc.gridx = 1;
        facultyNoField = new JTextField(20);
        inputPanel.add(facultyNoField, gbc);

        // Faculty Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Faculty Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(20);
        inputPanel.add(nameField, gbc);

        // Employment Status
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Employment Status:"), gbc);
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        permaButton = new JRadioButton("Permanent", true);
        tempoButton = new JRadioButton("Temporary");
        pTimeButton = new JRadioButton("Part-Time");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(permaButton);
        statusGroup.add(tempoButton);
        statusGroup.add(pTimeButton);
        statusPanel.add(permaButton);
        statusPanel.add(tempoButton);
        statusPanel.add(pTimeButton);
        gbc.gridx = 1;
        inputPanel.add(statusPanel, gbc);

        // Department
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Department:"), gbc);
        gbc.gridx = 1;
        departmentComboBox = new JComboBox<>(new String[]{"Computer Science", 
        		"Information Science",
        		"Information Technology"});
        departmentComboBox.addActionListener(new DepartmentComboBoxActionListener());
        inputPanel.add(departmentComboBox, gbc);

        // Subjects 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTH;
        inputPanel.add(new JLabel("Subjects:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JPanel subjectsPanel = new JPanel(new GridLayout(3, 3));
        progCheckBox = new JCheckBox("Programming");
        databaseCheckBox = new JCheckBox("Database");
        discreteCheckBox = new JCheckBox("Discrete Structure");
        networkingCheckBox = new JCheckBox("Networking");
        modellingCheckBox = new JCheckBox("Modelling and Simulation");
        electiveCheckBox = new JCheckBox("Elective");
        thesisCheckBox = new JCheckBox("Thesis");
        researchCheckBox = new JCheckBox("Research");
        capstoneCheckBox = new JCheckBox("Capstone Project");
        subjectsPanel.add(progCheckBox);
        subjectsPanel.add(databaseCheckBox);
        subjectsPanel.add(discreteCheckBox);
        subjectsPanel.add(networkingCheckBox);
        subjectsPanel.add(modellingCheckBox);
        subjectsPanel.add(electiveCheckBox);
        subjectsPanel.add(thesisCheckBox);
        subjectsPanel.add(researchCheckBox);
        subjectsPanel.add(capstoneCheckBox);
        inputPanel.add(subjectsPanel, gbc);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("ADD");
        addButton.setBackground(Color.BLUE);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new AddButtonActionListener());
        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(new ClearButtonActionListener());
        JButton exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0));
        buttonsPanel.add(addButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(exitButton);
        add(buttonsPanel, BorderLayout.CENTER);

     // Text Area Panel with ScrollBars
        JPanel textAreaPanel = new JPanel(new BorderLayout());
        textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textAreaPanel.add(scrollPane, BorderLayout.CENTER);
        textAreaPanel.setBorder(BorderFactory.createTitledBorder("Faculty Details"));
        add(textAreaPanel, BorderLayout.SOUTH);        
        // Initialize CheckBox states based on initial selection
        updateCheckBoxes();
    }

    private void updateCheckBoxes() {
        String department = (String) departmentComboBox.getSelectedItem();
        progCheckBox.setEnabled(false);
        databaseCheckBox.setEnabled(false);
        discreteCheckBox.setEnabled(false);
        networkingCheckBox.setEnabled(false);
        modellingCheckBox.setEnabled(false);
        electiveCheckBox.setEnabled(false);
        thesisCheckBox.setEnabled(false);
        researchCheckBox.setEnabled(false);
        capstoneCheckBox.setEnabled(false);

        if (department != null) {
            switch (department) {
                case "Computer Science":
                	progCheckBox.setEnabled(true);
                    databaseCheckBox.setEnabled(true);
                    electiveCheckBox.setEnabled(true);
                    thesisCheckBox.setEnabled(true);
                    break;
                case "Information Science":
                	progCheckBox.setEnabled(true);
                    databaseCheckBox.setEnabled(true);
                    discreteCheckBox.setEnabled(true);
                    networkingCheckBox.setEnabled(true);
                    electiveCheckBox.setEnabled(true);
                    researchCheckBox.setEnabled(true);
                    break;
                case "Information Technology":
                	progCheckBox.setEnabled(true);
                    databaseCheckBox.setEnabled(true);
                    discreteCheckBox.setEnabled(true);
                    modellingCheckBox.setEnabled(true);
                    electiveCheckBox.setEnabled(true);
                    capstoneCheckBox.setEnabled(true);
                    break;
            }
        }
    }

    private class DepartmentComboBoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateCheckBoxes();
        }
    }

    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String facultyNumber = facultyNoField.getText();
            String name = nameField.getText();
            String status = permaButton.isSelected() ? "Permanent" : tempoButton.isSelected() ? "Temporary" : "Part-Time";
            String department = (String) departmentComboBox.getSelectedItem();
            StringBuilder subjects = new StringBuilder();

            if (progCheckBox.isSelected()) subjects.append("Programming, ");
            if (databaseCheckBox.isSelected()) subjects.append("Database, ");
            if (discreteCheckBox.isSelected()) subjects.append("Discrete Structure, ");
            if (networkingCheckBox.isSelected()) subjects.append("Networking, ");
            if (modellingCheckBox.isSelected()) subjects.append("Modelling and Simulation, ");
            if (electiveCheckBox.isSelected()) subjects.append("Elective, ");
            if (thesisCheckBox.isSelected()) subjects.append("Thesis, ");
            if (researchCheckBox.isSelected()) subjects.append("Research, ");
            if (capstoneCheckBox.isSelected()) subjects.append("Capstone Project, ");

            if (subjects.length() > 0) subjects.setLength(subjects.length() - 2); // Remove trailing comma and space

            textArea.append("Faculty Number: " + facultyNumber + "\t");
            textArea.append("Name: " + name + "\t");
            textArea.append("Status: " + status + "\t");
            textArea.append("Department: " + department + "\t");
            textArea.append("Subjects: " + subjects + "\t\t");
         
            
           //porda next input
            textArea.append("\n");
        }
    }
//porda clear
    private class ClearButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            facultyNoField.setText("");
            nameField.setText("");
            permaButton.setSelected(true);
            tempoButton.setSelected(false);
            pTimeButton.setSelected(false);
            departmentComboBox.setSelectedItem("Information Technology");
            progCheckBox.setSelected(false);
            databaseCheckBox.setSelected(false);
            discreteCheckBox.setSelected(false);
            networkingCheckBox.setSelected(false);
            modellingCheckBox.setSelected(false);
            electiveCheckBox.setSelected(false);
            thesisCheckBox.setSelected(false);
            researchCheckBox.setSelected(false);
            capstoneCheckBox.setSelected(false);
            textArea.setText("");
            updateCheckBoxes();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            pakulti frame = new pakulti();
            frame.setVisible(true);
        });
    }
}
