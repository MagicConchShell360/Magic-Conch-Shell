import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

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
	
	public BigDecimal getTotalPrice() {
		return myPrice.multiply(BigDecimal.valueOf(myQuantity));
	}
	
	public BigDecimal getTotalLength() {
		return myLength.multiply(BigDecimal.valueOf(myQuantity));
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
	
	@Override 
	public String toString() {
		return "Name: " + getName() +
				" --- Price: $" + getPrice() +
				" --- Quantity: " + getQuantity() +
				" --- Length: " + getLength();
	}
}
