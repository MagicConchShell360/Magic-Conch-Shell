import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 * This is the GUI class for the main window.
 * 
 * @author Kevin Santos
 */
public class DIYMain extends DIYTemplate {
	
	private JButton myAddButton;
	private JButton myEditButton;
	private JButton myViewButton;
	private JButton myRemoveButton;
	private JButton myImportButton;
	private JButton myExportButton;
	private JButton myAboutButton;
	private JList<String> myProjectRegister;
	private ArrayList<DIYProjectInfo> myProjectInfo;

	/**
	 * Sets up all the components for the main window.
	 * 
	 * @author Kevin Santos
	 */
	public DIYMain() {
		addWestPanelButtons();
		
		String[] test =  {"Project Name: Window --- Cost: $500 --- Priority: 2",
						  "Project Name: Chair --- Cost: $25 --- Priority: 4",
						  "Project Name: Table --- Cost: $150 --- Priority: 3",
						  "Project Name: Desk --- Cost: $100 --- Priority: 2",
						  "Project Name: Kitchen --- Cost: $7500 --- Priority: 5"
		};
		
		myProjectRegister = new JList(test);
		myProjectRegister.setPreferredSize(new Dimension(635,555));
		myProjectRegister.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		myCenterPanel.add(myProjectRegister);
		
		setUpButtonListeners();
	}
	
	/**
	 * This method add the buttons to myWestPanel.
	 * 
	 * @author Kevin Santos
	 */
	private void addWestPanelButtons() {
		myAddButton = new JButton("Add");
		myEditButton = new JButton("Edit");
		myViewButton = new JButton("View");
		myRemoveButton = new JButton("Remove");
		myImportButton = new JButton("Import");
		myExportButton = new JButton("Export");
		myAboutButton = new JButton("About");
		
		myWestPanel.add(myAddButton);
		myWestPanel.add(myEditButton);
		myWestPanel.add(myViewButton);
		myWestPanel.add(myRemoveButton);
		myWestPanel.add(myImportButton);
		myWestPanel.add(myExportButton);
		myWestPanel.add(myAboutButton);
	}
	
	/**
	 * This method sets up the action listeners for the west panel buttons.
	 * 
	 * @author Kevin Santos
	 */
	protected void setUpButtonListeners() {

		myAboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				JButton sourceButton = (JButton) event.getSource();
				DIYMain temp = (DIYMain) sourceButton.getParent().getParent().getParent()
						.getParent().getParent();
				
				DIYAbout about = new DIYAbout(temp);
				about.setVisible(true);
			}
		});
		
		myAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
//				DIYInfoEdit read = new DIYInfoEdit();
//				read.setVisible(true);
			}
		});
		
		myEditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
//				DIYInfoEdit edit = new DIYInfoEdit();
//				edit.setVisible(true);
			}
		});
		
		myViewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
//				DIYInfoRead view = new DIYInfoRead();
//				view.setVisible(true);
			}
		});
		
		myRemoveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				
				// Add code to delete from DIYPRojectInfoList
				
			}
		});
		
	}
	
	
	
	
	
	public String toString() {
		return "Hello";
	}
	
	
	
	
	
}