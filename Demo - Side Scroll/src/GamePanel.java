import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.geom.*;


public class GamePanel extends JPanel implements KeyListener
{
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 300;

	private double ratioX, ratioY;

	private Sprite mario;

	private boolean rightKey, leftKey, upKey, downKey;

	private Rectangle2D.Double visibleSpace;
	private Rectangle2D.Double characterSpace;

	private Level thisLevel;

	public GamePanel () {
		super();
		setBackground(Color.WHITE);
		thisLevel = new Level();
		visibleSpace = new Rectangle2D.Double(0,thisLevel.getHeight()-SCREEN_HEIGHT,SCREEN_WIDTH,SCREEN_HEIGHT);
		characterSpace = new Rectangle2D.Double(visibleSpace.getX()+visibleSpace.getWidth()/5,visibleSpace.getY()+visibleSpace.getHeight()/5,visibleSpace.getWidth()*3/5,visibleSpace.getHeight()*3/5);

		mario = new Sprite("mario.png",0,300,50,60, false);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		ratioX = (double)getWidth()/SCREEN_WIDTH;
		ratioY = (double)getHeight()/SCREEN_HEIGHT;
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX,ratioY);
		g2.translate(-visibleSpace.getX(),-visibleSpace.getY());

		thisLevel.draw(g2, this);
		mario.draw(g2,this);

		g2.setTransform(at);
	}



	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.rightKey = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.leftKey = true;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.upKey = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.downKey = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.rightKey = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.leftKey = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.upKey = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.downKey = false;
		}
	}

	public void keyTyped(KeyEvent e) {

	}


	public void run() {
		while(true) {
			long startTime = System.currentTimeMillis();

			if (upKey) 
				mario.moveInLimits(thisLevel, 0, -5);
			if (downKey) 
				mario.moveInLimits(thisLevel, 0, 5);
			if (leftKey) 
				mario.moveInLimits(thisLevel, -5, 0);
			if (rightKey) 
				mario.moveInLimits(thisLevel, 5, 0);

			slideWorldToImage(mario);

			repaint();

			long waitTime = 20 - (System.currentTimeMillis() - startTime);

			if (waitTime > 0) {
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {}
			} else Thread.yield();
		}
	}

	public void slideWorldToImage(Sprite img) {
		Point2D.Double center = img.getCenter();
		if (!characterSpace.contains(center)) {
			double newX = visibleSpace.getX();
			double newY = visibleSpace.getY();

			if (center.getX() < characterSpace.getX()) {
				newX -= (characterSpace.getX() - center.getX());
			} else if (center.getX() > characterSpace.getX() + characterSpace.getWidth()) {
				newX += (center.getX() - (characterSpace.getX() + characterSpace.getWidth()));
			}

			if (center.getY() < characterSpace.getY()) {
				newY -= (characterSpace.getY() - center.getY());
			} else if (center.getY() > characterSpace.getY() + characterSpace.getHeight()) {
				newY += (center.getY() - characterSpace.getY() - characterSpace.getHeight());
			}
			newX = Math.max(newX,0);
			newY = Math.max(newY,0);
			newX = Math.min(newX,thisLevel.getWidth()-visibleSpace.getWidth());
			newY = Math.min(newY,thisLevel.getHeight()-visibleSpace.getHeight());

			visibleSpace.setRect(newX,newY,visibleSpace.getWidth(),visibleSpace.getHeight());

			characterSpace.setRect(visibleSpace.getX()+visibleSpace.getWidth()/5,visibleSpace.getY()+visibleSpace.getHeight()/5,visibleSpace.getWidth()*3/5,visibleSpace.getHeight()*3/5);
		}
	}

}
