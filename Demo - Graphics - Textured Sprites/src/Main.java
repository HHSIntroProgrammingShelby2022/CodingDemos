import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	
	public Main(String title) {
		super(title);
		setBounds(100, 100, 640, 480);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    GamePanel panel = new GamePanel();
	    
	    add(panel);
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		Main w = new Main("Textured Sprites Demo");
	}
  
}