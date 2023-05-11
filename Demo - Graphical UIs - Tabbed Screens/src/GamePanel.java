import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;


public class GamePanel extends JPanel 
{

  private String message;

  public GamePanel () {
	  super();
	  setBackground(Color.WHITE);
	  message = "This is the game screen! Put game stuff here!";
  }
  

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

	Graphics2D g2 = (Graphics2D)g;

    int width = getWidth();
    int height = getHeight();
    
    double ratioX = (double)width/800.0;
    double ratioY = (double)height/600.0;
    
    AffineTransform at = g2.getTransform();
    g2.scale(ratioX, ratioY);

    g.setColor(Color.BLACK);
    g.setFont(new Font("SansSerif",Font.BOLD,28));
    int strWidth = g.getFontMetrics().stringWidth(message);
    g.drawString(message, 400-strWidth/2, 300);
    
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }




}
