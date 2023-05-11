package demo3;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class NumberControlPanel extends JPanel implements ActionListener,ChangeListener{
	
	JPanel buttons1;
	JPanel buttons2;
	JPanel buttons3;
	JRadioButton r1, r2, r3;
	ButtonGroup r;
	JCheckBox c1, c2, c3;
	JSlider slide;
	
	NumberOutputPanel p;
	
	public NumberControlPanel(NumberOutputPanel p) {
		super();
		this.p=p;
		setBackground(Color.white);
		r = new ButtonGroup();
		r1 = new JRadioButton("Circle", true);
		r2 = new JRadioButton("Triangle");
		r3 = new JRadioButton("Square");
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r.add(r1);
		r.add(r2);
		r.add(r3);
		c1 = new JCheckBox("Bold");
		c2 = new JCheckBox("Italic");
		c3 = new JCheckBox("Underline");
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		slide = new JSlider(0,100,50);
		slide.setMajorTickSpacing(10);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.addChangeListener(this);
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
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == r1) {
			p.setShape(0);
		} else if (o == r2) {
			p.setShape(1);
		} else if (o == r3) {
			p.setShape(2);
		} else if (o == c1 || o == c2) {
			int style = 0;
			if (c1.isSelected())
				style = style|Font.BOLD;
			if (c2.isSelected())
				style = style|Font.ITALIC;
			p.setFontStyle(style);
		} else if (o == c3) {
			p.setUnderlines(c3.isSelected());
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		p.setNum(slide.getValue());
	}
	
}
