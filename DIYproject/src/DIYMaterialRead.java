import java.awt.BorderLayout;

public class DIYMaterialRead extends DIYTemplate {
	private JLabel myNameLabel; 
	private JLabel myPriceLabel; 
	private JLabel myQuantityLabel; 
	private JLabel myLengthLabel;
	private DIYMaterialInfo myInfo;
	
	public DIYMaterialRead() {
		myNameLabel = new JLabel();
		myPriceLabel = new JLabel();
		myQuantityLabel = new JLabel();
		myLengthLabel = new JLabel();
		addJLabels();
		myInfo = new DIYMaterialInfo();
	}
	
	/*
	 * helper method to 
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
		myNameLabel.setText(myInfo.materialInfo.setName());
		myPriceLabel.setText(myInfo.materialInfo.setPrice());
		myQuantityLabel.setText(myInfo.materialInfo.setQuantity());
		myLengthLabel.setText(myInfo.materialInfo.setLength());
	}
}
