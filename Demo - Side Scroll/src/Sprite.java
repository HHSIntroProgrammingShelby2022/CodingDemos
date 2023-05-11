

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;

public class Sprite extends Rectangle2D.Double {

	// FIELDS
	private Image img;
	

	
	// CONSTRUCTOR
	/*
	 All coordinates are in assumed coordinates and represent data for the
	 image, not the window.
	 */
	public Sprite(String filename, int x, int y, int w, int h, boolean textured) {
		super(x,y,w,h);
		try {
			img = ImageIO.read(new File(filename));
		} catch(IOException ex) {
		}
		
	}




	public void draw(Graphics2D g, ImageObserver io) {
		g.drawImage(img, (int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()), io);
	}
	
	public void moveInLimits(Rectangle2D.Double limits, double x, double y) {
		double newX = this.x + x;
		double newY = this.y + y;
		if (limits.contains(new Rectangle2D.Double(newX,newY,width,height))) {
			this.x = newX;
			this.y = newY;
		}
	}
	
	public Point2D.Double getCenter() {
		return new Point2D.Double(getX()+getWidth()/2,getY()+getHeight()/2);
	}


}














