/*
 * Magic Conch Shell
 * TCSS 360
 */

/**
 * Storage class for the application information.
 * 
 * @author Kevin Santos
 */
public class DIYVersionInfo {

	/** Stores the version information. */
	private String myVersionInfo;
	
	/** Stores the developer names. */
	private String[] myDevelopers;

	/**
	 * Initiates DIYVersionInfo with current version and the developer names
	 */
	public DIYVersionInfo() {
		
		myVersionInfo = "1.0";
		myDevelopers = new String[] {"Kevin Santos",
									 "Joseph Joo",
									 "Sally Ho"};
		
	}
	
	/**
	 * Returns the version information of the application.
	 * 
	 * @return
	 */
	public String getMyVersionInfo() {
		return myVersionInfo;
	}

	/**
	 * Returns the name of the developers of the application.
	 * 
	 * @return
	 */
	public String[] getMyDevelopers() {
		return myDevelopers;
	}
}
