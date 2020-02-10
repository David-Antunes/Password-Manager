package Handler;

import java.util.Iterator;
import java.util.List;

import Program.Program;
import SessionsExceptions.InSessionException;
import SessionsExceptions.NoProgramException;
import SessionsExceptions.NotInSessionException;

public interface UserHandler {

	/**
	 * Returns the current user in session. If there is no user than it will return
	 * null.
	 * 
	 * @return the name of the user
	 */
	public String getUser();

	/**
	 * Clears the current user in Session
	 */
	public void clearSession();

	/**
	 * Logins the stored user into the program. Having a user in session unlocks new
	 * functions that can be used. Returns true if the operation is successful,
	 * false if there is no user with the given email or an incorrect password.
	 * 
	 * @param email    - email of the user that wants to log in
	 * @param password - the user password
	 * @return true if it is a valid email and password, false otherwise
	 * @throws InSessionException if there is already a user logged in
	 */
	public boolean login(String email, String password) throws InSessionException;

	/**
	 * Registers a new user into the program. To unlock new operations it is
	 * required to login() into the program with the same credentials used when
	 * registering. Returns true if the operation is successful, false if there is
	 * already a new email registered.
	 * 
	 * @param name     - name of the user
	 * @param email    - email of the user
	 * @param password - password of the user
	 * @return true if it is a non-existing email, false otherwise
	 * @throws InSessionException if there is already a user logged in
	 */
	public boolean register(String name, String email, String password) throws InSessionException;

	/**
	 * Adds a new program to the user.
	 * 
	 * @param name     - name of the program
	 * @param id       - id of the program
	 * @param password - password of the program
	 * @param extra    - extra parameters necessary to the program
	 * @throws NotInSessionException if there is no user logged in
	 */
	public void addProgram(String name, String id, String password, String[] extra) throws NotInSessionException;

	/**
	 * Removes a program present in the user.
	 * 
	 * @param name - name of the program
	 * @param id   - id of the program
	 * @throws NotInSessionException if there is no user logged in
	 * @throws NoProgramException    if there is no program registered
	 */
	public void removeProgram(String name, String id) throws NotInSessionException, NoProgramException;

	/**
	 * Returns an iterator with all the programs. It is necessary to save each list
	 * from the iterator to iterate all the different ids present in the same
	 * program.
	 * 
	 * @return An iterator with the different programs and ids.
	 * @throws NotInSessionException if there is no user logged in
	 * @throws NoProgramException    if there is no program registered
	 */
	public Iterator<List<Program>> getAllPrograms() throws NotInSessionException, NoProgramException;

	/**
	 * Returns an iterator with the programs with the same name.
	 * 
	 * @param progName - name of the program
	 * @return an iterator with the programs with the same name.
	 * @throws NotInSessionException if there is no user logged in
	 * @throws NoProgramException    if there is no program registered
	 */
	public Iterator<Program> getProgram(String progName) throws NotInSessionException, NoProgramException;

	/**
	 * Loads the data from the given name file
	 * 
	 * @param name - name of the file
	 */
	public void loadUserData(String name);

	/**
	 * Writes the user data to the given name file
	 * 
	 * @param name - name of the file
	 */
	public void writeUserData(String name);

}
