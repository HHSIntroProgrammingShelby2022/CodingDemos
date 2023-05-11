import javax.swing.*;

public class Main {


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Side Scroll Demo");
		
		w.setBounds(100, 100, 640, 480);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    GamePanel panel = new GamePanel();
	    
	    w.addKeyListener(panel);
	    w.add(panel);
	    w.setVisible(true);
	    
	    panel.run();
	}
  
}