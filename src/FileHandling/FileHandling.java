package FileHandling;
import java.io.FileNotFoundException;

import User.User;

public interface FileHandling {

	/**
	 * Verifies if the given email is present in the file called LogUsers.txt. If
	 * the file does not exist it will be created a the email is written.
	 * 
	 * @param email - user email
	 * @return true if it is present, false otherwise
	 */
	public boolean verifyEmail(String email) throws FileNotFoundException;
	public User getUser();
	public User getUser(String email);
	public void setRegisteredUser(User user);
	
	public void logEmail(String email);

	public void saveUser();

}
