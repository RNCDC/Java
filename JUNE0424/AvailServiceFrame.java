package JUNE0424;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class AvailServiceFrame extends JFrame {
    static ArrayList<AvailService> availServiceList = new ArrayList<>();

    JLabel lblServiceName = new JLabel("Service Name: ");
    JList<String> listServiceName = new JList<>();
    JScrollPane scrollPane = new JScrollPane(listServiceName);
    JButton btnAdd = new JButton("Add");
    JButton btnReturn = new JButton("Return");
    JLabel lblTotalPrice = new JLabel("Total Price: ");
    JTextField txtTotalPrice = new JTextField(10);
    JLabel lblTotalCost = new JLabel("Total Cost: ");
    JTextField txtTotalCost = new JTextField(10);

    private double totalCost = 0;

    public AvailServiceFrame(String title) {
        super(title);
        Container con = getContentPane();
        con.setLayout(null); // Using null layout to manually set bounds

        // Set bounds for labels, list, scroll pane, and text fields
        lblServiceName.setBounds(10, 10, 100, 20);
        scrollPane.setBounds(120, 10, 200, 80);

        lblTotalPrice.setBounds(10, 100, 100, 20);
        txtTotalPrice.setBounds(120, 100, 100, 20);

        lblTotalCost.setBounds(10, 130, 100, 20);
        txtTotalCost.setBounds(120, 130, 100, 20);

        // Set bounds for buttons
        btnAdd.setBounds(40, 160, 80, 30);
        btnReturn.setBounds(130, 160, 80, 30);

        // Add components to the container
        con.add(lblServiceName);
        con.add(scrollPane);
        con.add(lblTotalPrice);
        con.add(txtTotalPrice);
        con.add(lblTotalCost);
        con.add(txtTotalCost);
        con.add(btnAdd);
        con.add(btnReturn);

        // Make text fields uneditable
        txtTotalPrice.setEditable(false);
        txtTotalCost.setEditable(false);
        txtTotalPrice.setEnabled(false); // Disable the price text field

        listServiceName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!listServiceName.isSelectionEmpty()) {
                    int selectedIndex = listServiceName.getSelectedIndex();
                    if (selectedIndex != -1) {
                        double price = ServiceFrame.serviceList.get(selectedIndex).getPrice();
                        txtTotalPrice.setText(String.valueOf(price));
                    }
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int[] selectedIndices = listServiceName.getSelectedIndices();
                double selectedTotalPrice = 0;
                for (int i : selectedIndices) {
                    selectedTotalPrice += ServiceFrame.serviceList.get(i).getPrice();
                }
                availServiceList.add(new AvailService(selectedIndices, selectedTotalPrice));
                totalCost += selectedTotalPrice;
                txtTotalCost.setText(String.valueOf(totalCost));
                JOptionPane.showMessageDialog(null, "Services Added!");
            }
        });

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(350, 230);
        setVisible(false);
    }

    public void updateServiceList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Service service : ServiceFrame.serviceList) {
            listModel.addElement(service.getName());
        }
        listServiceName.setModel(listModel);
    }
}
