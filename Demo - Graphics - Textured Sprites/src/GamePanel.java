import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.awt.geom.*;


public class GamePanel extends JPanel
{
	public static final int ASSUMED_DRAWING_WIDTH = 800; 
	public static final int ASSUMED_DRAWING_HEIGHT = 600;

	private double ratioX, ratioY;

	private Sprite spikes, platform;

	public GamePanel () {
		super();
		setBackground(Color.WHITE);

		spikes = new Sprite("imgs/spikes.png", 100, 100, 400, 100, true);
		spikes.resizeImage(100, 100);

		platform = new Sprite("imgs/platform.png", 100, 300, 400, 200, true);
		platform.resizeImage(100, 100);

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);

		AffineTransform at = g2.getTransform();
		ratioX = (double)getWidth()/ASSUMED_DRAWING_WIDTH;
		ratioY = (double)getHeight()/ASSUMED_DRAWING_HEIGHT;
		g2.scale(ratioX,ratioY);

		spikes.draw(g2, this);
		platform.draw(g2, this);

		g2.setTransform(at);
	}



}
