package FileHandling;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import User.User;

public class FileHandlingClass implements FileHandling, Runnable {

	User user;

	public FileHandlingClass() {
		user = null;
		File file;
		file = new File("LogUsers.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	@Override
	public boolean verifyEmail(String email) throws FileNotFoundException {
		// Reads the file
		boolean found = false;

		FileReader reader;
		reader = new FileReader("LogUsers.txt");
		Scanner in = new Scanner(reader);

		while (in.hasNextLine() && !found) {
			String emailInFile = in.nextLine();
			if (emailInFile.equals(email))
				found = true;
		}
		in.close();

		return found;
	}

	public void setRegisteredUser(User user) {
		this.user = user;
		logEmail(this.user.getEmail());
	}

	public void logEmail(String email) {
		try {
			FileWriter writer = new FileWriter("LogUsers.txt", true);
			writer.write(email + "\n");
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public User getUser(String email) {
		User user = null;
		try {
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(email));

			user = (User) inStream.readObject();
			inStream.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.user = user;
		return user;
	}

	@Override
	public void saveUser() {
		try {
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(user.getEmail()));
			outStream.writeObject(user);
			outStream.flush();
			outStream.close();
			user = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		new FileHandlingClass();
	}
}
