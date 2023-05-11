import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
   This class demos 3 types of collision detection:
   1) Point-based. 
   	This is good for things that are very small (like a dot or "bullet") or for logical points (like the location 
   	of the mouse or mouse click).
   
   2) Rectangle-based. 
    This is good for things that are mostly rectangular (most sprites). Even for things that are not rectangular, it
    is frequently good enough for the user to not really notice.
    
   3) Pixel-based.
   	This is necessary if one of the objects you are detecting collisions with is very weirdly shaped. The downside is
   	that it can run slowly because it must check a lot of individual pixels.

   @author  Shelby
 */
public class SimpleWindow extends JPanel implements MouseMotionListener
{
	// TODO Your Instance Variables Here
	private int mouseX, mouseY;
	
	private Sprite player;
	private Sprite weirdShape;

	private boolean collision1;
	private boolean collision2;
	private boolean collision3;

	public SimpleWindow () {
		super();
		player = new Sprite((Image)null,0,0,40,40);
		weirdShape = new Sprite("squiggle.gif",200,100,600,400);
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		
		weirdShape.draw(g, this);
		g.setColor(Color.BLACK);
		weirdShape.drawBorder(g);
		
		player.draw(g, this);

		g.setFont(new Font("SansSerif",Font.BOLD,12));

		if (collision1) {
			g.setColor(new Color(125,0,0));
			String s = "The mouse is over the squiggle (point-based collision).";
			g.drawString(s, 30, 30);
		}
		if (collision2) {
			g.setColor(new Color(0,125,0));
			String s = "The player is over the squiggle sprite (rectangle-based collision).";
			g.drawString(s, 30, 60);
		}
		if (collision3) {
			g.setColor(new Color(0,0,125));
			String s = "The player is touching the squiggle (pixel-based collision).";
			g.drawString(s, 30, 90);
		}

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	
	public void run() {
		while(true) {
			// MAKE A CHANGE
			player.moveToward(mouseX, mouseY);
			
			collision1 = weirdShape.isPointInside(mouseX, mouseY);
			collision2 = weirdShape.doesRectangleSpriteCollide(player);
			collision3 = weirdShape.doesSpritePixelsCollide(player);

			// SHOW THE CHANGE
			repaint();

			// WAIT
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();
		panel.setBackground(Color.WHITE);
		Container c = w.getContentPane();
		c.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		
		panel.run();
	}



}


