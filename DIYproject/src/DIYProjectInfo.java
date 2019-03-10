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
	public DIYProjectInfo(String thisName, BigDecimal thisCost, int thisPriority, double thisLength, ArrayList<DIYMaterialInfo> theMaterialInfoList) {
		myName = "";
		myTotalCost = new BigDecimal(0);
		myPriority = 0;
		myLength = 0.0;
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
		String projectInfo = "";
		StringBuilder sb = new StringBuilder();
		
		sb.append("Project Name: " + getName());
		sb.append("\tTotal Cost: " + getTotalCost());
		sb.append("\tPriority: " + getPriority());
		sb.append("\tLength: " + getLength());
		
		return projectInfo;
		
	}
}
