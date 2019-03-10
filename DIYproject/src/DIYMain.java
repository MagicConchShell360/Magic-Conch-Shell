import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRootPane;
import javax.swing.ListSelectionModel;

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
	private ArrayList<String> myListDisplay;

	/**
	 * Sets up all the components for the main window.
	 * 
	 * @author Kevin Santos
	 */
	public DIYMain() {
		// Centers the window to the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		// Initiates components
		myProjectInfo = new ArrayList<>();
		initiateProjects();
		addWestPanelButtons();
		setUpButtonListeners();
		initProjectRegister();
	}
	
	private void initProjectRegister() {
		myListDisplay = new ArrayList<>();
		
		
		for(int i = 0; i < myProjectInfo.size(); i++) {
			myListDisplay.add(myProjectInfo.get(i).toString());
			System.out.println(myProjectInfo.get(i).toString());
		}
		
		myProjectRegister = new JList(myListDisplay.toArray());
		myProjectRegister.setPreferredSize(new Dimension(635,555));
		myProjectRegister.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myProjectRegister.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myProjectRegister.setSelectedIndex(0);
		myCenterPanel.add(myProjectRegister);
	}
	
	/**
	 * Sets values to ProjectList
	 * 
	 * @author Kevin Santos
	 */
	private void initiateProjects() {
		myProjectInfo.add(new DIYProjectInfo("Window", BigDecimal.valueOf(500),
				2, 7.5, new ArrayList<DIYMaterialInfo>()));

		myProjectInfo.add(new DIYProjectInfo("Chair", BigDecimal.valueOf(25),
				4, 5.5, new ArrayList<DIYMaterialInfo>()));
		
		myProjectInfo.add(new DIYProjectInfo("Table", BigDecimal.valueOf(150),
				3, 5.0, new ArrayList<DIYMaterialInfo>()));
		
		myProjectInfo.add(new DIYProjectInfo("Desk", BigDecimal.valueOf(100),
				2, 12.5, new ArrayList<DIYMaterialInfo>()));
		
		myProjectInfo.add(new DIYProjectInfo("Kitchen", BigDecimal.valueOf(7500),
				5, 63.5, new ArrayList<DIYMaterialInfo>()));
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
				JButton sourceButton = (JButton) event.getSource();
				DIYMain temp = (DIYMain) sourceButton.getParent().getParent().getParent()
						.getParent().getParent();
				
//				DIYInfoEdit read = new DIYInfoEdit(temp);
//				read.setVisible(true);
			}
		});
		
		myEditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				JButton sourceButton = (JButton) event.getSource();
				DIYMain temp = (DIYMain) sourceButton.getParent().getParent().getParent()
						.getParent().getParent();
				
//				DIYInfoEdit edit = new DIYInfoEdit(temp);
//				edit.setVisible(true);
			}
		});
		
		myViewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				JButton sourceButton = (JButton) event.getSource();
				DIYMain temp = (DIYMain) sourceButton.getParent().getParent().getParent()
						.getParent().getParent();
				
				DIYInfoRead view = new DIYInfoRead(temp, myProjectInfo.get(0));
				view.setVisible(true);
			}
		});
		
		myRemoveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				myCenterPanel.removeAll();
				int index = myProjectRegister.getSelectedIndex();
				
				myProjectInfo.remove(index);
				myListDisplay = new ArrayList<>();
				
				
				for(int i = 0; i < myProjectInfo.size(); i++) {
					myListDisplay.add(myProjectInfo.get(i).toString());
				}
				
				
				myProjectRegister = new JList(myListDisplay.toArray());
				myProjectRegister.setPreferredSize(new Dimension(635,555));
				myProjectRegister.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				myProjectRegister.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				myProjectRegister.setSelectedIndex(0);
				myCenterPanel.add(myProjectRegister);
				
				
				myCenterPanel.revalidate();
				myCenterPanel.repaint();
			}
		});
		
	}
	
	
}