package Handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Program.Program;
import SessionsExceptions.InSessionException;
import SessionsExceptions.NoProgramException;
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
	public void removeProgram(String name, String id) throws NotInSessionException, NoProgramException {

		if (currentUser == null)
			throw new NotInSessionException();

		UserModifier user = (UserModifier) currentUser;
		user.remove(name, id);

	}

	@Override
	public Iterator<List<Program>> getAllPrograms() throws NotInSessionException, NoProgramException {

		if (currentUser == null)
			throw new NotInSessionException();

		return currentUser.getAllPrograms();
	}

	@Override
	public Iterator<Program> getProgram(String progName) throws NotInSessionException, NoProgramException {

		if (currentUser == null)
			throw new NotInSessionException();

		return currentUser.getAProgram(progName);
	}

	@SuppressWarnings("unchecked")
	public void loadUserData(String name) {
		try {
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(name));

			users = (Map<String, User>) inStream.readObject();
			inStream.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not read file " + name + ".");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("file " + name + " doesn't exist.");
		}

	}

	public void writeUserData(String name) {
		try {
			File file = new File(name);
			if (!file.exists())
				file.createNewFile();
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(name));
			outStream.writeObject(users);
			outStream.flush();
			outStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("file " + name + "doesn't exist.");
		} catch (IOException e) {
			System.out.println("Could not write to file " + name + ".");
		}
	}
}
