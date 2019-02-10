import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Team Magic Conch Shell
 * TCSS 360
 */
public class DIYAbout extends JFrame{
	
	private DIYVersionInfo myInfo;
	private JPanel myPanel;
	private JLabel myLabel;
	private JButton myButton;
	
	public DIYAbout () {
		
		myInfo = new DIYVersionInfo();
		myPanel = new JPanel();
		myLabel = new JLabel();
		myButton = new JButton();
		
		setLayout(new BorderLayout());
		setTitle("About Us");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 100);		
		setResizable(false);
		setLocationRelativeTo(null);
		setUpComponents();
		setVisible(true);
	}
	
	private void setUpComponents() {
		add(myLabel, BorderLayout.CENTER);
		add(myPanel, BorderLayout.SOUTH);
		myPanel.add(myButton);
		
		myLabel.setText("Version: " + myInfo.getMyVersionInfo()
						+ "/n" 
						+ myInfo.getMyDevelopers());
	
		myButton.setText("Ok");
		
		myButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				if (isVisible()) setVisible(false);
			}
		});
	}
}
