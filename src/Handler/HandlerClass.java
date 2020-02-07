package Handler;
import java.util.HashMap;
import java.util.Map;

import Exceptions.AlreadyRegisteredException;
import Exceptions.AuthException;
import Exceptions.InvalidPasswordException;
import User.User;
import User.UserClass;

public class HandlerClass implements Handler {

	Map<String, User> users;
	User currentUser;

	public HandlerClass() {
		users = new HashMap<String, User>();
	}

	public User getUser() {
		return currentUser;
	}

	public void login(String email, String password) throws AuthException, InvalidPasswordException {
		currentUser = users.get(email);

		if (currentUser == null)
			throw new AuthException();

		if (!currentUser.getPassword().equals(password))
			throw new InvalidPasswordException();

	}

	public boolean loginPassword(String password) {

		if (!currentUser.getPassword().equals(password))
			return false;

		return true;
	}

	public void register(String name, String email, String password) throws AlreadyRegisteredException {
		if (users.get(email) != null)
			throw new AlreadyRegisteredException();

		User user = new UserClass(name, email, password);

		currentUser = user;
		users.put(user.getEmail(), user);
	}
}
