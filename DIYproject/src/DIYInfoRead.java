import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class DIYInfoRead extends DIYTemplate {

	private static final long serialVersionUID = -8160056479228037385L;
	private DIYProjectInfo myProjectInfo;

	private JFrame myParentFrame;
	
	private JButton backButton;
	private JButton addButton;

	private JLabel myNameLabel;
	private JLabel myCostLabel;
	private JLabel myPriorityLabel;
	private JLabel myLengthLabel;

	private JTextField myNameTextField;
	private JTextField myTotalCostTextField;
	private JTextField myPriorityTextField;
	private JTextField myLengthTextField;
	private JList<DIYMaterialInfo> myMaterialInfoJList;

	public DIYInfoRead(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {

		myParentFrame = theParentFrame;
		myProjectInfo = theProjectInfo;
		myMaterialInfoJList = new JList<>();
		
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
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				myParentFrame.setEnabled(true);
				if (isVisible()) setVisible(false);
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

		myNameTextField.setEditable(false);
		myTotalCostTextField.setEditable(false);
		myPriorityTextField.setEditable(false);
		myLengthTextField.setEditable(false);

	}

	private void setUpComponents() {

		myCenterPanel.add(myNameLabel, 0);
		myCenterPanel.add(myNameTextField, 1);

		myCenterPanel.add(myCostLabel, 2);
		myCenterPanel.add(myTotalCostTextField, 3);

		myCenterPanel.add(myPriorityLabel, 4);
		myCenterPanel.add(myPriorityTextField, 5);

		myCenterPanel.add(myLengthLabel, 6);
		myCenterPanel.add(myLengthTextField, 7);
		
		myCenterPanel.add(addButton);

	}

	private void populateTextFields() {
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));

		for (int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			
		}
	}
	
}
