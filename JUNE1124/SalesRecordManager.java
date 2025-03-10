package JUNE1124; //BY PAIR

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class SalesRecordManager extends JFrame {

    JMenuBar mainMenu = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newRecordMenuItem = new JMenuItem("New Record");
    JMenuItem salesMenuItem = new JMenuItem("Sales");
    JMenuItem viewMenuItem = new JMenuItem("View");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JTextArea txtInfo = new JTextArea(30, 50);
    JScrollPane scrollPane = new JScrollPane(txtInfo);
    static File salesmanFile = new File("salesman.txt");
    static NewRecordFrame newRecordFrame = new NewRecordFrame("Add New Record");
    static SalesFrame salesFrame = new SalesFrame("Add Sales");

    public SalesRecordManager(String title) {
        super(title);
        Container container = getContentPane();
        container.setLayout(new BorderLayout(20, 15));

        txtInfo.setEditable(false);
        container.add(scrollPane, BorderLayout.CENTER);

        setJMenuBar(mainMenu);
        mainMenu.add(fileMenu);
        fileMenu.add(newRecordMenuItem);
        fileMenu.add(salesMenuItem);
        fileMenu.add(exitMenuItem);
        mainMenu.add(viewMenuItem);

        MenuActions menuActions = new MenuActions();
        newRecordMenuItem.addActionListener(menuActions);
        salesMenuItem.addActionListener(menuActions);
        viewMenuItem.addActionListener(menuActions);
        exitMenuItem.addActionListener(menuActions);

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            if (salesmanFile.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Salesman File Created!", "File", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Salesman File already exists!", "Inform", JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class MenuActions implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == newRecordMenuItem) {
                newRecordFrame.setVisible(true);
            } else if (ae.getSource() == salesMenuItem) {
                salesFrame.updateSalesmen();
                salesFrame.setVisible(true);
            } else if (ae.getSource() == viewMenuItem) {
                try {
                    displayRecords();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (ae.getSource() == exitMenuItem) {
                dispose();
                System.exit(0);
            }
        }
    }

    private void displayRecords() throws IOException {
        txtInfo.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader(salesmanFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                if (record.length == 3) {
                    txtInfo.append("Salesman Number: " + record[0] + "\n");
                    txtInfo.append("Salesman Name: " + record[1] + "\n");
                    txtInfo.append("Total Sales: " + record[2] + "\n");
                    txtInfo.append("--------------------------\n");
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Records displayed!", "Output", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new SalesRecordManager("Sales Record Manager");//TITLE
    }
}

class NewRecordFrame extends JFrame {
    JTextField txtSalesmanNumber = new JTextField(10);
    JTextField txtSalesmanName = new JTextField(20);
    JButton btnSave = new JButton("Save");
    JButton btnReturn = new JButton("Return");

    public NewRecordFrame(String title) {
        super(title);
        Container container = getContentPane();
        container.setLayout(null);

        JLabel lblSalesmanNumber = new JLabel("Salesman Number:");
        lblSalesmanNumber.setBounds(10, 10, 120, 25);
        container.add(lblSalesmanNumber);

        txtSalesmanNumber.setBounds(150, 10, 200, 25);
        container.add(txtSalesmanNumber);

        JLabel lblSalesmanName = new JLabel("Salesman Name:");
        lblSalesmanName.setBounds(10, 45, 120, 25);
        container.add(lblSalesmanName);

        txtSalesmanName.setBounds(150, 45, 200, 25);
        container.add(txtSalesmanName);

        btnSave.setBounds(60, 80, 80, 25);
        container.add(btnSave);

        btnReturn.setBounds(180, 80, 80, 25);
        container.add(btnReturn);

        btnSave.addActionListener(e -> saveRecord());
        btnReturn.addActionListener(e -> this.setVisible(false));

        setSize(400, 150);
        setLocationRelativeTo(null);
    }

    private void saveRecord() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salesman.txt", true))) {
            bw.write(txtSalesmanNumber.getText() + "," + txtSalesmanName.getText());
            bw.newLine();
            JOptionPane.showMessageDialog(this, "Record Saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtSalesmanNumber.setText("");
        txtSalesmanName.setText("");
    }
}

class SalesFrame extends JFrame {
    JComboBox<String> cbSalesmanNumber = new JComboBox<>();
    JTextField txtSalesmanName = new JTextField(20);
    JTextField txtSales = new JTextField(10);
    JTextField txtTotalSales = new JTextField(10);
    JButton btnNew = new JButton("New");
    JButton btnSave = new JButton("Save");
    JButton btnReturn = new JButton("Return");

    Map<String, Integer> salesData = new HashMap<>();

    public SalesFrame(String title) {
        super(title);
        Container container = getContentPane();
        container.setLayout(null);

        JLabel lblSalesmanNumber = new JLabel("Salesman Number:");
        lblSalesmanNumber.setBounds(10, 10, 120, 25);
        container.add(lblSalesmanNumber);

        cbSalesmanNumber.setBounds(150, 10, 200, 25);
        container.add(cbSalesmanNumber);

        JLabel lblSalesmanName = new JLabel("Salesman Name:");
        lblSalesmanName.setBounds(10, 45, 120, 25);
        container.add(lblSalesmanName);

        txtSalesmanName.setBounds(150, 45, 200, 25);
        txtSalesmanName.setEditable(false);
        container.add(txtSalesmanName);

        JLabel lblSales = new JLabel("Sales:");
        lblSales.setBounds(10, 80, 120, 25);
        container.add(lblSales);

        txtSales.setBounds(150, 80, 200, 25);
        container.add(txtSales);

        JLabel lblTotalSales = new JLabel("Total Sales:");
        lblTotalSales.setBounds(10, 115, 120, 25);
        container.add(lblTotalSales);

        txtTotalSales.setBounds(150, 115, 200, 25);
        txtTotalSales.setEditable(false);
        container.add(txtTotalSales);

        btnNew.setBounds(10, 150, 80, 25);
        container.add(btnNew);

        btnSave.setBounds(110, 150, 80, 25);
        container.add(btnSave);

        btnReturn.setBounds(210, 150, 80, 25);
        container.add(btnReturn);

        cbSalesmanNumber.addActionListener(e -> updateSalesmanName());
        btnNew.addActionListener(e -> addNewSale());
        btnSave.addActionListener(e -> saveSales());
        btnReturn.addActionListener(e -> this.setVisible(false));

        setSize(400, 250);
        setLocationRelativeTo(null);
    }

    public void updateSalesmen() {
        cbSalesmanNumber.removeAllItems();
        salesData.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("salesman.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    cbSalesmanNumber.addItem(parts[0]);
                    salesData.put(parts[0], 0);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSalesmanName() {
        String selectedNumber = (String) cbSalesmanNumber.getSelectedItem();
        if (selectedNumber != null) {
            try (BufferedReader br = new BufferedReader(new FileReader("salesman.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2 && parts[0].equals(selectedNumber)) {
                        txtSalesmanName.setText(parts[1]);
                        break;
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addNewSale() {
        try {
            int newSale = Integer.parseInt(txtSales.getText());
            String selectedNumber = (String) cbSalesmanNumber.getSelectedItem();
            if (selectedNumber != null) {
                int currentSales = salesData.getOrDefault(selectedNumber, 0);
                currentSales += newSale;
                salesData.put(selectedNumber, currentSales);
                txtTotalSales.setText(String.valueOf(currentSales));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid sales amount", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveSales() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salesman.txt", true))) {
            String selectedNumber = (String) cbSalesmanNumber.getSelectedItem();
            if (selectedNumber != null) {
                String name = txtSalesmanName.getText();
                int totalSales = salesData.getOrDefault(selectedNumber, 0);
                bw.write(selectedNumber + "," + name + "," + totalSales);
                bw.newLine();
                JOptionPane.showMessageDialog(this, "Sales Saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtSales.setText("");
        txtTotalSales.setText("");
    }
}
