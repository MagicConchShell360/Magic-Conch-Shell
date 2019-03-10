import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DIYInfoEdit extends DIYTemplate {
	
	private ArrayList<DIYProjectInfo> myProjectInfoList;
	private DIYProjectInfo myProjectInfo;

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

	public DIYInfoEdit(JFrame theInfoReadFrame) {

	}

	public DIYInfoEdit(ArrayList<DIYProjectInfo> theProjectInfoList) {

		myProjectInfoList = theProjectInfoList;

	}

	public DIYInfoEdit(DIYProjectInfo theProjectInfo) {

		myProjectInfo = theProjectInfo;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setUpButtons();
		setUpLabels();
		setUpTextFields();
		setUpProjectInfoPanel();
		setUpMaterialInfoPanel();
		populateTextFields();

	}

	
	private void setUpButtons() {

		addButton = new JButton("Add");
		// removeButton = new JButton("Remove");
		// editButton = new JButton("Edit");

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {

			}
		});

		/*
		 * removeButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(final ActionEvent theEvent) {
		 * 
		 * } });
		 * 
		 * editButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(final ActionEvent theEvent) {
		 * 
		 * } });
		 */
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

		myNameTextField.setEditable(false);
		myTotalCostTextField.setEditable(false);
		myPriorityTextField.setEditable(false);
		myLengthTextField.setEditable(false);

		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));
	}

	private void setUpProjectInfoPanel() {

		myCenterPanel.add(myNameLabel);
		myCenterPanel.add(myNameTextField);

		myCenterPanel.add(myCostLabel);
		myCenterPanel.add(myTotalCostTextField);

		myCenterPanel.add(myPriorityLabel);
		myCenterPanel.add(myPriorityTextField);

		myCenterPanel.add(myLengthLabel);
		myCenterPanel.add(myLengthTextField);

	}

	private void setUpMaterialInfoPanel() {

	}

	private void populateTextFields() {

	}

}
