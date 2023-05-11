import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GoogleBooks extends JPanel implements ActionListener {

	
	private JTextField search;
	private JTextArea output;
	
	public GoogleBooks() {
		super(new BorderLayout());
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		add(scroll, BorderLayout.CENTER);
		search = new JTextField();
		search.addActionListener(this);
		
		JButton goButton = new JButton("SEARCH");
		goButton.addActionListener(this);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(search, BorderLayout.CENTER);
		bottomPanel.add(goButton, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Scanner scan = null;
		String encodedSearch = java.net.URLEncoder.encode(search.getText());

		String url = "https://www.googleapis.com/books/v1/volumes?q=" + encodedSearch + "&maxResults=1";

		try {
			String response = "";

			URL reader = new URL(url);
			scan = new Scanner(reader.openStream());

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				response += line + "\n";
			}

			output.setText(response);
			
			/*

			NOTE:
			If you'd like to pull an image from online, that is possible to do using the ImageIO class. It would look something like:
			
			Image downloadedImage = ImageIO.read(new URL("URL OF THE IMAGE TO DOWNLOAD"));

			*/

		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		JFrame w = new JFrame("Google Books API Demo");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GoogleBooks panel = new GoogleBooks();
		
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}
	
}
