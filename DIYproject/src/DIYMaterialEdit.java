import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DIYMaterialEdit extends DIYTemplate{
	private JTextField myNameField;
	private JTextField myPriceField; 
	private JTextField myLengthField;
	private JTextField myQuantityField; 
	
	private JLabel myNameTitle;
	private JLabel myPriceTitle;
	private JLabel myQuantityTitle;
	private JLabel myLengthTitle;
	
	private ArrayList<DIYMaterialInfo> myList;
	private DIYMaterialInfo myInfo; 
	
	private String myNameInput;
	private BigDecimal myPriceInput;
	private int myQuantityInput; 
	private BigDecimal myLengthInput;
	
	//takes in a list 
	public DIYMaterialEdit(ArrayList<DIYMaterialInfo> theList, DIYMaterialInfo theInfo) {
		myList = theList;
		myInfo = theInfo; 
		setJLabels();
		setJTextFields();
		addToCenter();
		myNameInput = "";
		myPriceInput = new BigDecimal(0);
		myQuantityInput = 0; 
		myLengthInput = new BigDecimal(0);
	}
	
	/*
	 * Constructor Helper method: Set the borders and the titles for the information. 
	 */
	public void setJLabels() {
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
	public void setJTextFields() {
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
	public void addToCenter() {
		myCenterPanel.add(myNameTitle);
		myCenterPanel.add(myNameField);
		
		myCenterPanel.add(myPriceTitle);
		myCenterPanel.add(myPriceField);
		
		myCenterPanel.add(myQuantityTitle);
		myCenterPanel.add(myQuantityField);
		
		myCenterPanel.add(myLengthTitle);
		myCenterPanel.add(myLengthField);
	}
	
	public void populateText() {
		myNameInput = myNameField.getText();
		myPriceInput = new BigDecimal(myPriceField.getText());
		myQuantityInput = Integer.parseInt(myQuantityField.getText());
		myLengthInput = new BigDecimal(myLengthField.getText());
		
	}
	
	
}
