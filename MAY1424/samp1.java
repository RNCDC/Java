package MAY1424;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")

public class samp1 extends JFrame { //FRAME
	private JLabel lbl = new JLabel("Sample frame");
    public samp1(String s)
    { super(s);
      Container a = getContentPane();
      a.setLayout(new FlowLayout());
      a.add(lbl);
      setVisible(true); //para makita ung window\
      setSize(200,200); // size nung window
    }
    //@SuppressWarnings("deprecation")
	public static void main(String args[])
    {  samp1 test = new samp1("My Frame"); //pinaka title ng window
       //test.show();
       test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

