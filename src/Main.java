import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Handler.UserHandler;
import Handler.UserHandlerClass;
import Program.Program;
import SessionsExceptions.InSessionException;
import SessionsExceptions.NoProgramException;
import SessionsExceptions.NotInSessionException;

public class Main {

	private static final int MAX_ARGS = 10;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome!");
		UserHandler fh = new UserHandlerClass();
		fh.loadUserData("users.map");
		String option = getCommand(in);

		while (!option.equals("exit")) {
			execOption(in, fh, option);
			option = getCommand(in);
		}

		System.out.println("Bye!");
		fh.writeUserData("users.map");
		in.close();
	}

	/**
	 * Prints the PROMPT and a waits for a token. Returns the a token form the
	 * scanner and returns it without whitespace and in lower case.
	 * 
	 * @param in - Scanner Object
	 * @return - a String trimmed and lowered case.
	 */
	private static String getCommand(Scanner in) {
		System.out.print(">");
		return in.next().trim().toLowerCase();
	}

	/**
	 * Executes the corresponding option available. The available options are
	 * 'login', 'register' and 'help'. Giving a non-existing command will return a
	 * error message. The argument option should have been used with getCommand().
	 * 
	 * @param in     - Scanner Object to provide new inputs to the corresponding
	 *               methods
	 * @param fh     - UserHandler Object to work the user data
	 * @param option - String to run the corresponding method
	 * 
	 */
	private static void execOption(Scanner in, UserHandler fh, String option) {
		switch (option) {

		case "help":
			helpOutSession();
			break;

		case "login":
			if (login(in, fh))
				userSession(in, fh);
			break;

		case "register":
			register(in, fh);
			break;

		default:
			System.out.println("Unknown Command. Type help to see the available commands.");
		}
	}

	/**
	 * Prints the available commands without being in session.
	 */
	private static void helpOutSession() {
		System.out.println("login 		- Access the account registered.");
		System.out.println("register 	- Registers a new account.");
		System.out.println("help 		- Shows available commands.");
	}

	/**
	 * Logins the user into the program. This method works when the scanner has two
	 * tokens to be read, being a valid user email and its corresponding password.
	 * Having only one token or above 2 will produce an error message.
	 * 
	 * @param in - Scanner Object to provide the tokens necessary to login the user
	 * @param hl - UserHandler object to login the user
	 * @return True if login() is successful, false otherwise.
	 */
	private static boolean login(Scanner in, UserHandler hl) {
		String args[] = parseLine(in.nextLine());

		if (args[0] == null || args[1] == null || args[2] != null) {
			System.out.println("login (user email) (password)");
			return false;
		}

		try {
			boolean success = hl.login(args[0], args[1]);

			if (success) {
				System.out.println("User authenticated with success.");
			} else
				System.out.println("Invalid email or password.");

			return success;
		} catch (InSessionException e) {
			System.out.println("Can't do that while in session.");
			return false;
		}
	}

	/**
	 * Registers a new user. This method works when the scanner has three tokens to
	 * be read, being a name, a non-existing email and a password. Having lower or
	 * higher than 3 tokens on the scanner will produce an error message.
	 * 
	 * @param in - Scanner Object to provide the tokens necessary to register the
	 *           user
	 * @param hl - UserHandler object to register the user
	 * @return True if register() is successful, false otherwise.
	 */
	private static boolean register(Scanner in, UserHandler hl) {
		String args[] = parseLine(in.nextLine());

		if (args[0] == null || args[1] == null || args[2] == null || args[3] != null) {
			System.out.println("register (user name) (user email) (password)");
			return false;
		}

		try {
			boolean success = hl.register(args[0], args[1], args[2]);

			if (success) {
				System.out.println("User registered with success.");
			} else
				System.out.println("Invalid email.");

			return success;

		} catch (InSessionException e) {
			System.out.println("Can't do that while in session.");
			return false;
		}
	}

	/**
	 * This auxiliary method is used to parse a string and retrieve the various
	 * arguments. This method only parses till 10 arguments, deleting the rest. If
	 * the line has less than MAX_ARGS, than the remaining positions of the array
	 * will be filled with null. The use of null is to check for errors, to be used
	 * in the other methods. For example, in login() the null is used to verify if
	 * there is an extra argument in the third position. If there is, than it is an
	 * error.
	 * 
	 * @param line - String to be parsed
	 * @return an array of strings containing the various arguments.
	 */
	private static String[] parseLine(String line) {
		String[] args = new String[MAX_ARGS];
		Scanner scline = new Scanner(line);
		int nargs = 0;
		while (nargs < MAX_ARGS) {
			if (scline.hasNext())
				args[nargs++] = scline.next().trim();
			else
				args[nargs++] = null;
		}
		scline.close();
		return args;
	}

	/**
	 * Prints the name of the user + PROMPT and a waits for a token. Returns the a
	 * token form the scanner and returns it without whitespace and in lower case.
	 * 
	 * @param in   - Scanner Object
	 * @param user - name of the user in session
	 * @return - a String trimmed and lowered case.
	 */
	private static String getUserCommand(Scanner in, String user) {
		System.out.print(user + ">");
		return in.next().toLowerCase().trim();
	}

	/**
	 * This method is a new command interpreter when a new user has logged on. In
	 * this interpreter the prompt changes, adding the name of the user logged in,
	 * and unlocks new functionalities that can be used.
	 * 
	 * @param in - Scanner Object to provide new inputs to the corresponding methods
	 * @param hl - UserHandler object that has a user logged in
	 */
	private static void userSession(Scanner in, UserHandler hl) {
		String option = getUserCommand(in, hl.getUser());

		while (!option.equals("quit")) {
			execUserOptions(in, hl, option);
			option = getUserCommand(in, hl.getUser());
		}
		hl.clearSession();
		System.out.println("Signed Out.");
	}

	/**
	 * Executes the corresponding option available. The available options are 'add',
	 * 'remove' and 'help'. Giving a non-existing command will return a error
	 * message. The argument option should have been used with getCommand().
	 * 
	 * @param in     - Scanner Object to provide new inputs to the corresponding
	 *               methods
	 * @param hl     - UserHandler object that has a User logged in and manipulate
	 *               said user
	 * @param option - String to run the corresponding method
	 * 
	 */
	private static void execUserOptions(Scanner in, UserHandler hl, String option) {
		switch (option) {

		case "help":
			helpInSession();
			break;

		case "add":
			add(in, hl);
			break;

		case "remove":
			remove(in, hl);
			break;

		case "listprogram":
			listAProgram(in, hl);
			break;

		case "listall":
			listAll(hl);
			break;

		default:
			System.out.println("Unknown Command. Type help to see the available commands.");

		}

	}

	/**
	 * Prints the available commands when being in session.
	 */
	private static void helpInSession() {
		System.out.println("add 			- Adds a new program.");
		System.out.println("remove 			- Removes a program.");
		System.out.println("listprogram 	- Lists the contents of a program.");
		System.out.println("listall 		- Lists all programs.");
		System.out.println("quit 			- Quits current session.");
	}

	private static void add(Scanner in, UserHandler hl) {
		String name = in.nextLine().strip();
		if (name.isBlank()) {
			System.out.println("add (program name)");
			System.out.println("(program id)");
			System.out.println("(program password)");
			System.out.println("(number of parameters)");
			System.out.println("(program parameters)");
		} else {
			String progName = name;
			System.out.print("Insert ID: ");
			String ID = in.nextLine();
			System.out.print("Insert password: ");
			String password = in.nextLine();
			System.out.print("Insert number of extra parameters: ");
			int extraNumber = in.nextInt();
			in.nextLine();
			System.out.println("Input your extra parameters.");
			String[] extra = null;
			if (extraNumber > 0) {
				extra = new String[extraNumber];
				for (int i = 0; i < extraNumber; i++) {
					extra[i] = in.nextLine();
				}
			}

			try {
				hl.addProgram(progName, ID, password, extra);
				System.out.println("Program added.");
			} catch (NotInSessionException e) {
				System.out.println("You need to login to do that.");
			}
		}
	}

	private static void remove(Scanner in, UserHandler hl) {

		String args[] = parseLine(in.nextLine());

		if (args[0] == null || args[1] == null || args[2] != null) {
			System.out.println("remove (program name) (program id)");
		} else {
			try {
				hl.removeProgram(args[0], args[1]);
				System.out.println("Program removed.");
			} catch (NoProgramException e) {
				System.out.println("There is no program with that name or id.");
			} catch (NotInSessionException e) {
				System.out.println("You need to login to do that.");
			}

		}
	}

	private static void listAll(UserHandler hl) {
		Iterator<List<Program>> programs;
		try {
			programs = hl.getAllPrograms();

			System.out.println();
			while (programs.hasNext()) {
				List<Program> program = programs.next();
				printProgram(program.iterator());
			}
		} catch (NoProgramException e) {
			System.out.println("There is no program.");
		} catch (NotInSessionException e) {
			System.out.println("You need to login to do that.");
		}
	}

	private static void listAProgram(Scanner in, UserHandler hl) {

		String progName = in.nextLine().strip();
		System.out.println();
		try {
			printProgram(hl.getProgram(progName));
		} catch (NoProgramException e) {
			System.out.println("There is no program with that name.");
		} catch (NotInSessionException e) {
			System.out.println("You need to login to do that.");
		}

	}

	private static void printProgram(Iterator<Program> it) {
		while (it.hasNext()) {
			Program auxProgram = it.next();
			System.out.println("Program: " + auxProgram.getName());
			System.out.println("ID: " + auxProgram.getID());
			System.out.println("password: " + auxProgram.getPassword());
			String[] extra = auxProgram.getExtra();
			if (extra != null)
				for (int i = 0; i < extra.length; i++) {
					System.out.print("extra: " + extra[i] + "\n");
				}
			System.out.println();
		}
	}
}
