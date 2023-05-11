import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	
	public OptionPanel(Main w) {
		this.w = w;
		JPanel p = new JPanel();
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(Box.createVerticalStrut(300));
		p.setBackground(new Color(0,0,0,0));
		
		JButton button = new JButton("Play the Game!");
		button.addActionListener(this);
		p.add(button);
		add(p);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(g.getFont().deriveFont(40f));
		g.drawString("This is the menu!", getWidth()/2-150, 200);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");
	}
	
}