/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for DIYMaterialInfo utility class.
 * Test for accessors and mutators.
 * 
 * @author Joseph Joo
 *
 */
public class DIYMaterialInfoTest {
	DIYMaterialInfo mat;
	String testName;
	BigDecimal testPrice;
	int testQty;
	BigDecimal testLength;
	
	/**
	 * Setup the temporary global DIYMaterialInfo variables
	 * before the start of each test.
	 * 
	 * @author Joseph Joo
	 */
	@Before
	public void setUp() {
		testName = "testMaterial";
		testPrice = new BigDecimal(4.75);
		testQty = 5;
		testLength = new BigDecimal(1.25);
		
		mat = new DIYMaterialInfo(
				testName, testPrice, testQty, testLength);
	}
	
	/**
	 * Asserts the DIYMaterialInfo is instantiated.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testDefaultConstructorNotNull() {
		assertNotNull(mat);
	}
	
	/**
	 * Tests the getter for the material name.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testGetName() {
		assertEquals(testName, mat.getName());
	}
	
	/**
	 * Tests the getter for the material price.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testGetPrice() {
		assertEquals(testPrice, mat.getPrice());
	}
	
	/**
	 * Tests the getter for the material quantity.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testGetQuantity() {
		assertEquals(testQty, mat.getQuantity());
	}
	
	/**
	 * Tests the getter for the material length.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testGetLength() {
		assertEquals(testLength, mat.getLength());
	}
	
	/**
	 * Tests the setter for the material price.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testSetName() {
		String newName = "Window";
		mat.setName(newName);
		assertEquals(newName, mat.getName());
	}
	
	
	/**
	 * Tests the setter for the material price.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testSetPrice() {
		BigDecimal newPrice = new BigDecimal(5.55);
		mat.setPrice(newPrice);
		assertEquals(newPrice, mat.getPrice());
	}
	
	
	/**
	 * Tests the setter for the material quantity.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testSetQuantity() {
		int newQty = 7;
		mat.setQuantity(newQty);
		assertEquals(newQty, mat.getQuantity());
	}
	
	
	/**
	 * Tests the setter for the material length.
	 * 
	 * @author Joseph Joo
	 */
	@Test
	public void testSetLength() {
		BigDecimal newLen = new BigDecimal(11.11);
		mat.setLength(newLen);
		assertEquals(newLen, mat.getLength());
	}
}
