import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;


/**
   NOTE:
   The src folder of this project includes all of the source code files that make this work. However, to use this library, you need only to:
   
   1) Grab the jar file from the /dist folder and add it to your project.
   2) Check out the code in this class for a sample showing how to use the library.
   3) Looks at the docs in the /doc folder for additional information about the library methods.
   
   You do not need to add any of the classes here to your project.
   
 */
public class Tester extends JPanel implements ActionListener, JayLayerListener
{
	// TODO Your Instance Variables Here
	private JComboBox<String> effects;
	private JButton play, startstop, next;

	private JayLayer sound;

	public Tester () {
		super();

		JPanel p0 = new JPanel();
		p0.setLayout(new BoxLayout(p0,BoxLayout.Y_AXIS));
		p0.setBackground(Color.WHITE);

		String[] soundEffects = new String[]{"effect1.mp3","effect2.mp3","effect3.mp3","effect4.mp3","effect5.mp3"};
		String[] songs = new String[]{"song1.mp3","song2.mp3","song3.mp3","song4.mp3","song5.mp3"};

		JPanel p1 = new JPanel();
		p1.setBorder(new TitledBorder("Sound Effects"));
		p1.setBackground(Color.WHITE);
		effects = new JComboBox<String>(soundEffects);
		p1.add(effects);

		play = new JButton("Play!");
		play.addActionListener(this);
		p1.add(play);

		p0.add(p1);
		p0.add(Box.createVerticalStrut(100));

		JPanel p3 = new JPanel();
		p3.setBorder(new TitledBorder("Background Music"));
		p3.setBackground(Color.WHITE);
		startstop = new JButton("Start");
		startstop.addActionListener(this);
		p3.add(startstop);
		next = new JButton("Next");
		next.addActionListener(this);
		next.setEnabled(false);
		p3.add(next);

		p0.add(p3);

		setBackground(Color.WHITE);

		sound=new JayLayer("audio/","audio/",false);
		sound.addPlayList();
		sound.addSongs(0,songs);
		sound.addSoundEffects(soundEffects);
		sound.changePlayList(0);
		sound.addJayLayerListener(this);

		add(p0);
		// TODO Add more customizations to the panel

	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		String source = arg0.getActionCommand();
		if (source.equals("Play!")) {
			int i = effects.getSelectedIndex();
			if (i >= 0)
				sound.playSoundEffect(i);
		} else if (source.equals("Start") || source.equals("Next")) {
			sound.nextSong();
		} else if (source.equals("Stop")) {
			sound.stopSong();
		}

	}


	@Override
	public void songEnded() {
		// TODO Auto-generated method stub

	}


	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub

	}


	@Override
	public void musicStarted() {
		startstop.setText("Stop");
		next.setEnabled(true);
	}


	@Override
	public void musicStopped() {
		startstop.setText("Start");
		next.setEnabled(false);
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
		Tester panel = new Tester();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}

}
