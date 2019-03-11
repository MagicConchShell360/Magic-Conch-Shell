import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class DIYInfoRead extends DIYTemplateV2 {

	private static final long serialVersionUID = -8160056479228037385L;
	private DIYProjectInfo myProjectInfo;
	private JFrame myParentFrame;

	private JButton addButton;

	private JLabel myNameLabel;
	private JLabel myCostLabel;
	private JLabel myPriorityLabel;
	private JLabel myLengthLabel;

	private JTextField myNameTextField;
	private JTextField myTotalCostTextField;
	private JTextField myPriorityTextField;
	private JTextField myLengthTextField;
	private JList<DIYMaterialInfo> myJList;

	public DIYInfoRead(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		myProjectInfo = theProjectInfo;
		setUpComponents();
	}

	private void setUpButtons() {

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				DIYMaterialInfo materialInfo = new DIYMaterialInfo("Material", new BigDecimal(7), 7, new BigDecimal(7));
				// TODO FIX ME!!!
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

	private void setUpMaterialList() {
		myJList = new JList();
	}

	private void setUpComponents() {

		myCenterPanel.setLayout(new GridLayout(8, 2));

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setUpButtons();
		setUpLabels();
		setUpTextFields();

		myCenterPanel.add(myNameLabel);
		myCenterPanel.add(myNameTextField);

		myCenterPanel.add(myCostLabel);
		myCenterPanel.add(myTotalCostTextField);

		myCenterPanel.add(myPriorityLabel);
		myCenterPanel.add(myPriorityTextField);

		myCenterPanel.add(myLengthLabel);
		myCenterPanel.add(myLengthTextField);

		myCenterPanel.add(addButton);
		populateTextFields();
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
