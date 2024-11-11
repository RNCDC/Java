package JUNE0424;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class ServiceFrame extends JFrame {
    static ArrayList<Service> serviceList = new ArrayList<>();

    JLabel lblServiceName = new JLabel("Service Name: ");
    JLabel lblPrice = new JLabel("Price: ");
    JTextArea txtServiceName = new JTextArea(1, 16);
    JTextArea txtPrice = new JTextArea(1, 18);
    JButton btnAdd = new JButton("Add");
    JButton btnReturn = new JButton("Return");

    public ServiceFrame(String title) {
        super(title);
        Container con = getContentPane();
        con.setLayout(null); // Using null layout to manually set bounds

        // Set bounds for labels and text areas
        lblServiceName.setBounds(10, 10, 100, 20);
        txtServiceName.setBounds(120, 10, 180, 20);

        lblPrice.setBounds(10, 40, 100, 20);
        txtPrice.setBounds(120, 40, 180, 20);

        // Set bounds for buttons
        btnAdd.setBounds(70, 70, 80, 30);
        btnReturn.setBounds(160, 70, 80, 30);

        // Add components to the container
        con.add(lblServiceName);
        con.add(txtServiceName);
        con.add(lblPrice);
        con.add(txtPrice);
        con.add(btnAdd);
        con.add(btnReturn);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = txtServiceName.getText();
                try {
                    double price = Double.parseDouble(txtPrice.getText());
                    serviceList.add(new Service(name, price));
                    txtServiceName.setText("");
                    txtPrice.setText("");
                    JOptionPane.showMessageDialog(null, "Service Added!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid price.");
                }
            }
        });

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(350, 150);
        setVisible(false);
    }
}
