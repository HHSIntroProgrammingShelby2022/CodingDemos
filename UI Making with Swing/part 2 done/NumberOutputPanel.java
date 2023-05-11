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
public class NumberOutputPanel extends JPanel
{
  // TODO Your Instance Variables Here


  public NumberOutputPanel () {
	  super();
	  setBackground(Color.WHITE);
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
	
	g.setColor(Color.white);
	g.fillRect(0,0,width,height);

	
	g.setColor(Color.cyan);
	g.fillRect((int)(startOfLine),95,(int)(widthOfLine),10);

	g.setColor(Color.black);
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


}
