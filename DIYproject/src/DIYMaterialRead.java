import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class DIYMaterialRead extends DIYTemplate {
	private JLabel myNameLabel; 
	private JLabel myPriceLabel; 
	private JLabel myQuantityLabel; 
	private JLabel myLengthLabel;
	
	private JLabel myNameTitle;
	private JLabel myPriceTitle;
	private JLabel myQuantityTitle;
	private JLabel myLengthTitle; 
	
	private JFrame myParentFrame; 
	private JButton myButton;
	private DIYMaterialInfo myInfo;
	
	public DIYMaterialRead(DIYMaterialInfo theInfo, JFrame theFrame) {
		myNameTitle = new JLabel("Material Name:");
		myNameTitle.setBorder(BorderFactory.createEtchedBorder());
		myNameTitle.setVerticalAlignment(JLabel.TOP);
		myNameLabel = new JLabel("name");
		
		myPriceTitle = new JLabel("Price: ");
		myPriceTitle.setBorder(BorderFactory.createEtchedBorder());
		myPriceTitle.setVerticalAlignment(JLabel.BOTTOM);
		myPriceLabel = new JLabel("price");
		
		myQuantityTitle = new JLabel("Quantity: ");
		myQuantityTitle.setBorder(BorderFactory.createEtchedBorder());
		myQuantityLabel = new JLabel("quantity");
		
		myLengthTitle = new JLabel("Length: ");
		myLengthTitle.setBorder(BorderFactory.createEtchedBorder());
		myLengthLabel = new JLabel("length");
		
		addJLabels();
		myInfo = theInfo; //constructing the material info. 
		
		myParentFrame = theFrame;
	}
	
	/*
	 * helper method to add jlabels. 
	 */
	public void addJLabels() {
		myCenterPanel.add(myNameTitle);
		myCenterPanel.add(myNameLabel);
		
		myCenterPanel.add(myPriceTitle);
		myCenterPanel.add(myPriceLabel);
		
		myCenterPanel.add(myQuantityTitle);
		myCenterPanel.add(myQuantityLabel);
		
		myCenterPanel.add(myLengthTitle);
		myCenterPanel.add(myLengthLabel);
	}
	
	/*
	 * populate the fields 
	 */
	public void populateTextFields() {
		myNameLabel.setText(myInfo.getName());
		myPriceLabel.setText(myInfo.getPrice().toString());
		myQuantityLabel.setText(Integer.toString(myInfo.getQuantity()));
		myLengthLabel.setText(myInfo.getLength().toString());
		
	}
}
