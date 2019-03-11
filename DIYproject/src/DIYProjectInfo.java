import java.math.BigDecimal;
import java.util.ArrayList;

public class DIYProjectInfo {
	private String myName;
	private BigDecimal myTotalCost;
	private int myPriority;
	private double myLength;
	private ArrayList<DIYMaterialInfo> myMaterialInfoList;
	
	/**
	 * DIYProjectInfo is the utility class for DIY Manager. This class contains
	 * all the pertinent information for the client's projects. DIYProjectInfo
	 * has several accessor and mutator methods that are passed by associated
	 * DIYInfoEdit, DIYInfoRead classes.
	 * 
	 * @param theMaterialInfoList
	 */
	public DIYProjectInfo(String theName, BigDecimal theCost, 
						  int thePriority, double theLength, 
						  ArrayList<DIYMaterialInfo> theMaterialInfoList) {
		myName = theName;
		myTotalCost = theCost;
		myPriority = thePriority;
		myLength = theLength;
		myMaterialInfoList = theMaterialInfoList;
	}

	public void setName(String name) {
		myName = name;
	}

	public void setPriority(int priority) {
		myPriority = priority;
	}

	public void setLength(double length) {
		myLength = length;
	}

	protected String getName() {
		return myName;
	}

	protected BigDecimal getTotalCost() {
		return myTotalCost;
	}

	protected int getPriority() {
		return myPriority;
	}

	protected double getLength() {
		return myLength;
	}

	protected ArrayList<DIYMaterialInfo> getMaterialList() {
		return myMaterialInfoList;
	}
	
	@Override
	public String toString() {
		return "Project Name: " + getName() +
				" --- TotalCost: " + getTotalCost() +
				" --- Priority: " + getPriority() +
				" --- Length: " + getLength();
	}
}
