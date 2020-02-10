package User;

public interface UserModifier extends User {

	/**
	 * Adds a new program to the user.
	 * 
	 * @param name     - name of the program
	 * @param ID       - id of the program
	 * @param extra    - extra description of the program
	 * @param password - password of the program
	 */
	void add(String name, String ID, String[] extra, String password);

	/**
	 * Removes a program from the user
	 * 
	 * @param name - name of the program
	 * @param ID   - id of the program
	 */
	void remove(String name, String ID);
}
