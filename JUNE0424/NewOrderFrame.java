package JUNE0424;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
class NewOrderFrame extends JFrame {
    static ArrayList<Order> orderList = new ArrayList<>();

    JLabel lblProductName = new JLabel("Product Name: ");
    JLabel lblPrice = new JLabel("Price: ");
    JLabel lblQuantity = new JLabel("Quantity: ");
    JLabel lblTotalAmount = new JLabel("Total Amount: ");
    JComboBox<String> cbProductName = new JComboBox<>();
    JTextArea txtPrice = new JTextArea(1, 15);
    JTextArea txtQuantity = new JTextArea(1, 12);
    JTextArea txtTotalAmount = new JTextArea(1, 12);
    JButton btnNew = new JButton("New");
    JButton btnReturn = new JButton("Return");

    public NewOrderFrame(String title) {
        super(title);
        Container con = getContentPane();
        con.setLayout(null); // Using null layout to manually set bounds

        // Set bounds for labels, combo box, and text areas
        lblProductName.setBounds(10, 10, 100, 20);
        cbProductName.setBounds(120, 10, 120, 20);

        lblPrice.setBounds(10, 40, 100, 20);
        txtPrice.setBounds(120, 40, 120, 20);
        txtPrice.setEditable(false); // Make the price text area uneditable

        lblQuantity.setBounds(10, 70, 100, 20);
        txtQuantity.setBounds(120, 70, 120, 20);

        lblTotalAmount.setBounds(10, 100, 100, 20);
        txtTotalAmount.setBounds(120, 100, 120, 20);
        txtTotalAmount.setEditable(false); // Make the total amount text area uneditable

        // Set bounds for buttons
        btnNew.setBounds(40, 130, 80, 30);
        btnReturn.setBounds(130, 130, 80, 30);

        // Add components to the container
        con.add(lblProductName);
        con.add(cbProductName);
        con.add(lblPrice);
        con.add(txtPrice);
        con.add(lblQuantity);
        con.add(txtQuantity);
        con.add(lblTotalAmount);
        con.add(txtTotalAmount);
        con.add(btnNew);
        con.add(btnReturn);

        cbProductName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String selectedProduct = (String) cbProductName.getSelectedItem();
                for (Product product : ProductFrame.productList) {
                    if (product.getName().equals(selectedProduct)) {
                        txtPrice.setText(String.valueOf(product.getPrice()));
                        calculateTotalAmount();
                        break;
                    }
                }
            }
        });

        txtQuantity.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                calculateTotalAmount();
            }

            public void removeUpdate(DocumentEvent e) {
                calculateTotalAmount();
            }

            public void changedUpdate(DocumentEvent e) {
                calculateTotalAmount();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String productName = (String) cbProductName.getSelectedItem();
                try {
                    double price = Double.parseDouble(txtPrice.getText());
                    int quantity = Integer.parseInt(txtQuantity.getText());
                    double totalAmount = price * quantity;
                    txtTotalAmount.setText(String.valueOf(totalAmount));
                    orderList.add(new Order(productName, price, quantity));
                    txtPrice.setText("");
                    txtQuantity.setText("");
                    txtTotalAmount.setText("");
                    JOptionPane.showMessageDialog(null, "Order Added!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                }
            }
        });

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(280, 200);
        setVisible(false);
    }

    private void calculateTotalAmount() {
        try {
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            double totalAmount = price * quantity;
            txtTotalAmount.setText(String.valueOf(totalAmount));
        } catch (NumberFormatException e) {
            txtTotalAmount.setText("");
        }
    }

    public void updateProductList() {
        cbProductName.removeAllItems();
        for (Product product : ProductFrame.productList) {
            cbProductName.addItem(product.getName());
        }
    }
}
