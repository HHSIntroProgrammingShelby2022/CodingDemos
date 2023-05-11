import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	private JPanel cardPanel;
	
	private OptionPanel panel1;
	private GamePanel panel2;
	
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		panel1 = new OptionPanel(this);    
	    panel2 = new GamePanel(this);
	    
	
	    cardPanel.add(panel1,"1"); // Card is named "1"
	    cardPanel.add(panel2,"2"); // Card is named "2"
	    
	    add(cardPanel);
	    addKeyListener(panel2);
	
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		Main w = new Main("Screen Switching Demo");
		w.panel2.run();
	}
  
	public void changePanel(String name) {
		if (name.equals("2")) {
			panel2.setPaused(false);
		} else {
			panel2.setPaused(true);
		}
		
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
  
}