import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

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

				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "TXT");
				jfc.setDialogTitle("Import as...");
				jfc.setFileFilter(filter);
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = jfc.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						Scanner scanner;
						String name;
						BigDecimal totalCost;
						int priority;
						double length;
						
						scanner = new Scanner(jfc.getSelectedFile().toString());
						
						scanner.next();	//Skip "Project Name:"
						name = scanner.next();
						
						scanner.next();	//Skip "Total Cost: "
						totalCost = new BigDecimal(scanner.next());
						
						scanner.next();	//Skip "Priority: "
						priority = Integer.parseInt(scanner.next());
						
						scanner.next();	// Skip "Length: "
						length = Double.parseDouble(scanner.next());
						
						// Create a new project for the list
						DIYProjectInfo projectInfo = new DIYProjectInfo(name, 
								totalCost, priority, length, new ArrayList<DIYMaterialInfo>());
						
						// Add the project to the existing list
						myProjectInfo.add(projectInfo);
						
						scanner.close();
						
						myCenterPanel.repaint();
						
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
		}

			}
		});
		
		myExportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {

				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "TXT");
				jfc.setDialogTitle("Export as...");
				jfc.setFileFilter(filter);
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = jfc.showSaveDialog(getParent());
				if (returnVal == JFileChooser.OPEN_DIALOG) {
					System.out.println("You chose to save this file: " + jfc.getSelectedFile().getName());
					OutputStream out;
					try {
						out = new FileOutputStream("\\" + jfc.getSelectedFile().getName()+".txt");
						out.write(jfc.getSelectedFile().toString().getBytes());
						myCenterPanel.repaint();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}

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