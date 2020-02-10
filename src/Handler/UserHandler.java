package Handler;

import SessionsExceptions.InSessionException;

public interface UserHandler {

	/**
	 * Returns the current user in session. If there is no user than it will return
	 * null.
	 * 
	 * @return the name of the user
	 */
	public String getUser();

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
}
