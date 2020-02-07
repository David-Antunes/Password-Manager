package Handler;

import java.util.HashMap;
import java.util.Map;

import Exceptions.AlreadyRegisteredException;
import Exceptions.AuthException;
import Exceptions.InvalidPasswordException;
import User.User;
import User.UserClass;

public class UserHandlerClass implements UserHandler {

	Map<String, User> users;
	User currentUser;

	public UserHandlerClass() {
		users = new HashMap<String, User>();
	}

	public String getUser() {
		return currentUser.getName();
	}

	public boolean login(String email, String password) {

		return true;
	}

	public boolean register(String name, String email, String password) {

		User user = new UserClass(name, email, password);

		currentUser = user;
		users.put(user.getEmail(), user);
	}
}
