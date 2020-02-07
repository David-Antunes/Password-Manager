package Handler;
import Exceptions.AlreadyRegisteredException;
import Exceptions.AuthException;
import Exceptions.InvalidPasswordException;
import User.User;

public interface Handler {

	public User getUser();
	
	public void login(String email, String password) throws AuthException, InvalidPasswordException;
	
	public boolean loginPassword(String password);
	
	public void register(String name, String email, String password) throws AlreadyRegisteredException;
}
