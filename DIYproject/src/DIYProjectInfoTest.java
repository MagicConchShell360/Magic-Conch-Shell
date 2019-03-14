import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

/*
 * Author: Sally 
 * DIYProjectInfo JUnit test
 */
public class DIYProjectInfoTest {

	
	@Test
	public void testSetName() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												new BigDecimal(2.00), 2, 
												1.2, mat);
		info.setName("New New Proj");
		assertTrue(info.getName() == "New New Proj");
	}
	
	@Test
	public void testSetPriority() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												new BigDecimal(2.00), 2, 
												1.2, mat);
		info.setPriority(3);
		assertTrue(info.getPriority() == 3);
	}
	
	@Test
	public void testSetLength() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												new BigDecimal(2.00), 2, 
												1.2, mat);
		info.setLength(2.2);
		assertTrue(info.getLength() == 2.2);
	}
	
	@Test 
	public void testGetName() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												new BigDecimal(2.00), 2, 
												1.2, mat);
		assertTrue(info.getName() == "New Proj");
	}
	
	@Test 
	public void testGetCost() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		BigDecimal dec = new BigDecimal(2.00);
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												dec, 2, 
												1.2, mat);
		assertTrue(info.getTotalCost() == dec);
	}
	
	@Test 
	public void totalGetPriority() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												new BigDecimal(2.00), 2, 
												1.2, mat);
		assertTrue(info.getPriority() == 2);
	}
	
	@Test
	public void totalGetLength() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 
												new BigDecimal(2.00), 2, 
												1.2, mat);
		assertTrue(info.getLength() == 1.2);
	}
	
}
