package User;

import SessionsExceptions.NoProgramException;

public interface UserModifier extends User {

	/**
	 * Adds a new program to the user. It is possible to add the same program over
	 * and over.
	 * 
	 * @param name     - name of the program
	 * @param ID       - id of the program
	 * @param extra    - extra description of the program
	 * @param password - password of the program
	 */
	void add(String name, String id, String password, String[] extra);

	/**
	 * Removes a program from the user. If there is more than one program with the
	 * same information, it will remove the first added.
	 * 
	 * @param name - name of the program
	 * @param ID   - id of the program
	 * @throws NoProgramException when its a invalid name or id
	 */
	void remove(String name, String id) throws NoProgramException;
}
