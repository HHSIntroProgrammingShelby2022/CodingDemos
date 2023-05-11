package demo1;

import java.awt.*;
import javax.swing.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   Period - TODO Your Period
   Assignment - TODO Name of Assignment

   Sources - TODO list collaborators
 */
public class NumberLine extends JPanel
{
  // TODO Your Instance Variables Here


  public NumberLine () {
	  super();
	  // TODO Add customizations to the panel
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background

    int width = getWidth();
    int height = getHeight();
    
    int widthOfLine = width*8/10;
	int startOfLine = width/10;
	int endOfLine = 9*width/10;
	
	g.setColor(Color.CYAN);
	g.fillRect(startOfLine,95,widthOfLine,10);

	g.setColor(Color.BLACK);
	for (int i = 0; i <= 10; i++) {
		int w = (i*widthOfLine/10) + startOfLine;
		g.drawLine(w,90,w,110);
		String numLabel = i*10+"";
		Font f = new Font("SansSerif",Font.BOLD,16);
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		int sw = fm.stringWidth(numLabel);
		g.drawString(numLabel,w-sw/2,70);
	}
	
	g.drawLine(startOfLine,100,endOfLine,100);

  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("NumberLine");
    w.setBounds(100, 100, 640, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    NumberLine panel = new NumberLine();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
