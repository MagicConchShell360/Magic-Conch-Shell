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

	public DIYInfoRead(JFrame theParentFrame, DIYProjectInfo theProjectInfo) {
		super(theParentFrame);
		myProjectInfo = theProjectInfo;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUpComponents();
	}

	private void setUpButtons() {

		viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				int index = myJList.getSelectedIndex();
				DIYMaterialRead view = new DIYMaterialRead(myProjectInfo.getMaterialList().get(index),
															myParentFrame);
				view.setVisible(true);
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
		
		setPreferredSize(new Dimension(100, 100));
		myJList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myJList.setSelectedIndex(0);
	}

	private void setUpComponents() {
		
		JPanel northPanel = new JPanel(new GridLayout(8, 2));
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

	private void populateTextFields() {
		myNameTextField.setText(myProjectInfo.getName());
		myTotalCostTextField.setText(myProjectInfo.getTotalCost().toString());
		myPriorityTextField.setText(Integer.toString(myProjectInfo.getPriority()));
		myLengthTextField.setText(Double.toString(myProjectInfo.getLength()));
		for (int i = 0; i < myProjectInfo.getMaterialList().size(); i++) {
			myListDisplay.add(myProjectInfo.getMaterialList().get(i).getName());
		}
		myJList = new JList(myListDisplay.toArray());
	}

}
