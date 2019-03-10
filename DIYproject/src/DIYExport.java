import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This is the GUI class for importing files.
 * 
 * @author Kevin Santos
 */
public class DIYExport extends DIYTemplate {
	
	private JFrame myParentFrame;
	private JButton exportButton;
	private JButton browseButton;
	
	public DIYExport(JFrame theParentFrame) {
		myParentFrame = theParentFrame;
		exportButton = new JButton("Export");
		browseButton = new JButton("Browse");
		
		setLocationRelativeTo(theParentFrame);
		theParentFrame.setEnabled(false);
		
		setUpButtons();
	}
	
	private void setUpButtons() {
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				
			}
		});
		
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				
			}
		});
	}
}
