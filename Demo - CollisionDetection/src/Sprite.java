import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Sprite {


	private int x, y;
	private int width, height;
	private Image image;
	
	
	public Sprite(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Sprite(Image img, int x, int y, int w, int h) {
		image = img;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	


	public void draw(Graphics g, ImageObserver io) {
		if (image != null) {
			g.drawImage(image,x,y,width,height,io);
		} else {
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void drawBorder(Graphics g) {
		g.drawRect(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void moveToward(int x, int y) {
		this.x += (x - this.x)/30;
		this.y += (y - this.y)/30;
	}
	
	public boolean isPointInside(double x, double y) {
		if (x >= this.x && y >= this.y && x <= this.x+width && y <= this.y+height) {  // Check if the point is in the bounds of the rectangle
			return true;
		} else {
			return false;
		}
	}
	
	public boolean doesRectangleSpriteCollide(Sprite other) {
		Rectangle r1 = new Rectangle(x,y,width,height);  // Turn both sprites in to Rectangles (java library class)
		Rectangle r2 = new Rectangle(other.x,other.y,other.width,other.height);
		
		if (r1.intersects(r2)) { // Check if they intersect
			return true;
		} else {
			return false;
		}
	}

	public boolean doesSpritePixelsCollide(Sprite other) {
		BufferedImage pic = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // Make a new image that I can draw on
		Graphics g = pic.getGraphics(); // This Graphics will draw on to the image
		g.setColor(Color.WHITE); 
		g.fillRect(0, 0, pic.getWidth(), pic.getHeight()); // Make the whole image white
		g.drawImage(image,0,0,width,height,null);
		
		int overlapLeft = Math.max(x, other.x); // Find the rectangle of space in which the 2 sprite images overlap with each other
		int overlapTop = Math.max(y, other.y);
		int overlapRight = Math.min(width+x, other.width+other.x);
		int overlapBottom = Math.min(height+y, other.height+other.y);
		
		for (int i = overlapLeft; i < overlapRight; i++ ) {   // Look at every pixel coordinate in the rectangle
			for (int j = overlapTop; j < overlapBottom; j++ ) {
				if (pic.getRGB(i-x, j-y) != Color.WHITE.getRGB()) {  // If that pixel is not white (you can also look for a specific color instead of any non-white pixel)
					return true;  // There was a collision!
				}
			}  
		}
		
		return false;
	}

}
