package Program;

public interface Program {

	/**
	 * Returns the name of the program
	 * 
	 * @return the name of the program
	 */
	public String getName();

	/**
	 * Returns the id of the program
	 * 
	 * @return the id of the program
	 */
	public String getID();

	/**
	 * Returns the extra description of the program
	 * 
	 * @return the extra description of the program
	 */
	public String[] getExtra();

	/**
	 * Returns the password of the program
	 * 
	 * @return the password of the program
	 */
	public String getPassword();
}
