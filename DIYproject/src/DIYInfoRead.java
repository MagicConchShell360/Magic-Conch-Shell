import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DIYInfoRead extends DIYTemplate {

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
	private JTextArea myMaterialInfoTextArea;

	public DIYInfoRead(JFrame thisParentFrame, DIYProjectInfo theProjectInfo) {

		myProjectInfo = theProjectInfo;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setUpButtons();
		setUpLabels();
		setUpTextFields();
		setUpProjectInfoPanel();
		setUpMaterialInfoPanel();
		populateTextFields();
		
		setLocationRelativeTo(thisParentFrame);
		thisParentFrame.setEnabled(false);

	}

	private void setUpButtons() {

		addButton = new JButton("Add");
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
		myNameTextField.setMinimumSize(new Dimension(250, 100));
		myTotalCostTextField = new JTextField();
		myTotalCostTextField.setMinimumSize(new Dimension(250, 100));
		myPriorityTextField = new JTextField();
		myPriorityTextField.setMinimumSize(new Dimension(250, 100));
		myLengthTextField = new JTextField();
		myLengthTextField.setMinimumSize(new Dimension(250, 100));

		myNameTextField.setEditable(false);
		myTotalCostTextField.setEditable(false);
		myPriorityTextField.setEditable(false);
		myLengthTextField.setEditable(false);

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
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));

		for (int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			myMaterialInfoTextArea.setText(myProjectInfo.getMaterialList().get(i).toString());
		}
	}
}
