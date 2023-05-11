
import javax.swing.*;
import java.awt.*;

public class NumberWindow extends JFrame {
	
	private NumberOutputPanel panel1;
	private NumberControlPanel panel2;
	
	public NumberWindow() {
		super("NumberLine");
		setBounds(100, 100, 640, 480);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panel1 = new NumberOutputPanel();
	    add(panel1,BorderLayout.CENTER);
	    panel2 = new NumberControlPanel();
	    add(panel2,BorderLayout.SOUTH);
	    setResizable(true);
	}
	

}