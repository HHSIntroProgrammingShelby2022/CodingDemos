
import javax.swing.*;

public class NumberLine {
	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Hi non-Windows user! Yours will look a bit different. That's ok.");
		}

	    NumberWindow w = new NumberWindow();
	    w.setVisible(true);
	}
	
}