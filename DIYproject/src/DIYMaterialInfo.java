import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DIYMaterialInfo {

	private String myName;
	private BigDecimal myPrice; 
	private BigDecimal myLength; 
	private int myQuantity;
	private ArrayList materialInfo;
	
	/*
	 * Constructor for all the material information 
	 */
	public DIYMaterialInfo(String theName, BigDecimal thePrice, int theQuantity,
							BigDecimal theLength, String theNotes) {
		myName = theName; 
		myPrice = thePrice;  
		myLength = theLength; 
		myQuantity = theQuantity;
		materialInfo = new ArrayList();
	}
	
	/*
	 * get methods for the material edits 
	 */
	public String getName() {
		return myName;
	}
	public BigDecimal getPrice() {
		return myPrice;
	}
	public int getQuantity() {
		return myQuantity;
	}
	public BigDecimal getLength() {
		return myLength;
	}
	
	/*
	 * set methods for material edit 
	 */
	public void setName(String theName) {
		myName = theName;
	}
	public void setPrice(BigDecimal thePrice) {
		myPrice = thePrice;
	}
	public void setQuantity(int theQuantity) {
		myQuantity = theQuantity;
	}
	public void setLength(BigDecimal theLength) {
		myLength = theLength;
	}
}
