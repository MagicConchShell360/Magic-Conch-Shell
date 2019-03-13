import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
//		myProjectInfo.add(new DIYProjectInfo("Window", BigDecimal.valueOf(500),
//				2, 7.5, new ArrayList<DIYMaterialInfo>()));
//
//		myProjectInfo.add(new DIYProjectInfo("Chair", BigDecimal.valueOf(25),
//				4, 5.5, new ArrayList<DIYMaterialInfo>()));
//		
//		myProjectInfo.add(new DIYProjectInfo("Table", BigDecimal.valueOf(150),
//				3, 5.0, new ArrayList<DIYMaterialInfo>()));
//		
//		myProjectInfo.add(new DIYProjectInfo("Desk", BigDecimal.valueOf(100),
//				2, 12.5, new ArrayList<DIYMaterialInfo>()));
//		
//		myProjectInfo.add(new DIYProjectInfo("Kitchen", BigDecimal.valueOf(7500),
//				5, 63.5, new ArrayList<DIYMaterialInfo>()));
		
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
				DIYInfoEdit read = new DIYInfoEdit(myCurrentFrame, myProjectInfo);
				read.setVisible(true);
			}
		});
		
		myEditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYInfoEdit edit = new DIYInfoEdit(myCurrentFrame, myProjectInfo.get(myProjectRegister.getSelectedIndex()));
				edit.setVisible(true);
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
						Scanner scanner = new Scanner(jfc.getSelectedFile().toString());;
						String name;
						int priority;
						ArrayList<DIYMaterialInfo> matList = new ArrayList<>();
						
						name = scanner.nextLine();
						priority = Integer.parseInt(scanner.nextLine());
						int matCount = Integer.parseInt(scanner.nextLine());
						
			    	    for(int i = 0; i < matCount; i++) {
			    	    	String matName;
			    	    	BigDecimal matPrice, matLength;
			    	    	int matQuantity;
			    	    	
			    	    	matName = scanner.nextLine();
			    	    	matPrice = new BigDecimal(Double.parseDouble(scanner.nextLine()));
			    	    	matQuantity = Integer.parseInt(scanner.nextLine());
			    	    	matPrice = new BigDecimal(Double.parseDouble(scanner.nextLine()));
			    	    	matList.add(new DIYMaterialInfo(matName, matPrice, matQuantity, matPrice));
			    	    }

						
						// Create a new project for the list
						DIYProjectInfo projectInfo = new DIYProjectInfo(name, priority, matList);
						
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

//				JFileChooser jfc = new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "TXT");
//				jfc.setDialogTitle("Export as...");
//				jfc.setFileFilter(filter);
//				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				int returnVal = jfc.showSaveDialog(myCurrentFrame);
//				
//				if (returnVal == JFileChooser.OPEN_DIALOG) {
//					System.out.println("You chose to save this file: " + jfc.getSelectedFile().getName());
//					OutputStream out;
//					try {
//						
//						PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//						writer.println("The first line");
//						writer.println("The second line");
//						writer.close();
//						
//						
//						out = new FileOutputStream("\\" + jfc.getSelectedFile().getName()+".txt");
//						out.write(jfc.getSelectedFile().toString().getBytes());
//						out.close();
//						
//						
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					
//				}

				
			    JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File("/home/me/Documents"));
			    int retrival = chooser.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION) {
			    	try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
			    		// Selects the project
			    		DIYProjectInfo exp = myProjectInfo.get(myProjectRegister.getSelectedIndex());
			    		
			    		// Wraps FileWriter to BufferedWriter
			    		BufferedWriter bw = new BufferedWriter(fw);
			    		bw.write(exp.getName());
			    		bw.newLine();
			    		bw.write(exp.getPriority());
			    		bw.newLine();
			    	    bw.write(exp.getMaterialList().size());
			    	    
			    	    for(int i = 0; i < exp.getMaterialList().size(); i++) {
			    	    	DIYMaterialInfo temp = exp.getMaterialList().get(i);
			    	    	bw.write(temp.getName());
			    	    	bw.newLine();
			    	    	bw.write(temp.getPrice().toString());
			    	    	bw.newLine();
			    	    	bw.write(temp.getQuantity());
			    	    	bw.newLine();
			    	    	bw.write(temp.getLength().toString());
			    	    	bw.newLine();
			    	    }
			    	    
			    	    bw.close();
			    	    fw.close();
			    	    
			    	} catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
				
			}
		});
		
		myAboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYAbout about = new DIYAbout(myCurrentFrame);
				about.setVisible(true);
			}
		});
		
	}
	
	
	
	
}