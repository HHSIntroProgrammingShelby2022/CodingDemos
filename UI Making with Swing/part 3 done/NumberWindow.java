
import javax.swing.*;
import java.awt.*;

public class NumberWindow extends JFrame {
	
	NumberOutputPanel panel1;
	NumberControlPanel panel2;
	
	public NumberWindow() {
		super("NumberLine");
		setBounds(100, 100, 640, 480);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panel1 = new NumberOutputPanel();
	    add(panel1,BorderLayout.CENTER);
	    panel2 = new NumberControlPanel(panel1);
	    add(panel2,BorderLayout.SOUTH);
	    setResizable(true);
	}
	

}