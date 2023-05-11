import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SimpleWindow extends JPanel implements MouseListener
{
  // TODO Your Instance Variables Here

	private Rectangle r1, r2, r3;
	private String rectName;

	public SimpleWindow () {
		super();

		setBackground(Color.WHITE);
		r1 = new Rectangle(100,100,100,100);
		r2 = new Rectangle(300,150,200,50);
		r3 = new Rectangle(250,250,100,250);
		
		rectName = "";

		addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.RED);
		g.fillRect(r1.x,r1.y,r1.width,r1.height);
		
		g.setColor(Color.GREEN);
		g.fillRect(r2.x,r2.y,r2.width,r2.height);
		
		g.setColor(Color.BLUE);
		g.fillRect(r3.x,r3.y,r3.width,r3.height);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		int x = g.getFontMetrics().stringWidth(rectName)/2;
		g.drawString(rectName, r3.x + r3.width/2 - x,r3.y+r3.height/2);
		
		g.setColor(Color.BLACK);
		g.drawString("Mouse: Click on rectangles", 10, 20);
	}


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (r1.contains(arg0.getPoint())) {
			JOptionPane.showMessageDialog(this, "You hit the red rectangle!");
		} else if (r2.contains(arg0.getPoint())) {
			int answer = JOptionPane.showConfirmDialog(this, "Quit the program?");
			if (answer == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (r3.contains(arg0.getPoint())) {
			String answer = JOptionPane.showInputDialog(this, "Name this rectangle!");
			rectName = answer;
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
