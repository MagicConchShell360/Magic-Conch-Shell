import java.awt.BorderLayout;

public class DIYMaterialRead extends DIYTemplate {
	private JLabel myNameLabel; 
	private JLabel myPriceLabel; 
	private JLabel myQuantityLabel; 
	private JLabel myLengthLabel;
	private ArrayList<DIYMaterialInfo> myList;
	
	
	public DIYMaterialRead(ArrayList theList) {
		myNameLabel = new JLabel();
		myPriceLabel = new JLabel();
		myQuantityLabel = new JLabel();
		myLengthLabel = new JLabel();
		addJLabels();
		myList = new ArrayList<>;
		myList = theList; 
	}
	
	/*
	 * helper method to add jlabels. 
	 */
	public void addJLabels() {
		myCenterPanel.add(myNameLabel);
		myCenterPanel.add(myPriceLabel);
		myCenterPanel.add(myQuantityLabel);
		myCenterPanel.add(myLengthLabel);
	}
	
	/*
	 * populate the fields 
	 */
	public void populateTextFields() {
		//myInfo is the list. 
		myNameLabel.setText(theList.setName());
		myPriceLabel.setText(theList.setPrice());
		myQuantityLabel.setText(theList.setQuantity());
		myLengthLabel.setText(theList.setLength());
	}
}
