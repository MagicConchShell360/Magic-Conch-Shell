import java.math.BigDecimal;
import java.util.List;

public class DIYProjectInfo {
	private String myName;
	private BigDecimal myTotalCost;
	private int myPriority;
	private double myLength;
	private List myMaterialList;
	
	public DIYProjectInfo() {
		myName = "";
		myTotalCost = new BigDecimal(0);
		myPriority = 0;
		myLength = 0.0;
		//TODO FIX Me!! myMaterialList = new List()<>;
		
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
	
}
