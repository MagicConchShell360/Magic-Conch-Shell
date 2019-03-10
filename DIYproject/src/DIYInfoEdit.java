import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DIYInfoEdit extends DIYTemplate {

	private ArrayList<DIYProjectInfo> myProjectInfoList;
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
	private JTextArea myMaterialInfoTextArea;

	public DIYInfoEdit(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {

		myParentFrame = theParentFrame;
		myProjectInfo = theProjectInfo;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(8, 2));
		setUpButtons();
		setUpLabels();
		setUpTextFields();
		setUpComponents();
		populateTextFields();
		
		setLocationRelativeTo(theParentFrame);
		theParentFrame.setEnabled(false);

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
		myNameTextField.setMinimumSize(new Dimension(250, 100));
		myTotalCostTextField = new JTextField();
		myTotalCostTextField.setMinimumSize(new Dimension(250, 100));
		myPriorityTextField = new JTextField();
		myPriorityTextField.setMinimumSize(new Dimension(250, 100));
		myLengthTextField = new JTextField();
		myLengthTextField.setMinimumSize(new Dimension(250, 100));

		myNameTextField.setEditable(true);
		myTotalCostTextField.setEditable(true);
		myPriorityTextField.setEditable(true);
		myLengthTextField.setEditable(true);

	}

	private void setUpComponents() {

		myCenterPanel.add(myNameLabel);
		myCenterPanel.add(myNameTextField);

		myCenterPanel.add(myCostLabel);
		myCenterPanel.add(myTotalCostTextField);

		myCenterPanel.add(myPriorityLabel);
		myCenterPanel.add(myPriorityTextField);

		myCenterPanel.add(myLengthLabel);
		myCenterPanel.add(myLengthTextField);
		
		myCenterPanel.add(addButton);

	}

	private void populateTextFields() {
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));

		for (int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			myMaterialInfoTextArea.setText(myProjectInfo.getMaterialList().get(i).toString());
		}
	}
}
