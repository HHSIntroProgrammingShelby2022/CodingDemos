import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class GamePanel extends JPanel implements KeyListener
{

	private String message;
	private Main m;
	
	private boolean paused;
	
	private int animationCounter;

	public GamePanel (Main m) {
		super();
		this.m = m;
		setBackground(Color.WHITE);
		message = "This is the game screen! Press escape to return to the menu. ";
		paused = true;
		animationCounter = 0;
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


	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			m.changePanel("1");
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	
	public void run() {
		while (true) {  // Standard game loop
			
			if (!paused) {  // Don't do stuff while "paused"
				
				animationCounter++;
				if (animationCounter > 5) {
					message = message.substring(1) + message.charAt(0);
					animationCounter = 0;
				}
				
			}
			
			repaint();
			
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void setPaused(boolean p) {
		this.paused = p;
	}


}
