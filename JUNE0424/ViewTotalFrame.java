package JUNE0424; //done

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
class ViewTotalFrame extends JFrame {
    JTextArea txtTotal = new JTextArea(10, 20);
    JButton btnOrders = new JButton("Orders"); // Changed from btnProducts to btnOrders
    JButton btnServices = new JButton("Services");
    JButton btnAll = new JButton("All");
    JButton btnReturn = new JButton("Return");

    public ViewTotalFrame(String title) {
        super(title);
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        con.add(new JScrollPane(txtTotal), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(btnOrders); // Changed from btnProducts to btnOrders
        buttonPanel.add(btnServices);
        buttonPanel.add(btnAll);
        buttonPanel.add(btnReturn);
        con.add(buttonPanel, BorderLayout.SOUTH);

        btnOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                double total = 0;
                StringBuilder sb = new StringBuilder("Orders:\n"); // Changed from "Products" to "Orders"
                for (Order order : NewOrderFrame.orderList) {
                    sb.append(order.getProductName())
                      .append(" - ")
                      .append(order.getPrice())
                      .append(" x ")
                      .append(order.getQuantity())
                      .append(" = ")
                      .append(order.getTotalPrice())
                      .append("\n");
                    total += order.getTotalPrice();
                }
                sb.append("\nTotal: ").append(total);
                txtTotal.setText(sb.toString());
            }
        });

        btnServices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                double total = 0;
                StringBuilder sb = new StringBuilder("Services:\n");
                for (AvailService availService : AvailServiceFrame.availServiceList) {
                    for (int i : availService.getServiceIndices()) {
                        sb.append(ServiceFrame.serviceList.get(i).getName())
                          .append(" - ")
                          .append(ServiceFrame.serviceList.get(i).getPrice())
                          .append("\n");
                    }
                    total += availService.getTotalPrice();
                }
                sb.append("\nTotal: ").append(total);
                txtTotal.setText(sb.toString());
            }
        });

        btnAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                double total = 0;
                StringBuilder sb = new StringBuilder("All Orders:\n");
                for (Order order : NewOrderFrame.orderList) {
                    sb.append(order.getProductName())
                      .append(" - ")
                      .append(order.getPrice())
                      .append(" x ")
                      .append(order.getQuantity())
                      .append(" = ")
                      .append(order.getTotalPrice())
                      .append("\n");
                    total += order.getTotalPrice();
                }
                sb.append("\nAll Services:\n");
                for (AvailService availService : AvailServiceFrame.availServiceList) {
                    for (int i : availService.getServiceIndices()) {
                        sb.append(ServiceFrame.serviceList.get(i).getName())
                          .append(" - ")
                          .append(ServiceFrame.serviceList.get(i).getPrice())
                          .append("\n");
                    }
                    total += availService.getTotalPrice();
                }
                sb.append("\nGrand Total: ").append(total);
                txtTotal.setText(sb.toString());
            }
        });

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(400, 300);
        setVisible(false);
    }
}
