package JUNE0424;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class ProductFrame extends JFrame {
    static ArrayList<Product> productList = new ArrayList<>();

    JLabel lblProductName = new JLabel("Product Name: ");
    JLabel lblPrice = new JLabel("Price: ");
    
    JTextArea txtProductName = new JTextArea(1, 18);
    JTextArea txtPrice = new JTextArea(1, 18);
    
    JButton btnAdd = new JButton("Add");
    JButton btnReturn = new JButton("Return");

    public ProductFrame(String title) {
        super(title);
        Container con = getContentPane();
        con.setLayout(null); // Using null layout to manually set bounds
        
        // Set bounds for labels and text areas
        lblProductName.setBounds(10, 10, 100, 20);
        txtProductName.setBounds(120, 10, 200, 20);
        
        lblPrice.setBounds(10, 40, 100, 20);
        txtPrice.setBounds(120, 40, 200, 20);

        // Set bounds for buttons
        btnAdd.setBounds(70, 70, 80, 30);
        btnReturn.setBounds(160, 70, 80, 30);

        // Add components to the container
        con.add(lblProductName);
        con.add(txtProductName);
        con.add(lblPrice);
        con.add(txtPrice);
        con.add(btnAdd);
        con.add(btnReturn);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = txtProductName.getText();
                try {
                    double price = Double.parseDouble(txtPrice.getText());
                    productList.add(new Product(name, price));
                    txtProductName.setText("");
                    txtPrice.setText("");
                    JOptionPane.showMessageDialog(null, "Product Added!");
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
