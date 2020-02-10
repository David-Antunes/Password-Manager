package Handler;

import java.util.HashMap;
import java.util.Map;

import SessionsExceptions.InSessionException;
import User.User;
import User.UserClass;

public class UserHandlerClass implements UserHandler {

	private static final int MIN_USERS = 50;
	Map<String, User> users;
	User currentUser;

	public UserHandlerClass() {
		users = new HashMap<String, User>(MIN_USERS);
		currentUser = null;
	}

	public String getUser() {
		return currentUser.getName();
	}

	public boolean login(String email, String password) throws InSessionException {

		return true;
	}

	public boolean register(String name, String email, String password) throws InSessionException {

		User user = new UserClass(name, email, password);

		currentUser = user;
		users.put(user.getEmail(), user);

		return true;
	}
}
