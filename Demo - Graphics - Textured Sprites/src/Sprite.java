/*
****MovingImage****
This class represents an Image that can easily be moved around the screen.

Currently, it is set to assume a drawing size of 800x600 pixels, though this
can be modified. To have MovingImages on different drawing surfaces, this
code would need to be changed so that the assumed sizes are no longer static.

To use this class:
-Initalize your object using assumed coordinates.
-All instance methods that take in coordinates are taking in *assumed* 
 coordinates
-Before calling any other method, and anytime there is a possibility that 
 the window has changed size, call the setActualPanelSize() method.

Author: Shelby
Date: 5/1/12

*/


import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Sprite extends Rectangle2D.Double {

	// FIELDS
	private BufferedImage img;
	
	private boolean textured;
	
	


	public Sprite(String filename, int x, int y, int w, int h, boolean textured) {
		super(x,y,w,h);
		try {
			img = ImageIO.read(new File(filename));
		} catch(IOException ex) {
		}
		
		this.textured = textured;
	}
	
	
	public void resizeImage(int width, int height) {
		BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
		bi.createGraphics().drawImage(img, 0, 0, width, height, null);
		img = bi;
	}


	public void draw(Graphics2D g, ImageObserver io) {

		if (textured) {
			Rectangle2D tr = new Rectangle2D.Double((int)0, (int)0, (int)img.getWidth(), (int)img.getHeight());
			TexturePaint tp = new TexturePaint(img, tr);
			g.setPaint(tp);
			g.fill(this);
		} else
			g.drawImage(img, (int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()), io);

	}




}














