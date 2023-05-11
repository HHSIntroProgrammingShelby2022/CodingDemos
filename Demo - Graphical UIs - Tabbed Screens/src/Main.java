import javax.swing.*;

public class Main {

	public static void main(String[] args)
	{
		JFrame w = new JFrame("Tab Demo");
		w.setBounds(100, 100, 800, 600);
		w. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    WholeUI tabPanel = new WholeUI();
	    
	    w.add(tabPanel);
	
	    w.setVisible(true);
	}
  
}