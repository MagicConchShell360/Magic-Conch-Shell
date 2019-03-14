
/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Template for all GUI classes except Main
 * 
 * @author Kevin Santos
 */
public class DIYTemplateV2 extends DIYTemplate {

	/** Eclipse generated serial number. */
	private static final long serialVersionUID = 5788174364676729650L;
	private JButton myBackButton;
	public JFrame myParentFrame;
	public JFrame myCurrentFrame;

	/**
	 * Sets up the panel available for the frame
	 * 
	 * @author Kevin Santos
	 */
	public DIYTemplateV2(JFrame thisParentFrame) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
