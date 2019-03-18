/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * DIYInfoRead class creates the GUI interface for the 
 * DIYProjectInfo class and allows clients to view the
 * materials in a project.
 * 
 * @author Joseph Joo
 *
 */
public class DIYInfoRead extends DIYTemplateV2 {

	private static final long serialVersionUID = -8160056479228037385L;
	private DIYProjectInfo myProjectInfo;

	private JButton viewButton;

	private JLabel myNameLabel;
	private JLabel myCostLabel;
	private JLabel myPriorityLabel;
	private JLabel myLengthLabel;

	private JTextField myNameTextField;
	private JTextField myTotalCostTextField;
	private JTextField myPriorityTextField;
	private JTextField myLengthTextField;
	
	private JList<String> myJList;
	DefaultListModel<String> myJListModel;
	
	private JFrame myCurrentFrame;

	/**
	 * The default constructor class for DIYInfoRead
	 * Sets up the GUI interface components
	 * 
	 * @param theParentFrame
	 * @param theProjectInfo
	 * 
	 * @author Joseph Joo
	 */
	public DIYInfoRead(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		myCurrentFrame = this;
		myProjectInfo = theProjectInfo;
		myJListModel = new DefaultListModel<>();
		myJList = new JList<>(myJListModel);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUpComponents();
	}

	/**
	 * JLabels for the labeling project information fields
	 * 
	 * @author Joseph Joo
	 */
	private void setUpLabels() {

		myNameLabel = new JLabel();
		myCostLabel = new JLabel();
		myPriorityLabel = new JLabel();
		myLengthLabel = new JLabel();

		myNameLabel.setText("Project Name: ");
		myCostLabel.setText("Total Cost: ");
		myPriorityLabel.setText("Priority: ");
		myLengthLabel.setText("Total Length: ");
		
	}

	/**
	 *  JTextFields for viewing project information input by user
	 *  
	 *  @author Joseph Joo
	 */
	private void setUpTextFields() {

		myNameTextField = new JTextField();
		myTotalCostTextField = new JTextField();
		myPriorityTextField = new JTextField();
		myLengthTextField = new JTextField();

		myNameTextField.setEditable(false);
		myTotalCostTextField.setEditable(false);
		myPriorityTextField.setEditable(false);
		myLengthTextField.setEditable(false);

	}

	/**
	 * JList to display all materials currently in project
	 * 
	 * @author Joseph Joo
	 */
	private void setUpMaterialList() {
		
		myJList.setPreferredSize(new Dimension(400, 300));
		myJList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myJList.setSelectedIndex(0);
	}

	/**
	 * Fills all text fields with their respective project information data types
	 * 
	 * @author Joseph Joo, Kevin Santos
	 */
	private void populateTextFields() {
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(myProjectInfo.getLength().toString());
		
		for(int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			myJListModel.addElement(myProjectInfo.getMaterialList().get(i).toString());
		}
	}
	
	/**
	 * Main set up method for all GUI components
	 * 
	 * @author Joseph Joo, Kevin Santos
	 */
	private void setUpComponents() {
		JPanel northPanel = new JPanel(new GridLayout(4, 2));
		JPanel southPanel = new JPanel(new GridBagLayout());
		
		setUpButtons();
		setUpLabels();
		setUpTextFields();
		populateTextFields();
		setUpMaterialList();

		northPanel.add(myNameLabel);
		northPanel.add(myNameTextField);

		northPanel.add(myCostLabel);
		northPanel.add(myTotalCostTextField);

		northPanel.add(myPriorityLabel);
		northPanel.add(myPriorityTextField);

		northPanel.add(myLengthLabel);
		northPanel.add(myLengthTextField);

		southPanel.add(viewButton);
		southPanel.add(myJList);
		
		myCenterPanel.setLayout(new BorderLayout());
		myCenterPanel.add(northPanel, BorderLayout.NORTH);
		myCenterPanel.add(southPanel, BorderLayout.SOUTH);
	}

	/**
	 * JButton for viewing individual material components
	 * 
	 * @author Joseph Joo
	 */
	private void setUpButtons() {
		viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (!myJList.isSelectionEmpty() ) {
					int index = myJList.getSelectedIndex();
					DIYMaterialRead view = new DIYMaterialRead(myCurrentFrame,
							myProjectInfo.getMaterialList().get(index));
					view.setVisible(true);
				}
			}
		});
	}
}
