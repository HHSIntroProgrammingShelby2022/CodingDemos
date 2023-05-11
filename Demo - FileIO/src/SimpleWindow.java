import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class SimpleWindow extends JPanel implements ActionListener
{
	// TODO Your Instance Variables Here

	private JTextArea text;

	public SimpleWindow () {
		super();

		setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		text = new JTextArea();
		add(text);

		JPanel saveload = new JPanel();
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");
		save.addActionListener(this);
		load.addActionListener(this);
		saveload.add(save);
		saveload.add(load);
		add(saveload,BorderLayout.NORTH);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();

		// TODO Add any custom drawings here
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
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Save")) {
			FileIO writer = new FileIO();
			writer.writeText("savefile.txt", text.getText());
		} else if (arg0.getActionCommand().equals("Load")) {
			FileIO reader = new FileIO();
			text.setText(reader.readText("savefile.txt"));
		}
	}
}
