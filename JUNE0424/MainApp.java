package JUNE0424; //BY PAIR

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MainApp extends JFrame {

    JMenuBar main = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu transactionMenu = new JMenu("Transaction");
    JMenu reportMenu = new JMenu("Reports");

    JMenuItem productFrame = new JMenuItem("Products");
    JMenuItem serviceFrame = new JMenuItem("Services");
    JMenuItem newOrderFrame = new JMenuItem("New Order");
    JMenuItem availServiceFrame = new JMenuItem("Avail Service");
    JMenuItem viewTotalFrame = new JMenuItem("View Total");
    JMenuItem viewReports = new JMenuItem("View Reports");
    JMenuItem exit = new JMenuItem("Exit");

    static ProductFrame pFrame = new ProductFrame("Product Frame");
    static ServiceFrame sFrame = new ServiceFrame("Service Frame");
    static NewOrderFrame nOrderFrame = new NewOrderFrame("New Order Frame");
    static AvailServiceFrame aServiceFrame = new AvailServiceFrame("Avail Service Frame");
    static ViewTotalFrame vTotalFrame = new ViewTotalFrame("View Total Frame");

    JTextArea txtInfo = new JTextArea(30, 20);

    public MainApp(String str) {
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
        fileMenu.add(productFrame);
        fileMenu.add(serviceFrame);
        fileMenu.add(exit);

        main.add(transactionMenu);
        transactionMenu.add(newOrderFrame);
        transactionMenu.add(availServiceFrame);
        transactionMenu.add(viewTotalFrame);

        main.add(reportMenu);
        reportMenu.add(viewReports);

        MenuActions menuActs = new MenuActions();
        productFrame.addActionListener(menuActs);
        serviceFrame.addActionListener(menuActs);
        newOrderFrame.addActionListener(menuActs);
        availServiceFrame.addActionListener(menuActs);
        viewTotalFrame.addActionListener(menuActs);
        viewReports.addActionListener(menuActs);
        exit.addActionListener(menuActs);
        setSize(900, 600);
        setVisible(true);
    }

    public class MenuActions implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == productFrame) {
                pFrame.setVisible(true);
            } else if (ae.getSource() == serviceFrame) {
                sFrame.setVisible(true);
            } else if (ae.getSource() == newOrderFrame) {
                nOrderFrame.updateProductList();
                nOrderFrame.setVisible(true);
            } else if (ae.getSource() == availServiceFrame) {
                aServiceFrame.updateServiceList();
                aServiceFrame.setVisible(true);
            } else if (ae.getSource() == viewTotalFrame) {
                vTotalFrame.setVisible(true);
            } else if (ae.getSource() == viewReports) {
                displayReports();
            } else if (ae.getSource() == exit) {
                dispose();
                System.exit(0);
            }
        }
    }

    private void displayReports() {
        StringBuilder sb = new StringBuilder("Reports:\n\n");
        sb.append("Total Orders    \t\tTotal Services\n");
        double totalOrderPrice = 0;
        for (Order order : NewOrderFrame.orderList) 
        {
            totalOrderPrice += order.getTotalPrice();
        }
        sb.append("Total Amount: ").append(totalOrderPrice);

        double totalServicePrice = 0;
        for (AvailService availService : AvailServiceFrame.availServiceList) {
            for (int i : availService.getServiceIndices()) {
                totalServicePrice += ServiceFrame.serviceList.get(i).getPrice();
            }
        }
        sb.append("\tTotal Amount: ").append(totalServicePrice);
        
        double grandTotal = totalOrderPrice + totalServicePrice;
        sb.append("\n\nGrand Total: ").append(grandTotal);

        txtInfo.setText(sb.toString());
    }


    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        MainApp menu = new MainApp("BY PAIR");
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pFrame.setVisible(false);
        sFrame.setVisible(false);
        nOrderFrame.setVisible(false);
        aServiceFrame.setVisible(false);
        vTotalFrame.setVisible(false);
        menu.show();
    }
}


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private String productName;
    private double price;
    private int quantity;

    public Order(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class AvailService {
    private int[] serviceIndices;
    private double totalPrice;

    public AvailService(int[] serviceIndices, double totalPrice) {
        this.serviceIndices = serviceIndices;
        this.totalPrice = totalPrice;
    }

    public int[] getServiceIndices() {
        return serviceIndices;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}