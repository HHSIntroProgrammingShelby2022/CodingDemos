import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class SimpleWindow extends JPanel implements KeyListener
{
	// TODO Your Instance Variables Here
	private Link hero;

	public SimpleWindow () {
		super();
		setBackground(Color.WHITE);
		hero = new Link(100,400);
		// TODO Add more customizations to the panel

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();

		Graphics2D g2 = (Graphics2D)g;

		hero.draw(g2, this);
		// TODO Add any custom drawings here
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_LEFT) {
			hero.block();
		} else if (code == KeyEvent.VK_RIGHT) {
			hero.slash();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}


	public void run() {
		while(true) {

			hero.act();


			repaint();


			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);

		panel.run();
	}




}
