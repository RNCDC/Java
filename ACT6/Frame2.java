package ACT6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;

@SuppressWarnings("serial")
public class Frame2 extends JFrame {
    static String sno, sna, crs, info;
    static int yr, sec;
    JButton btnReturn = new JButton("Return");
    JButton btnSave = new JButton("Save");
    JLabel lblNum = new JLabel("Student Number: ");
    JLabel lblName = new JLabel("Student Name: ");
    JLabel lblCrs = new JLabel("Course: ");
    JLabel lblYr = new JLabel("Year: ");
    JLabel lblSec = new JLabel("Section: ");
    static JTextField txtNum = new JTextField("", 10);
    static JTextField txtName = new JTextField("", 30);
    static JTextField txtCrs = new JTextField("", 10);
    static JTextField txtYr = new JTextField("", 10);
    static JTextField txtSec = new JTextField("", 10);

    public Frame2(String st) {
        super(st);
        Container con = getContentPane();
        con.setLayout(new GridLayout(6, 2));
        con.add(lblNum);
        con.add(txtNum);
        con.add(lblName);
        con.add(txtName);
        con.add(lblCrs);
        con.add(txtCrs);
        con.add(lblYr);
        con.add(txtYr);
        con.add(lblSec);
        con.add(txtSec);
        con.add(btnSave);
        con.add(btnReturn);
        btnReturnAction btnRtn = new btnReturnAction();
        btnSave.addActionListener(btnRtn);
        btnReturn.addActionListener(btnRtn);
        setSize(700, 350);
        setVisible(true);
    }

    public class btnReturnAction implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnReturn) {
                dispose();
            } else {
                try {
                    info = information();
                    JOptionPane.showMessageDialog(null, info + "\nRecord Saved!",
                            "Save", JOptionPane.INFORMATION_MESSAGE);
                    txtNum.setText("");
                    txtName.setText("");
                    txtCrs.setText("");
                    txtYr.setText("");
                    txtSec.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for Year or Section.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public String information() {
            String data;
            sno = txtNum.getText();
            sna = txtName.getText();
            crs = txtCrs.getText();
            yr = Integer.parseInt(txtYr.getText());
            sec = Integer.parseInt(txtSec.getText());
            cls_Student stud1 = new cls_Student(sno, sna);
            cls_Student stud2 = new cls_Student(crs, yr, sec);
            data = MessageFormat.format("{0}\t{1}\t{2}\t{3}\t{4}\n",
                    stud1.getStudNum(), stud1.getStudName(), stud2.getCourse(),
                    stud2.getYear(), stud2.getSection());
            return data;
        }
    }

    public static String getInfo() {
        return info;
    }
}
