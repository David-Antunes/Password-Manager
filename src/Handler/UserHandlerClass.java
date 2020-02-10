package Handler;

import java.util.HashMap;
import java.util.Map;

import SessionsExceptions.InSessionException;
import SessionsExceptions.NotInSessionException;
import User.User;
import User.UserClass;
import User.UserModifier;

public class UserHandlerClass implements UserHandler {

	private static final int MIN_USERS = 50;
	Map<String, User> users;
	User currentUser;

	public UserHandlerClass() {
		users = new HashMap<String, User>(MIN_USERS);
		currentUser = null;
	}

	@Override
	public String getUser() {
		return currentUser.getName();
	}

	public void clearSession() {
		currentUser = null;
	}

	@Override
	public boolean login(String email, String password) throws InSessionException {

		if (currentUser != null)
			throw new InSessionException();

		boolean valid = true;
		User user = users.get(email);

		if (user == null)
			valid = false;
		else if (user.getPassword().equals(password)) {
			currentUser = user;
		} else
			valid = false;

		return valid;
	}

	@Override
	public boolean register(String name, String email, String password) throws InSessionException {

		if (currentUser != null)
			throw new InSessionException();

		User user = users.get(email);
		boolean valid = true;
		if (user != null)
			valid = false;
		else {
			user = new UserClass(name, email, password);
			users.put(user.getEmail(), user);
		}

		return valid;
	}

	@Override
	public void addProgram(String name, String id, String password, String[] extra) throws NotInSessionException {
		if (currentUser == null)
			throw new NotInSessionException();

		UserModifier user = (UserModifier) currentUser;
		user.add(name, id, password, extra);
	}

	@Override
	public void removeProgram(String name, String id) throws NotInSessionException {

		if (currentUser == null)
			throw new NotInSessionException();

		UserModifier user = (UserModifier) currentUser;
		user.remove(name, id);

	}
}
