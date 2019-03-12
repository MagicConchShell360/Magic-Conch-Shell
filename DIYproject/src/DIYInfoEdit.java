import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
 * DIYInfoEdit class creates the GUI interface for
 * the DIYProjectInfo class and allows clients
 * to add, remove, or edit materials in a project.
 * 
 * @author Joseph
 *
 */
public class DIYInfoEdit extends DIYTemplateV2 {

	private static final long serialVersionUID = 5594295517454998089L;
	private ArrayList<DIYMaterialInfo> myMaterialInfoList;
	private DIYProjectInfo myProjectInfo;
	private ArrayList<String> myListDisplay;

	private JFrame myParentFrame;

	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;

	private JLabel myNameLabel;
	private JLabel myCostLabel;
	private JLabel myPriorityLabel;
	private JLabel myLengthLabel;

	private JTextField myNameTextField;
	private JTextField myTotalCostTextField;
	private JTextField myPriorityTextField;
	private JTextField myLengthTextField;
	private JList myJList;

	public DIYInfoEdit(JFrame theParentFrame, ArrayList<DIYMaterialInfo> theMaterialInfoList) {
		super(theParentFrame);
		myMaterialInfoList = theMaterialInfoList;
		myListDisplay = new ArrayList<>();
		myJList = new JList();
		setUpComponents();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public DIYInfoEdit(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		myParentFrame = theParentFrame;
		myProjectInfo = theProjectInfo;
		myListDisplay = new ArrayList<>();
		myJList = new JList();
		setUpComponents();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private void setUpButtons() {

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				
				DIYMaterialEdit view = new DIYMaterialEdit(myProjectInfo.getMaterialList(), 
				 											new DIYMaterialInfo("", new BigDecimal(0), 0, new BigDecimal(0)),
															myParentFrame);							   
				view.setVisible(true);
			}
		});

		removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (!myJList.isSelectionEmpty()) {
					int index = myJList.getSelectedIndex();
					myJList.removeAll();
					myMaterialInfoList.remove(index);
					myCenterPanel.revalidate();
					myCenterPanel.repaint();}
			}
		});

		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (!myJList.isSelectionEmpty()) {
					int index = myJList.getSelectedIndex();
					DIYMaterialEdit view = new DIYMaterialEdit(myProjectInfo.getMaterialList(),
																myProjectInfo.getMaterialList().get(index), 
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

		myNameTextField.setEditable(true);
		myTotalCostTextField.setEditable(true);
		myPriorityTextField.setEditable(true);
		myLengthTextField.setEditable(true);

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
		
		southPanel.add(addButton);
		southPanel.add(removeButton);
		southPanel.add(editButton);
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
