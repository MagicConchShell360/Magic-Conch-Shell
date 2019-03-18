/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
 * DIYInfoEdit class creates the GUI interface for
 * the DIYProjectInfo class and allows clients
 * to add, remove, or edit materials in a project.
 * 
 * @author Joseph Joo
 */
public class DIYInfoEdit extends DIYTemplateV2 {

	/** Eclipse generated serial number */
	private static final long serialVersionUID = 5594295517454998089L;
	
	private ArrayList<DIYProjectInfo> myProjectList;
	ArrayList<DIYMaterialInfo> myMaterialList;
	private DIYProjectInfo myProjectInfo;

	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;
	private JButton saveButton;

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
	
	/** True if adding to list else in edit mode */
	private boolean isAdd;

	// For creating a new material, we need the list so we can add the new material to list
	/**
	 * @author Joseph Joo, Kevin Santos
	 */
	public DIYInfoEdit(JFrame theParentFrame, ArrayList<DIYProjectInfo> theProjectList) {
		super(theParentFrame);
		isAdd = true;
		myProjectList = theProjectList;
		myJListModel = new DefaultListModel<>();
		myJList = new JList<>(myJListModel);
		myProjectInfo = new DIYProjectInfo("", 0, new ArrayList<DIYMaterialInfo>());
		myMaterialList = new ArrayList<>();
		
		setUpComponents();
		populateBlankFields();
	}

	/**
	 * @author Joseph Joo, Kevin Santos
	 */
	public DIYInfoEdit(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		isAdd = false;
		myProjectInfo = theProjectInfo;
		
		myJListModel = new DefaultListModel<>();
		myJList = new JList<>(myJListModel);
		
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

		myNameTextField.setEditable(true);
		myTotalCostTextField.setEditable(false);
		myPriorityTextField.setEditable(true);
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
	 * Main set up method for all GUI components
	 * 
	 * @author Joseph Joo, Kevin Santos
	 */
	private void setUpComponents() {
		
		JPanel northPanel = new JPanel(new GridLayout(5, 2));
		JPanel southPanel = new JPanel(new FlowLayout());
		
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
		
		southPanel.add(addButton);
		southPanel.add(removeButton);
		southPanel.add(editButton);
		southPanel.add(myJList);
		
		myCenterPanel.setLayout(new BorderLayout());
		myCenterPanel.add(northPanel, BorderLayout.NORTH);
		myCenterPanel.add(southPanel, BorderLayout.CENTER);
		myCenterPanel.add(saveButton, BorderLayout.SOUTH);
	}
	
	/**
	 * @author Kevin Santos
	 */
	private void populateBlankFields() {
		myNameTextField.setText("Project Name");
		myTotalCostTextField.setText("0");
		myPriorityTextField.setText("1");
		myLengthTextField.setText("0");
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
	 * @author Joseph Joo, Kevin Santos
	 */
	private void setUpButtons() {
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				DIYMaterialEdit view = new DIYMaterialEdit(myCurrentFrame,
						myProjectInfo.getMaterialList());							   
				view.setVisible(true);
			}
		});

		removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				int index = myJList.getSelectedIndex();
				myProjectInfo.getMaterialList().remove(index);
				myJListModel.remove(index);
			}
		});

		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {

				DIYMaterialEdit edit = new DIYMaterialEdit(myCurrentFrame,
						myProjectInfo.getMaterialList().get(myJList.getSelectedIndex()));
				edit.setVisible(true);
			}
		});
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (isAdd) {
					
					myProjectInfo.setName(myNameTextField.getText());
					myProjectInfo.setPriority(Integer.parseInt(myPriorityTextField.getText()));
					
					myProjectList.add(myProjectInfo);
					
					((DIYMain) myParentFrame).refresh();
					
				} else {
					
					myProjectInfo.setName(myNameTextField.getText());
					myProjectInfo.setPriority(Integer.parseInt(myPriorityTextField.getText()));
					((DIYMain) myParentFrame).refresh();
					
				}
				
				System.out.println(myProjectList.size());
				
			}
		});
	}
	
	/**
	 * This method refreshes the JList
	 * 
	 * @author Kevin Santos
	 */
	public void refresh() {		
		myJListModel.removeAllElements();
		
		for(int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			myJListModel.addElement(myProjectInfo.getMaterialList().get(i).toString());
		}

		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myLengthTextField.setText(myProjectInfo.getLength().toString());
	}
	
}
