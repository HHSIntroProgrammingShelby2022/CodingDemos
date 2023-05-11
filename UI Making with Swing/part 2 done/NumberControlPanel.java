
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class NumberControlPanel extends JPanel {
	
	private JPanel buttons1;
	private JPanel buttons2;
	private JPanel buttons3;
	private JRadioButton r1, r2, r3;
	private ButtonGroup r;
	private JCheckBox c1, c2, c3;
	private JSlider slide;
	
	public NumberControlPanel() {
		super();
		setBackground(Color.white);
		r = new ButtonGroup();
		r1 = new JRadioButton("Circle", true);
		r2 = new JRadioButton("Triangle");
		r3 = new JRadioButton("Square");
		r.add(r1);
		r.add(r2);
		r.add(r3);
		c1 = new JCheckBox("Bold");
		c2 = new JCheckBox("Italic");
		c3 = new JCheckBox("Underline");
		slide = new JSlider(0,100,50);
		slide.setMajorTickSpacing(10);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		buttons1 = new JPanel();
		buttons2 = new JPanel();
		buttons3 = new JPanel();
		setLayout(new BorderLayout(10,10));
		buttons1.setLayout(new GridLayout(3,1));
		buttons2.setLayout(new GridLayout(3,1));
		buttons3.setLayout(new BorderLayout());
		buttons1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		buttons2.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		buttons3.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		buttons1.add(r1);
		buttons1.add(r2);
		buttons1.add(r3);
		buttons2.add(c1);
		buttons2.add(c2);
		buttons2.add(c3);
		buttons3.add(slide);
		this.add(buttons1,BorderLayout.WEST);
		this.add(buttons2,BorderLayout.EAST);
		this.add(buttons3,BorderLayout.CENTER);
	}
	
}
