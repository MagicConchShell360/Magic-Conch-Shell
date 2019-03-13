import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DIYMaterialRead extends DIYTemplate {
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
	
	//JButtons to allow users to edit. 
	private JButton addMaterialButton; 
	private JButton removeMaterialButton; 
	private JButton editButton; 
	
	//Misc Stuff 
	private JFrame myParentFrame; 
	private DIYMaterialInfo myInfo;
	
	/*
	 * Constructor 
	 */
	public DIYMaterialRead(DIYMaterialInfo theInfo, JFrame theFrame) {
		addTexts();
		addJLabels();
		myInfo = theInfo; //constructing the material info. 
		
		myParentFrame = theFrame;
	}
	
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
	
	
	/*
	 * helper method to add jlabels. 
	 */
	private void addJLabels() {
		JPanel north = new JPanel(new GridLayout(8, 2));
		JPanel south = new JPanel(new GridBagLayout());
		
		north.add(myNameTitle);
		north.add(myNameLabel);
		
		north.add(myPriceTitle);
		north.add(myPriceLabel);
		
		north.add(myQuantityTitle);
		north.add(myQuantityLabel);
		
		north.add(myLengthTitle);
		north.add(myLengthLabel);
		
		addMaterialButton = new JButton("Add");
		editButton = new JButton("Edit");
		removeMaterialButton = new JButton("Remove");
		
		south.add(addMaterialButton);
		south.add(editButton);
		south.add(removeMaterialButton);
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
