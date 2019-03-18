/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import java.math.BigDecimal;

/**
 * 
 * @author Sally Ho
 */
public class DIYMaterialInfo {

	private String myName;
	private BigDecimal myPrice; 
	private BigDecimal myLength; 
	private int myQuantity;

	/**
	 * Constructor for all the material information 
	 * 
	 * @author Sally Ho
	 */
	public DIYMaterialInfo(String theName, BigDecimal thePrice, int theQuantity,
							BigDecimal theLength) {
		myName = theName; 
		myPrice = thePrice;  
		myLength = theLength; 
		myQuantity = theQuantity;
	}
	
	/**
	 * @author Sally Ho
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * @author Sally Ho
	 */
	public BigDecimal getPrice() {
		return myPrice;
	}
	
	/**
	 * @author Sally Ho
	 */
	public int getQuantity() {
		return myQuantity;
	}
	
	/**
	 * @author Sally Ho
	 */
	public BigDecimal getLength() {
		return myLength;
	}
	
	/**
	 * @author Sally Ho
	 */
	public BigDecimal getTotalPrice() {
		return myPrice.multiply(BigDecimal.valueOf(myQuantity));
	}
	
	/**
	 * @author Sally Ho
	 */
	public BigDecimal getTotalLength() {
		return myLength.multiply(BigDecimal.valueOf(myQuantity));
	}
	
	/**
	 * @author Sally Ho
	 */
	public void setName(String theName) {
		myName = theName;
	}
	
	/**
	 * @author Sally Ho
	 */
	public void setPrice(BigDecimal thePrice) {
		myPrice = thePrice;
	}
	
	/**
	 * @author Sally Ho
	 */
	public void setQuantity(int theQuantity) {
		myQuantity = theQuantity;
	}
	
	/**
	 * @author Sally Ho
	 */
	public void setLength(BigDecimal theLength) {
		myLength = theLength;
	}
	
	/**
	 * @author Sally Ho
	 */
	@Override 
	public String toString() {
		return "Name: " + getName() +
				" --- Price: $" + getPrice() +
				" --- Quantity: " + getQuantity() +
				" --- Length: " + getLength();
	}
}
