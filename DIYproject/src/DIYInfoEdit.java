import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class DIYInfoEdit extends DIYTemplateV2 {

	private ArrayList<DIYMaterialInfo> myMaterialInfoList;
	private DIYProjectInfo myProjectInfo;

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
	private JList<DIYMaterialInfo> myJList;
	
	public DIYInfoEdit(JFrame theParentFrame, ArrayList<DIYMaterialInfo> theMaterialInfoList) {
		super(theParentFrame);
		myMaterialInfoList = theMaterialInfoList;
		setUpComponents();
	}
	
	public DIYInfoEdit(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		myParentFrame = theParentFrame;
		myProjectInfo = theProjectInfo;
		setUpComponents();
	}

	private void setUpButtons() {

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {

			}
		});

	}

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

	private void setUpComponents() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		myCenterPanel.setLayout(new GridLayout(8, 2));
		
		setUpButtons();
		setUpLabels();
		setUpTextFields();
		setUpComponents();
	
		myCenterPanel.add(myNameLabel);
		myCenterPanel.add(myNameTextField);

		myCenterPanel.add(myCostLabel);
		myCenterPanel.add(myTotalCostTextField);

		myCenterPanel.add(myPriorityLabel);
		myCenterPanel.add(myPriorityTextField);

		myCenterPanel.add(myLengthLabel);
		myCenterPanel.add(myLengthTextField);
		
		myCenterPanel.add(addButton);
		myCenterPanel.add(removeButton);
		myCenterPanel.add(editButton);
		
		populateTextFields();
	}

	private void populateTextFields() {
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));

		for (int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			//TODO FIX ME!!!
		}
	}
}
