import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Kevin Santos, Joseph Joo
 */
public class DIYAbout extends JFrame {
	
	private static final long serialVersionUID = 501364500319788870L;
	private DIYVersionInfo myInfo;
	private JPanel myPanel;
	private JLabel myVersionLabel;
	private JLabel myDeveloperLabel;
	private JButton myButton;
	private JFrame myParentFrame;
	
	public DIYAbout (JFrame thisParentFrame) {
		myInfo = new DIYVersionInfo();
		myPanel = new JPanel();
		myVersionLabel = new JLabel();
		myDeveloperLabel = new JLabel();
		myButton = new JButton();
		myParentFrame = thisParentFrame;
		
		setLayout(new BorderLayout());
		setTitle("About Us");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(400, 200);		
		setResizable(false);
		setLocationRelativeTo(null);
		setUpComponents();
		setVisible(false);
		
		setLocationRelativeTo(thisParentFrame);
		thisParentFrame.setEnabled(false);
	}
	
	private void setUpComponents() {
		add(myVersionLabel, BorderLayout.NORTH);
		add(myDeveloperLabel, BorderLayout.CENTER);
		add(myPanel, BorderLayout.SOUTH);
		myPanel.add(myButton);
	
		myVersionLabel.setText("Version: " + myInfo.getMyVersionInfo());
		myVersionLabel.setSize(100, 180);
		
		myDeveloperLabel.setText(
				"Developers: " + Arrays.toString(myInfo.getMyDevelopers()));	
		
		myButton.setText("Ok");
		
		myButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				myParentFrame.setEnabled(true);
				if (isVisible()) setVisible(false);
			}
		});
	}
}
