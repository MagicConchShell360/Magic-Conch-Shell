/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Sally Ho
 *
 */
public class DIYMaterialRead extends DIYTemplateV2 {
	
	/** eclipse generated serial */
	private static final long serialVersionUID = 832307186340559434L;
	//JLabels to display what I'm displaying. 
	private JLabel myNameLabel; 
	private JLabel myPriceLabel; 
	private JLabel myQuantityLabel; 
	private JLabel myLengthLabel;
	
	//JLabels to display the contents. 
	private JLabel myNameTitle;
	private JLabel myPriceTitle;
	private JLabel myQuantityTitle;
	private JLabel myLengthTitle; 
	
	//Misc Stuff 
	private DIYMaterialInfo myInfo;
	
	/**
	 * Constructor 
	 * 
	 * @author Sally Ho, Kevin Santos
	 */
	public DIYMaterialRead(JFrame theFrame, DIYMaterialInfo theInfo) {
		super(theFrame);
		addTexts();
		addJLabels();
		myInfo = theInfo; //constructing the material info. 
		
		populateTextFields();
	}
	
	/**
	 * @author Sally Ho
	 */
	private void addTexts() {
		myNameTitle = new JLabel("Material Name:");
		myNameTitle.setBorder(BorderFactory.createEtchedBorder());
		myNameLabel = new JLabel("name");
		
		myPriceTitle = new JLabel("Price: ");
		myPriceTitle.setBorder(BorderFactory.createEtchedBorder());
		myPriceLabel = new JLabel("price");
		
		myQuantityTitle = new JLabel("Quantity: ");
		myQuantityTitle.setBorder(BorderFactory.createEtchedBorder());
		myQuantityLabel = new JLabel("quantity");
		
		myLengthTitle = new JLabel("Length: ");
		myLengthTitle.setBorder(BorderFactory.createEtchedBorder());
		myLengthLabel = new JLabel("length");
	}
	
	
	/**
	 * helper method to add jlabels. 
	 * 
	 * @author Sally Ho
	 */
	private void addJLabels() {
		JPanel north = new JPanel(new GridLayout(4, 2));
		
		north.add(myNameTitle);
		north.add(myNameLabel);
		
		north.add(myPriceTitle);
		north.add(myPriceLabel);
		
		north.add(myQuantityTitle);
		north.add(myQuantityLabel);
		
		north.add(myLengthTitle);
		north.add(myLengthLabel);
		
		myCenterPanel.setLayout(new BorderLayout());
		myCenterPanel.add(north, BorderLayout.NORTH);
	}
	
	/**
	 * populate the fields
	 * 
	 * @author Sally Ho
	 */
	public void populateTextFields() {
		myNameLabel.setText(myInfo.getName());
		myPriceLabel.setText(myInfo.getPrice().toString());
		myQuantityLabel.setText(Integer.toString(myInfo.getQuantity()));
		myLengthLabel.setText(myInfo.getLength().toString());
	}
}
