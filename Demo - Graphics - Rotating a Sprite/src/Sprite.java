
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import javax.swing.*;

 
public class Sprite extends Rectangle2D.Double{
	
	// FIELDS
	private Image image;
	private double dir;
	
	// CONSTRUCTORS
	public Sprite(String filename, double x, double y, double w, double h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Sprite(Image img, double x, double y, double w, double h) {
		super(x,y,w,h);
		image = img;
		dir = 0;
	}
	
	
	// METHODS	
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	
	public void draw(Graphics g, ImageObserver io) {
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform at = g2.getTransform();
		g2.translate(x+width/2, y+height/2);
		g2.rotate(dir);
		g.drawImage(image,(int)(-width/2),(int)(-height/2),(int)width,(int)height,io);
		g2.setTransform(at);
	}
	
	public void turn(double dir) {
		this.dir = dir;
	}
	
	public void turnToward(int x, int y) {
		dir = Math.atan(((double)this.y-y)/(this.x-x));
		if (this.x > x)
			dir += Math.PI;
	}
	
	public double getDirection() {
		return dir;
	}
	
	public void moveForward(double amount) {
		moveByAmount(amount*Math.cos(dir),amount*Math.sin(dir));
	}
	
	
}










