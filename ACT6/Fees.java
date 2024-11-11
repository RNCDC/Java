package ACT6;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

public class Fees extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldTuition;
    private JTextField textFieldTotal;
    private JCheckBox chckbxLibrary;
    private JCheckBox chckbxCouncil;
    private JCheckBox chckbxPaper;
    private JCheckBox chckbxMedical;
    private JButton btnCompute;
    private JButton btnReturn;
    private JMenuSample parentFrame;

    public Fees(JMenuSample parent) {
        this.parentFrame = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTuition = new JLabel("Tuition Fee:");
        lblTuition.setBounds(30, 30, 100, 25);
        contentPane.add(lblTuition);

        textFieldTuition = new JTextField();
        textFieldTuition.setBounds(150, 30, 200, 25);
        contentPane.add(textFieldTuition);

        chckbxLibrary = new JCheckBox("Library - 50");
        chckbxLibrary.setBounds(30, 70, 150, 25);
        contentPane.add(chckbxLibrary);

        chckbxCouncil = new JCheckBox("Stud Council - 150");
        chckbxCouncil.setBounds(30, 100, 150, 25);
        contentPane.add(chckbxCouncil);

        chckbxPaper = new JCheckBox("School Paper - 75");
        chckbxPaper.setBounds(30, 130, 150, 25);
        contentPane.add(chckbxPaper);

        chckbxMedical = new JCheckBox("Medical - 200");
        chckbxMedical.setBounds(30, 160, 150, 25);
        contentPane.add(chckbxMedical);

        JLabel lblTotal = new JLabel("Total Fees:");
        lblTotal.setBounds(30, 200, 100, 25);
        contentPane.add(lblTotal);

        textFieldTotal = new JTextField();
        textFieldTotal.setBounds(150, 200, 200, 25);
        textFieldTotal.setEnabled(false);
        contentPane.add(textFieldTotal);

        btnCompute = new JButton("Compute");
        btnCompute.setBounds(70, 240, 100, 25);
        contentPane.add(btnCompute);

        btnReturn = new JButton("Return");
        btnReturn.setBounds(220, 240, 100, 25);
        contentPane.add(btnReturn);

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnCompute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to calculate total fees
                try {
                    double tuition = Double.parseDouble(textFieldTuition.getText());
                    double total = tuition;
                    if (chckbxLibrary.isSelected()) total += 50;
                    if (chckbxCouncil.isSelected()) total += 150;
                    if (chckbxPaper.isSelected()) total += 75;
                    if (chckbxMedical.isSelected()) total += 200;
                    textFieldTotal.setText(String.valueOf(total));
                    textFieldTotal.setEnabled(false);
                    parentFrame.setTotalFees(total);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Please enter a valid tuition fee", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fees frame = new Fees(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

