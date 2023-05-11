import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


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
	private Image customImage;
	private Image invisibleCursorImage;

	public SimpleWindow () {
		super();

		setBackground(Color.WHITE);

		try {
			customImage = ImageIO.read(new File("bullseye.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invisibleCursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();

		String out = "Press:\n1 for Default Cursor\n2 for Custom Cursor\n3 for No Cursor";
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		String[] lines = out.split("\n");
		FontMetrics fm = g.getFontMetrics();
		int fontHeight = fm.getHeight();
		int yStart = height/3;
		for (String s : lines) {
			g.drawString(s, width/2-fm.stringWidth(s)/2, yStart);
			yStart += fontHeight;
		}
	}


	// As your program grows, you may want to...
	//   1) Move this main method into its own 'main' class
	//   2) Customize the JFrame by writing a class that extends it, then creating that type of object in your main method instead.
	//   3) Rename this class (SimpleWindow is not a good name - this class actually represents the *Panel*, not the window)
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		w.addKeyListener(panel);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_1) {
			Cursor c = Cursor.getDefaultCursor();
			setCursor (c);
		} else if (code == KeyEvent.VK_2) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Cursor c = toolkit.createCustomCursor(customImage , new Point(16, 16), "img");
			setCursor (c);
		} else if (code == KeyEvent.VK_3) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Cursor c = toolkit.createCustomCursor(invisibleCursorImage , new Point(getX(), getY()), "img2");
			setCursor (c);
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
}
