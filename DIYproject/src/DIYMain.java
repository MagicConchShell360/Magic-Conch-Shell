import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
	
	/** Eclipse generated serial version */
	private static final long serialVersionUID = -1694107177449675424L;
	
	// Buttons at left sidebar
	private JButton myAddButton;
	private JButton myEditButton;
	private JButton myViewButton;
	private JButton myRemoveButton;
	private JButton myImportButton;
	private JButton myExportButton;
	private JButton myAboutButton;
	
	// Fields for displaying JList
	DefaultListModel<String> myProjectRegisterModel;
	private JList<String> myProjectRegister;
	
	// List of projects available
	private ArrayList<DIYProjectInfo> myProjectList;
	
	// Holder for this current frame
	private JFrame myCurrentFrame;
	
	

	/**
	 * Sets up all the components for the main window.
	 * 
	 * @author Kevin Santos
	 */
	public DIYMain() {
		// Centers the window to the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
						 dim.height / 2 - this.getSize().height / 2);
		
		// Init fields
		myProjectList = new ArrayList<>();
		myProjectRegisterModel = new DefaultListModel<>();
		myCurrentFrame = this;
		
		// Init components
		initiateProjects();
		addWestPanelButtons();
		setUpButtonListeners();
		initProjectRegister();
	}
	
	/**
	 * Populates the Jlist for the projects
	 * 
	 * @author Kevin Santos
	 */
	private void initProjectRegister() {		
		myProjectRegister = new JList<>(myProjectRegisterModel);
		
		
		for(int i = 0; i < myProjectList.size(); i++) {
			myProjectRegisterModel.addElement(myProjectList.get(i).toString());
		}
		
		
		myProjectRegister.setPreferredSize(new Dimension(635,555));
		myProjectRegister.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myProjectRegister.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myProjectRegister.setSelectedIndex(0);
		myCenterPanel.add(myProjectRegister);
	}
	
	/**
	 * Sets values to ProjectList
	 * 
	 * @author Kevin Santos, Sally Ho
	 */
	private void initiateProjects() {

        // Dummy variables 
        BigDecimal big1 = new BigDecimal(20.0);
        BigDecimal big2 = new BigDecimal(4.5);
        BigDecimal big3 = new BigDecimal(3.5);
        BigDecimal big4 = new BigDecimal(5);
        BigDecimal big5 = new BigDecimal(2.75);
        BigDecimal big6 = new BigDecimal(2.25);
        
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
        mat5.add(info3);
        
        //Sally made parameters based off of new constructor. 
        myProjectList.add(new DIYProjectInfo("Window", 2, mat1));
        
        myProjectList.add(new DIYProjectInfo("Chair", 1, mat2));
        
        myProjectList.add(new DIYProjectInfo("Table", 3, mat3));
        
        myProjectList.add(new DIYProjectInfo("Desk", 4, mat4));
        
        myProjectList.add(new DIYProjectInfo("Kitchen", 5, mat5));
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
				DIYInfoEdit read = new DIYInfoEdit(myCurrentFrame, myProjectList);
				read.setVisible(true);
			}
		});
		
		myEditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYInfoEdit edit = new DIYInfoEdit(myCurrentFrame,
						myProjectList.get(myProjectRegister.getSelectedIndex()));
				edit.setVisible(true);
			}
		});
		
		myViewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				DIYInfoRead view = new DIYInfoRead(myCurrentFrame,
						myProjectList.get(myProjectRegister.getSelectedIndex()));
				view.setVisible(true);
			}
		});
		
		myRemoveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				int index = myProjectRegister.getSelectedIndex();
				myProjectList.remove(index);
				myProjectRegisterModel.remove(index);
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
						File tempFile = new File(jfc.getSelectedFile().toString());
						
						Scanner scanner = new Scanner(tempFile);
						String name;
						int priority;
						ArrayList<DIYMaterialInfo> matList = new ArrayList<>();
						
						name = scanner.nextLine();
						System.out.println(name);
						priority = Integer.parseInt(scanner.nextLine());
						System.out.println(priority);
						int matCount = Integer.parseInt(scanner.nextLine());
						System.out.println(matCount);
						
			    	    for(int i = 0; i < matCount; i++) {
			    	    	String matName;
			    	    	BigDecimal matPrice, matLength;
			    	    	int matQuantity;
			    	    	
			    	    	matName = scanner.nextLine();
			    	    	matPrice = new BigDecimal(Double.parseDouble(scanner.nextLine()));
			    	    	matQuantity = Integer.parseInt(scanner.nextLine());
			    	    	matLength = new BigDecimal(Double.parseDouble(scanner.nextLine()));
			    	    	matList.add(new DIYMaterialInfo(matName, matPrice, matQuantity, matLength));
			    	    }

						
						// Create a new project for the list
						DIYProjectInfo projectInfo = new DIYProjectInfo(name, priority, matList);
						
						// Add the project to the existing list
						myProjectList.add(projectInfo);
						
						scanner.close();
						
						myCenterPanel.repaint();
						
						refresh();
						
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}

			}
		});
		
		myExportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {			
			    JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File("/home/me/Documents"));
			    int retrival = chooser.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION) {
			    	try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
			    		// Selects the project
			    		DIYProjectInfo exp = myProjectList.get(myProjectRegister.getSelectedIndex());
			    		
			    		// Wraps FileWriter to BufferedWriter
			    		BufferedWriter bw = new BufferedWriter(fw);
			    		bw.write(exp.getName());
			    		bw.newLine();
			    		bw.write(String.valueOf(exp.getPriority()));
			    		bw.newLine();
			    	    bw.write(String.valueOf(exp.getMaterialList().size()));
			    	    bw.newLine();
			    	    
			    	    for(int i = 0; i < exp.getMaterialList().size(); i++) {
			    	    	DIYMaterialInfo temp = exp.getMaterialList().get(i);
			    	    	bw.write(temp.getName());
			    	    	bw.newLine();
			    	    	bw.write(String.valueOf(temp.getPrice().toString()));
			    	    	bw.newLine();
			    	    	bw.write(String.valueOf(temp.getQuantity()));
			    	    	bw.newLine();
			    	    	bw.write(String.valueOf(temp.getLength().toString()));
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
	
	/**
	 * This method refreshes the JList
	 * 
	 * @author Kevin Santos
	 */
	public void refresh() {
		myProjectRegisterModel.removeAllElements();
		
		for(int i = 0; i < myProjectList.size(); i++) {
			myProjectRegisterModel.addElement(myProjectList.get(i).toString());
		}
	}
	
	
}