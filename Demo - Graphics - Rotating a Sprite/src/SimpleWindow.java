import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
public class SimpleWindow extends JPanel implements MouseMotionListener, KeyListener, Runnable
{
	// TODO Your Instance Variables Here
	private Hero guy;
	private Thread runThread;

	public SimpleWindow () {
		super();
		guy = new Hero();
		addMouseMotionListener(this);
		runThread = new Thread(this);
		runThread.start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method
		//   to paint the background

		int width = getWidth();
		int height = getHeight();

		guy.draw(g, this);
		
		g.drawString("Keys: W/UP", 10, 20);
		g.drawString("Mouse: Move to turn hero", 10, 40);

	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();

		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			guy.moveForward(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int code = arg0.getKeyCode();

		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			guy.moveForward(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		guy.turnToward(arg0.getX(), arg0.getY());
	}

	public void run() {
		while(true) {
			long startTime = System.currentTimeMillis(); 

			guy.act();

			repaint();

			long endTime = System.currentTimeMillis();

			try {
				Thread.sleep(Math.max(0, 20-(endTime-startTime)));
			} catch(InterruptedException ex) {}
		}
	}


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();
		panel.setBackground(Color.WHITE);
		Container c = w.getContentPane();
		c.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		w.addKeyListener(panel);
	}


}
