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

public class DIYMaterialEdit extends DIYTemplate{
	private JTextField myNameField;
	private JTextField myPriceField; 
	private JTextField myLengthField;
	private JTextField myQuantityField; 
	
	private JLabel myNameTitle;
	private JLabel myPriceTitle;
	private JLabel myQuantityTitle;
	private JLabel myLengthTitle;
	
	private JButton myAddButton; 
	private JButton myEditButton; 
	private JButton myRemoveButton; 
	
	private ArrayList<DIYMaterialInfo> myList;
	private DIYMaterialInfo myInfo; 
	
	private String myNameInput;
	private BigDecimal myPriceInput;
	private int myQuantityInput; 
	private BigDecimal myLengthInput;
	
	private JFrame myParentFrame;
	
	//takes in a list 
	public DIYMaterialEdit(ArrayList<DIYMaterialInfo> theList) {
		myList = theList;
		
	}
	
	public DIYMaterialEdit(JFrame theFrame) {
		myParentFrame = theFrame;
		setJLabels();
		setJTextFields();
		addToCenter();
	}
	
	public DIYMaterialEdit(DIYMaterialInfo theInfo, JFrame theFrame) {
		myInfo = theInfo; 
		myNameInput = "";
		myPriceInput = new BigDecimal(0);
		myQuantityInput = 0; 
		myLengthInput = new BigDecimal(0);
		myParentFrame = theFrame;
		
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
		JPanel north = new JPanel(new GridLayout(8,2));
		JPanel south = new JPanel(new GridBagLayout());
		
		north.add(myNameTitle);
		north.add(myNameField);
		
		north.add(myPriceTitle);
		north.add(myPriceField);
		
		north.add(myQuantityTitle);
		north.add(myQuantityField);
		
		north.add(myLengthTitle);
		north.add(myLengthField);
		
		south.add(myAddButton = new JButton("Add"));
		south.add(myEditButton = new JButton("Edit"));
		south.add(myRemoveButton = new JButton("Remove"));
		
	}
	
	/*
	 * Getting input from the text and storing them as variables. 
	 */
	public void populateText() { //make this with a save button 
		myNameInput = myNameField.getText();
		myPriceInput = new BigDecimal(myPriceField.getText());
		myQuantityInput = Integer.parseInt(myQuantityField.getText());
		myLengthInput = new BigDecimal(myLengthField.getText());
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
