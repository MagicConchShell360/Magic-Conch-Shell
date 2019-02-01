public class DIYVersionInfo {

	private String myVersionInfo;
	private String[] myDeveloperNames;
	
	public DIYVersionInfo() {
		myVersionInfo = "1.0";
		myDeveloperNames = new String[]{"Kevin Santos", "Sally Ho", "Joseph Joo"};
	}
	
	public String getMyVersionInfo() {
		return myVersionInfo;
	}
	public void setMyVersionInfo(String myVersionInfo) {
		this.myVersionInfo = myVersionInfo;
	}
	public String[] getMyDeveloperNames() {
		return myDeveloperNames;
	}
	public void setMyDeveloperNames(String[] myDeveloperNames) {
		this.myDeveloperNames = myDeveloperNames;
	}
}
