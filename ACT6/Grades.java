package ACT6;

	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import javax.swing.border.EmptyBorder;
	import java.awt.event.ActionListener;
	import java.awt.EventQueue;

	public class Grades extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField textFieldMidterm;
	    private JTextField textFieldFinal;
	    private JTextField textFieldAverage;
	    private JButton btnCompile;
	    private JButton btnReturn;
	    private JMenuSample parentFrame;

	    public Grades(JMenuSample parent) {
	        this.parentFrame = parent;
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 400, 300);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblMidterm = new JLabel("Midterm Grade:");
	        lblMidterm.setBounds(30, 30, 100, 25);
	        contentPane.add(lblMidterm);

	        textFieldMidterm = new JTextField();
	        textFieldMidterm.setBounds(150, 30, 200, 25);
	        contentPane.add(textFieldMidterm);

	        JLabel lblFinal = new JLabel("Final Grade:");
	        lblFinal.setBounds(30, 70, 100, 25);
	        contentPane.add(lblFinal);

	        textFieldFinal = new JTextField();
	        textFieldFinal.setBounds(150, 70, 200, 25);
	        contentPane.add(textFieldFinal);

	        JLabel lblAverage = new JLabel("Average:");
	        lblAverage.setBounds(30, 110, 100, 25);
	        contentPane.add(lblAverage);

	        textFieldAverage = new JTextField();
	        textFieldAverage.setBounds(150, 110, 200, 25);
	        textFieldAverage.setEditable(false); 
	        contentPane.add(textFieldAverage);

	        btnCompile = new JButton("Compile");
	        btnCompile.setBounds(70, 180, 100, 25);
	        contentPane.add(btnCompile);

	        btnReturn = new JButton("Return");
	        btnReturn.setBounds(220, 180, 100, 25);
	        contentPane.add(btnReturn);

	        btnReturn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });

	        btnCompile.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Logic to calculate average (assuming simple average)
	                try {
	                    double midterm = Double.parseDouble(textFieldMidterm.getText());
	                    double finalGrade = Double.parseDouble(textFieldFinal.getText());
	                    double average = (midterm + finalGrade) / 2;
	                    textFieldAverage.setText(String.valueOf(average));
	                    parentFrame.setAverageGrade(average);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(contentPane, "Please enter valid grades", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Grades frame = new Grades(null);
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	}

