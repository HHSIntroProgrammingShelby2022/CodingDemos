import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.event.*;

public class GameBoard extends JPanel implements MouseListener, MouseMotionListener
{

	private Rectangle gamePiece1, gamePiece2, gamePiece3;
	
	private Rectangle selected;

	public GameBoard () 
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		
		gamePiece1 = new Rectangle(0,0,50,50);
		gamePiece2 = new Rectangle(100,100,50,50);
		gamePiece3 = new Rectangle(150,300,50,50);
		
		selected = null;

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  

		g.setColor(Color.RED);
		g.fillRect(gamePiece1.x, gamePiece1.y, gamePiece1.width, gamePiece1.height);
		
		g.setColor(Color.GREEN);
		g.fillRect(gamePiece2.x, gamePiece2.y, gamePiece2.width, gamePiece2.height);
		
		g.setColor(Color.BLUE);
		g.fillRect(gamePiece3.x, gamePiece3.y, gamePiece3.width, gamePiece3.height);
		
		if (selected != null) {
			g.setColor(Color.BLACK);
			g.fillRect(selected.x, selected.y, selected.width, selected.height);
		}
	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void mousePressed(MouseEvent e) 
	{
		int x = e.getX();
		int y = e.getY();

		if (gamePiece1.contains(x,y)) {
			selected = gamePiece1;
		} else if (gamePiece2.contains(x,y)) {
			selected = gamePiece2;
		} else if (gamePiece3.contains(x,y)) {
			selected = gamePiece3;
		}

		repaint();

	}

	public void mouseReleased(MouseEvent e)
	{
		selected = null;

		repaint();

	}

	public void mouseDragged(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();

		if (selected != null)
		{
			selected.x = x;
			selected.y = y;
		}

		repaint();

	}

	public void mouseMoved(MouseEvent e)
	{

	}

}

