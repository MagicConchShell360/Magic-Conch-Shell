import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DIYTemplateV2 extends DIYTemplate {

	private JButton myBackButton;
	public JFrame myParentFrame;
	public JFrame myCurrentFrame;
	
	public DIYTemplateV2(JFrame thisParentFrame) {
		myParentFrame = thisParentFrame;
		myCurrentFrame = this;
		
		myBackButton = new JButton("Back");
		setLocationRelativeTo(thisParentFrame);
		thisParentFrame.setEnabled(false);
		
		myWestPanel.add(myBackButton);
		
		myBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				myParentFrame.setEnabled(true);
				myCurrentFrame.dispose();
			}
		});
	}
	
}
