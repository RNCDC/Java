package MAY1424;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class act_gui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField num;
    private JTextField section;
    private JRadioButton bscs;
    private JRadioButton bsit;
    private JComboBox<String> year;
    private JTextArea textArea;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	act_gui frame = new act_gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public act_gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 634);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel StudNum = new JLabel("Student Number: ");
        StudNum.setBounds(10, 27, 101, 13);
        contentPane.add(StudNum);

        num = new JTextField();
        num.setBounds(121, 24, 111, 19);
        contentPane.add(num);
        num.setColumns(10);

        JLabel lblStudentName = new JLabel("Student Name: ");
        lblStudentName.setBounds(10, 50, 101, 13);
        contentPane.add(lblStudentName);

        name = new JTextField();
        name.setBounds(121, 47, 111, 19);
        contentPane.add(name);
        name.setColumns(10);

        JLabel lblCourse = new JLabel("Course: ");
        lblCourse.setBounds(10, 77, 75, 13);
        contentPane.add(lblCourse);

        bsit = new JRadioButton("BSIT");
        bsit.setBounds(78, 72, 61, 21);
        contentPane.add(bsit);

        bscs = new JRadioButton("BSCS");
        bscs.setBounds(155, 72, 61, 21);
        contentPane.add(bscs);

        // Group the radio buttons
        ButtonGroup courseGroup = new ButtonGroup();
        courseGroup.add(bsit);
        courseGroup.add(bscs);

        // Set default selection
        bsit.setSelected(true);

        JLabel lblYear = new JLabel("Year: ");
        lblYear.setBounds(10, 100, 75, 13);
        contentPane.add(lblYear);

        year = new JComboBox<>();
        year.setModel(new DefaultComboBoxModel<>(new String[]{"1st", "2nd", "3rd", "4th"}));
        year.setBounds(78, 100, 49, 21);
        contentPane.add(year);

        JLabel lblSection = new JLabel("Section: ");
        lblSection.setBounds(10, 130, 75, 13);
        contentPane.add(lblSection);

        section = new JTextField();
        section.setBounds(121, 130, 111, 19);
        contentPane.add(section);
        section.setColumns(10);

        textArea = new JTextArea();
        textArea.setBounds(90, 190, 180, 200);
        textArea.setEnabled(false);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("ADD");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StringBuilder studentInfo = new StringBuilder();
                studentInfo.append("Student Number: ").append(num.getText()).append("\n");
                studentInfo.append("Student Name: ").append(name.getText()).append("\n");
                studentInfo.append("Section: ").append(section.getText()).append("\n");

                if (bscs.isSelected()) {
                    studentInfo.append("Course: ").append(bscs.getText()).append("\n");
                } else if (bsit.isSelected()) {
                    studentInfo.append("Course: ").append(bsit.getText()).append("\n");
                } else {
                    studentInfo.append("Course: No selection").append("\n");
                }

                studentInfo.append("Year: ").append(year.getSelectedItem().toString()).append("\n");
                
                textArea.setText(studentInfo.toString());
            }
        });
        btnNewButton.setBounds(92, 160, 85, 21);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("CLOSE");
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(187, 160, 85, 21);
        contentPane.add(btnExit);
    }
}
