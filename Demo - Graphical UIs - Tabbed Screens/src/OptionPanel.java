import javax.swing.*;
import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {

	private TabSwitcher ts;
	
	public OptionPanel(TabSwitcher ts) {
		this.ts = ts;
		
		JPanel p = new JPanel();
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(Box.createVerticalStrut(300));
		
		JButton button = new JButton("Play the Game!");
		button.addActionListener(this);
		p.add(button);
		add(p);
	}
	
	public void actionPerformed(ActionEvent e) {
		ts.switchToTab(1);
	}
	
}