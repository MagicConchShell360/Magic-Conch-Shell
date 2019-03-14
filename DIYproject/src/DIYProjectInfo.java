/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
 */

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Contains all information about a project
 * 
 * @author Joseph Joo
 */
public class DIYProjectInfo {
	private String myName;
	private int myPriority;
	private ArrayList<DIYMaterialInfo> myMaterialInfoList;

	/**
	 * DIYProjectInfo is the utility class for DIY Manager. This class contains all
	 * the pertinent information for the client's projects. DIYProjectInfo has
	 * several accessor and mutator methods that are passed by associated
	 * DIYInfoEdit, DIYInfoRead classes.
	 * 
	 * @author Joseph Joo
	 */
	public DIYProjectInfo(String theName, int thePriority, ArrayList<DIYMaterialInfo> theMaterialInfoList) {
		myName = theName;
		myPriority = thePriority;
		myMaterialInfoList = theMaterialInfoList;
	}

	/**
	 * @author Joseph Joo
	 */
	public void setName(String name) {
		myName = name;
	}

	/**
	 * @author Joseph Joo
	 */
	public void setPriority(int priority) {
		myPriority = priority;
	}

	/**
	 * @author Joseph Joo
	 */
	protected String getName() {
		return myName;
	}

	/**
	 * @author Kevin Santos
	 */
	protected BigDecimal getTotalCost() {
		BigDecimal totalCost = new BigDecimal(0);

		for (int i = 0; i < myMaterialInfoList.size(); i++) {
			totalCost = totalCost.add(myMaterialInfoList.get(i).getTotalPrice());
		}

		return totalCost;
	}

	/**
	 * @author Joseph Joo
	 */
	protected int getPriority() {
		return myPriority;
	}

	/**
	 * @author Kevin Santos
	 */
	protected BigDecimal getLength() {
		BigDecimal totalLength = new BigDecimal(0);

		for (int i = 0; i < myMaterialInfoList.size(); i++) {
			totalLength = totalLength.add(myMaterialInfoList.get(i).getTotalLength());
		}

		return totalLength;
	}

	/**
	 * @author Joseph Joo
	 */
	protected ArrayList<DIYMaterialInfo> getMaterialList() {
		return myMaterialInfoList;
	}

	/**
	 * @author Joseph Joo
	 */
	@Override
	public String toString() {
		return "Name: " + getName() +
				" --- Total Cost: $" + getTotalCost() +
				" --- Priority: " + getPriority() +
				" --- Length: " + getLength();
	}
}
