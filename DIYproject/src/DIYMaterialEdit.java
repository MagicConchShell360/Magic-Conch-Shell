import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DIYMaterialEdit extends DIYTemplateV2 {
	private JTextField myNameField;
	private JTextField myPriceField; 
	private JTextField myLengthField;
	private JTextField myQuantityField; 
	
	private JLabel myNameTitle;
	private JLabel myPriceTitle;
	private JLabel myQuantityTitle;
	private JLabel myLengthTitle;
	
	private JButton mySaveButton; 
	
	private ArrayList<DIYMaterialInfo> myList;
	private DIYMaterialInfo myInfo; 
	
	private String myNameInput;
	private BigDecimal myPriceInput;
	private int myQuantityInput; 
	private BigDecimal myLengthInput;
	
	private boolean isAdd;
	
	//takes in a list 
	public DIYMaterialEdit(JFrame theFrame, ArrayList<DIYMaterialInfo> theList) {
		super(theFrame);
		myList = theList;
		isAdd = true;
		myInfo = new DIYMaterialInfo("", BigDecimal.valueOf(1), 1, BigDecimal.valueOf(1));
		
		
		setUpSaveButton();
		setJLabels();
		setJTextFields();
		addToCenter();
		populateBlankText();
		
		
	}

	public DIYMaterialEdit(JFrame theFrame, DIYMaterialInfo theInfo) {
		super(theFrame);
		myInfo = theInfo; 
		isAdd = false;
		setUpSaveButton();
		setJLabels();
		setJTextFields();
		addToCenter();
		populateText();
		
		
	}
	
	private void setUpSaveButton() {
		mySaveButton = new JButton("Save");
		mySaveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (isAdd) {

					myInfo.setName(myNameField.getText());
					myInfo.setPrice(BigDecimal.valueOf(Double.valueOf(myPriceField.getText())));
					myInfo.setQuantity(Integer.valueOf(myQuantityField.getText()));
					myInfo.setLength(BigDecimal.valueOf(Double.valueOf(myLengthField.getText())));
					
					myList.add(myInfo);
					
					((DIYInfoEdit) myParentFrame).refresh();
					
				} else {
					
					myInfo.setName(myNameField.getText());
					myInfo.setPrice(BigDecimal.valueOf(Double.valueOf(myPriceField.getText())));
					myInfo.setQuantity(Integer.valueOf(myQuantityField.getText()));
					myInfo.setLength(BigDecimal.valueOf(Double.valueOf(myLengthField.getText())));
					((DIYInfoEdit) myParentFrame).refresh();
					
					
				}
				
				
			}
		});
	}
	
	/*
	 * Constructor Helper method: Set the borders and the titles for the information. 
	 */
	private void setJLabels() {
		myNameTitle = new JLabel("Material Name:");
		myNameTitle.setBorder(BorderFactory.createEtchedBorder());
		myPriceTitle = new JLabel("Price: ");
		myPriceTitle.setBorder(BorderFactory.createEtchedBorder());
		myQuantityTitle = new JLabel("Quantity: ");
		myQuantityTitle.setBorder(BorderFactory.createEtchedBorder());
		myLengthTitle = new JLabel("Length: ");
		myLengthTitle.setBorder(BorderFactory.createEtchedBorder());		
	}
	
	/*
	 * Constructor Helper method: initialize the text fields. 
	 */
	private void setJTextFields() {
		myNameField = new JTextField();
		myNameField.setEditable(true);
		myPriceField = new JTextField();
		myPriceField.setEditable(true);
		myLengthField = new JTextField();
		myLengthField.setEditable(true);
		myQuantityField = new JTextField();
		myQuantityField.setEditable(true);
	}
	
	/*
	 * Constructor Helper method: add the JLabels to the panel. 
	 */
	private void addToCenter() {
		JPanel north = new JPanel(new GridLayout(4,2));
		JPanel south = new JPanel(new GridBagLayout());
		
		north.add(myNameTitle);
		north.add(myNameField);
		
		north.add(myPriceTitle);
		north.add(myPriceField);
		
		north.add(myQuantityTitle);
		north.add(myQuantityField);
		
		north.add(myLengthTitle);
		north.add(myLengthField);
		
		south.add(mySaveButton);
		
		myCenterPanel.setLayout(new BorderLayout());
		myCenterPanel.add(north, BorderLayout.NORTH);
		myCenterPanel.add(mySaveButton, BorderLayout.SOUTH);
	}
	
	/*
	 * Getting input from the text and storing them as variables. 
	 */
	public void populateText() { //make this with a save button 
		myNameField.setText(myInfo.getName());
		myPriceField.setText(myInfo.getPrice().toString());
		myQuantityField.setText(Integer.toString(myInfo.getQuantity()));
		myLengthField.setText(myInfo.getLength().toString());
	}
	
	public void populateBlankText() { //make this with a save button 
		myNameField.setText("Material Name");
		myPriceField.setText("1");
		myQuantityField.setText("1");
		myLengthField.setText("1");
	}
	
	//upSet = update/ Set
	public void upSetName() {
		myInfo.setName(myNameInput);
	}
	
	public void upSetPrice() {
		myInfo.setPrice(myPriceInput);
	}
	
	public void upSetQuantity() {
		myInfo.setQuantity(myQuantityInput);
	}
	
	public void upSetLength() {
		myInfo.setLength(myLengthInput);
	}
	
}
