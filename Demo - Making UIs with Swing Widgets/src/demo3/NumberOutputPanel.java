package demo3;

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

  Font font;
  int shapeType;
  int shapeX;
  boolean underline;

  public NumberOutputPanel () {
	  super();
	  setBackground(Color.WHITE);
	  font = new Font("SansSerif",Font.PLAIN,16);
	  shapeType=0;
	  shapeX=50;
	  underline=false;
	  // TODO Add customizations to the panel
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
	
	int width = getWidth();
	int height = getHeight();
	g.setColor(Color.white);
	g.fillRect(0,0,width,height);
	
	int widthOfLine = width*8/10;
	int startOfLine = width/10;
	int endOfLine = 9*width/10;

	g.setColor(Color.cyan);
	g.fillRect((int)(startOfLine),95,(int)(widthOfLine),10);

	g.setColor(Color.black);
	g.drawLine(startOfLine,100,endOfLine,100);
	
	for (int i = 0; i <= 10; i++) {
		int w = (i*widthOfLine/10) + startOfLine;
		g.drawLine(w,90,w,110);
		String numLabel = i*10+"";
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		int sw = fm.stringWidth(numLabel);
		g.drawString(numLabel,w-sw/2,70);
		if (underline) {
			g.drawLine(w-sw/2,70+fm.getDescent(),w+sw/2,70+fm.getDescent());
		}
	}
	
	g.setColor(Color.red);
	int centerPoint=(int)(startOfLine+shapeX/100.0*widthOfLine);
	if (shapeType==0) {
		g.fillOval(centerPoint-5,95,10,10);
	} else if (shapeType==2) {
		g.fillRect(centerPoint-5,95,10,10);
	} else if (shapeType==1) {
		g.fillPolygon(new int[]{centerPoint-5,centerPoint,centerPoint+5},new int[]{105,95,105},3);
	}
	

  }
  
  public void setNum(int x) {
  	shapeX=x;
  	repaint();
  }
  
  public void setShape(int type) {
  	shapeType = type;
  	repaint();
  }
  
  public void setFontStyle(int style) {
  	font = new Font("SansSerif",style,16);
  	repaint();
  }
  
  public void setUnderlines(boolean under) {
  	underline = under;
  	repaint();
  }


}
