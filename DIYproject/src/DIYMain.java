import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
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
	private JFrame myCurrentFrame;

	/**
	 * Sets up all the components for the main window.
	 * 
	 * @author Kevin Santos
	 */
	public DIYMain() {
		myCurrentFrame = this;
		
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
	
	/**
	 * 
	 */
	private void initProjectRegister() {
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
	}
	
	/**
	 * Sets values to ProjectList
	 * 
	 * @author Kevin Santos
	 */
	private void initiateProjects() {
		//Sally made dummy variables 
		BigDecimal big1 = new BigDecimal(20.00);
		BigDecimal big2 = new BigDecimal(4.3);
		BigDecimal big3 = new BigDecimal(3.33);
		BigDecimal big4 = new BigDecimal(5);
		BigDecimal big5 = new BigDecimal(2.43);
		BigDecimal big6 = new BigDecimal(2.23);
		
		DIYMaterialInfo info = new DIYMaterialInfo("Wood", big1, 5, big2);
		DIYMaterialInfo info1 = new DIYMaterialInfo("Plastic", big1, 6, big2);
		DIYMaterialInfo info2 = new DIYMaterialInfo("Screws", big3, 2, big1);
		DIYMaterialInfo info3 = new DIYMaterialInfo("Wood gloss", big4, 7, big2);
		DIYMaterialInfo info4 = new DIYMaterialInfo("Paint", big5, 4, big6);
		
		ArrayList<DIYMaterialInfo> mat1 = new ArrayList<DIYMaterialInfo>();
		mat1.add(info);
		mat1.add(info1);
		
		ArrayList<DIYMaterialInfo> mat2 = new ArrayList<DIYMaterialInfo>();
		mat2.add(info2);
		mat2.add(info);
		
		ArrayList<DIYMaterialInfo> mat3 = new ArrayList<DIYMaterialInfo>();
		mat3.add(info3);
		mat3.add(info2);
		
		ArrayList<DIYMaterialInfo> mat4 = new ArrayList<DIYMaterialInfo>();
		mat4.add(info3);
		mat4.add(info4);
		
		ArrayList<DIYMaterialInfo> mat5 = new ArrayList<DIYMaterialInfo>();
		mat5.add(info);
		mat5.add(info3)
		
		//Sally made parameters based off of new constructor. 
		myProjectInfo.add(new DIYProjectInfo("Window", 2, mat1);
		
		myProjectInfo.add(new DIYProjectInfo("Chair", 1, mat2));
		
		myProjectInfo.add(new DIYProjectInfo("Table", 3, mat3));
		
		myProjectInfo.add(new DIYProjectInfo("Desk", 4, mat4);
		
		myProjectInfo.add(new DIYProjectInfo("Kitchen", 5, mat5);
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

		myAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
//				DIYInfoEdit read = new DIYInfoEdit(myCurrentFrame, myProjectInfo);
//				read.setVisible(true);
			}
		});
		
		myEditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
//				DIYInfoEdit edit = new DIYInfoEdit(myCurrentFrame, myProjectInfo.get(myProjectRegister.getSelectedIndex()));
//				edit.setVisible(true);
			}
		});
		
		myViewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYInfoRead view = new DIYInfoRead(myCurrentFrame, myProjectInfo.get(myProjectRegister.getSelectedIndex()));
				view.setVisible(true);
			}
		});
		
		myRemoveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				myCenterPanel.removeAll();
				int index = myProjectRegister.getSelectedIndex();
				
				myProjectInfo.remove(index);
				initProjectRegister();
				myCenterPanel.revalidate();
				myCenterPanel.repaint();
			}
		});
		
		myImportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				
				// Import Code
				
			}
		});
		
		myExportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {

				// Export Code
				
			}
		});
		
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
		
	}
	
	
	
	
}