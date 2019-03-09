import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DIYMain extends DIYTemplate {

	public JButton myAboutButton;

	
	public DIYMain() {
		myAboutButton = new JButton("About");
		myWestPanel.add(myAboutButton);
		
		setUpButtonListeners();
	}
	
	protected void setUpButtonListeners() {
		myAboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYAbout about = new DIYAbout();
				about.showAbout();
			}
		});
	}
}