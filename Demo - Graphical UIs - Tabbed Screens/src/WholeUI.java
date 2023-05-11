
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

import javax.swing.JPanel;



public class WholeUI extends JPanel implements TabSwitcher {

	private GamePanel gamePane;
    private OptionPanel optionPane;
    
    private JTabbedPane tabbedPane;

	public WholeUI() {

        optionPane = new OptionPanel(this);

        gamePane = new GamePanel();

        setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=35 marginheight=5>Options</body></html>", optionPane);

        tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Game</body></html>", gamePane);

		add(tabbedPane, BorderLayout.CENTER);

		setBounds(30,30,1100, 750);
	}

	
    public void switchToTab(int i) {
        tabbedPane.setSelectedIndex(i);
    }

}
