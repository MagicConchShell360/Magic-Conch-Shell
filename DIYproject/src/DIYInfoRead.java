import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
 * @author Joseph
 *
 */
public class DIYInfoRead extends DIYTemplateV2 {

	private static final long serialVersionUID = -8160056479228037385L;
	private DIYProjectInfo myProjectInfo;
	private JFrame myParentFrame;

	private JButton viewButton;

	private JLabel myNameLabel;
	private JLabel myCostLabel;
	private JLabel myPriorityLabel;
	private JLabel myLengthLabel;

	private JTextField myNameTextField;
	private JTextField myTotalCostTextField;
	private JTextField myPriorityTextField;
	private JTextField myLengthTextField;
	
	private JList myJList;
	
	private ArrayList<String> myListDisplay;

	/**
	 * The default constructor class for DIYInfoRead
	 * Sets up the GUI interface components
	 * 
	 * @param theParentFrame
	 * @param theProjectInfo
	 */
	public DIYInfoRead(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		myProjectInfo = theProjectInfo;
		myListDisplay = new ArrayList<>();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUpComponents();
	}

	/**
	 * JButton for viewing individual material components
	 */
	private void setUpButtons() {

		viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (!myJList.isSelectionEmpty() ) {
					int index = myJList.getSelectedIndex();
					DIYMaterialRead view = new DIYMaterialRead(myProjectInfo.getMaterialList().get(index),
																myParentFrame);
					view.setVisible(true);
				}
			}
		});
	}

	/**
	 * JLabels for the labelling project information fields
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
	 */
	private void setUpMaterialList() {
		
		myJList.setPreferredSize(new Dimension(400, 300));
		myJList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myJList.setSelectedIndex(0);
	}

	/**
	 * Main set up method for all GUI components
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
	 * Fills all text fields with their respective project information data types
	 */
	private void populateTextFields() {
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));
		
		for (int i = 0; i < myProjectInfo.getMaterialList().size(); i++) 
			myListDisplay.add(myProjectInfo.getMaterialList().get(i).getName());
	}

}
