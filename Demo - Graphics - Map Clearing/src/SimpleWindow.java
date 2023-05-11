import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

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
public class SimpleWindow extends JPanel implements KeyListener
{
	// TODO Your Instance Variables Here

	private Image house;
	private Image tree;
	private Image sun;

	private Image einstein;
	private int charX, charY;

	private BufferedImage overlay;



	public SimpleWindow () {
		super();
		// TODO Add customizations to the panel

		house = (new ImageIcon("house.jpg")).getImage();
		tree = (new ImageIcon("tree.gif")).getImage();
		sun = (new ImageIcon("sun.jpg")).getImage();
		einstein = (new ImageIcon("einstein.gif")).getImage();

		charX = 50;
		charY = 300;

		overlay = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		Graphics g = overlay.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, overlay.getWidth(), overlay.getHeight());
		
		revealChar();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();

		double xRatio = width / 800.0;
		double yRatio = height / 600.0;


		Graphics2D g2 = (Graphics2D)g;
		g2.scale(xRatio, yRatio);


		// SUN
		g.drawImage(sun, 525, 50, 150, 150, this);

		// TREE
		g.drawImage(tree,150,150,175,300, this);

		// HOUSE
		g.drawImage(house, 500, 200, 250,250, this);


		g.setColor(Color.GREEN);
		g.drawLine(0,450,800,450);
		g.setColor(new Color(125,0,125));
		g.setFont(new Font("Serif",Font.BOLD | Font.ITALIC, 40));
		g.drawString("Sunnyvale, CA: A Scenic Landscape",100,525);

		g.drawImage(einstein, charX, charY, 75, 150, this);

		g.drawImage(overlay, 0, 0, 800, 600, this);

	}



	// As your program grows, you may want to...
	//   1) Move this main method into its own 'main' class
	//   2) Customize the JFrame by writing a class that extends it, then creating that type of object in your main method instead
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Scenic Landscape");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();

		w.addKeyListener(panel);

		panel.setBackground(Color.WHITE);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}
	
	public void revealChar() {
		Graphics g = overlay.getGraphics();
		Graphics2D g2 = (Graphics2D)g;
		int rule = AlphaComposite.CLEAR;
		Composite comp = AlphaComposite.getInstance(rule , 0.5f );
		g2.setComposite(comp );

		g.fillOval(charX + 75/2 - 150/2, charY + 150/2 - 150/2, 150, 150);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_LEFT) {
			if (charX > 8) {
				charX -= 8;
			}
		} else if (code == KeyEvent.VK_RIGHT) {
			if (charX < 800 - 83) {
				charX += 8;
			}
		} else if (code == KeyEvent.VK_UP) {
			if (charY > 8) {
				charY -= 8;
			}
		} else if (code == KeyEvent.VK_DOWN) {
			if (charY < 600 - 158) {
				charY += 8;
			}
		}



		revealChar();


		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
