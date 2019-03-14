/*
 * Magic Conch Shell
 * Kevin Santos, Joseph Joo, Sally Ho
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
	 * 
	 * @author Kevin Santos
	 */
	public DIYVersionInfo() {

		myVersionInfo = "1.0";
		myDevelopers = new String[] { "Kevin Santos", "Joseph Joo", "Sally Ho" };

	}

	/**
	 * Returns the version information of the application.
	 * 
	 * @author Kevin Santos
	 */
	public String getMyVersionInfo() {
		return myVersionInfo;
	}

	/**
	 * Returns the name of the developers of the application.
	 * 
	 * @author Kevin Santos
	 */
	public String[] getMyDevelopers() {
		return myDevelopers;
	}
}
