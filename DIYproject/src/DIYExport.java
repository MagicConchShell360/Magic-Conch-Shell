import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This is the GUI class for importing files.
 * 
 * @author Kevin Santos, Joseph Joo
 */
public class DIYExport extends DIYTemplateV2 {
	
	private JFrame myParentFrame;
	private JButton exportButton;
	private JButton browseButton;
	
	public DIYExport(JFrame theParentFrame) {
		super(theParentFrame);
		exportButton = new JButton("Export");
		browseButton = new JButton("Browse");
		
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
