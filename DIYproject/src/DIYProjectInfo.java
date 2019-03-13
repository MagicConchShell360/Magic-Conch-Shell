import java.math.BigDecimal;
import java.util.ArrayList;

public class DIYProjectInfo {
	private String myName;
	private BigDecimal myTotalCost;
	private int myPriority;
	private BigDecimal myTotalLength;
	private ArrayList<DIYMaterialInfo> myMaterialInfoList;
	
	/**
	 * DIYProjectInfo is the utility class for DIY Manager. This class contains
	 * all the pertinent information for the client's projects. DIYProjectInfo
	 * has several accessor and mutator methods that are passed by associated
	 * DIYInfoEdit, DIYInfoRead classes.
	 * 
	 * @param theMaterialInfoList
	 */
	
	public DIYProjectInfo(String theName, int thePriority, ArrayList<DIYMaterialInfo> theMaterialInfoList) {
		myName = theName;
		myTotalCost = new BigDecimal(0);
		myPriority = thePriority;
		myTotalLength = new BigDecimal(0);
		myMaterialInfoList = theMaterialInfoList;
	}

	public void setName(String name) {
		myName = name;
	}

	public void setPriority(int priority) {
		myPriority = priority;
	}

	protected String getName() {
		return myName;
	}

	protected BigDecimal getTotalCost() {
		BigDecimal totalCost = new BigDecimal(0);
		BigDecimal price = new BigDecimal(0);
		BigDecimal qty = new BigDecimal(0);
		
		for (int i = 0; i < myMaterialInfoList.size(); i++) {
			qty.add(new BigDecimal(myMaterialInfoList.get(i).getQuantity()));
			price.add(myMaterialInfoList.get(i).getPrice());
			price.multiply(qty);
			qty.setScale(0);
			price.setScale(0);
			totalCost.add(price);
		}
		
		return totalCost;
	}

	protected int getPriority() {
		return myPriority;
	}

	protected BigDecimal getLength() {
		BigDecimal length = new BigDecimal(0);
		for (int i = 0; i < myMaterialInfoList.size(); i++) {
			length.add(myMaterialInfoList.get(i).getLength());
		}
		return length;
		
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
