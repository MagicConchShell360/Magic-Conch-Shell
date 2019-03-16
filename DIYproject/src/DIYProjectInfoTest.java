import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DIYProjectInfoTest {

	@Test
	public void testSetName() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 2, mat);
		info.setName("New2Proj");
		assertTrue(info.getName() == "New2Proj");
	}
	
	@Test
	public void testSetPriority() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 2, mat);
		
		info.setPriority(3);
		assertTrue(info.getPriority() == 3);
	}
	
	
	@Test
	public void testGetName() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 2, mat);
		
		assertTrue(info.getName() == "New Proj");
	}
	
	@Test 
	public void testGetPriority() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 2, mat);
		
		assertTrue(info.getPriority() == 2);
	}
	
	
	@Test 
	public void testGetMaterialList() {
		ArrayList<DIYMaterialInfo> mat = new ArrayList<DIYMaterialInfo>();
		DIYProjectInfo info = new DIYProjectInfo("New Proj", 2, mat);
		
		assertTrue(info.getMaterialList() == mat);
	}

}
