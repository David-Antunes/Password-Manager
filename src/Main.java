import java.util.Scanner;

import Exceptions.AuthException;
import Exceptions.InvalidPasswordException;
import Handler.UserHandler;
import Handler.UserHandlerClass;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome!");
		UserHandler fh = new UserHandlerClass();
		String option = getCommand(in);

		while (!option.equals("exit")) {
			execOption(in, fh, option);
			option = getCommand(in);
		}

		System.out.println("Bye!");
		in.close();
	}

	private static String getCommand(Scanner in) {
		System.out.print(">");
		return in.next().trim().toLowerCase();
	}

	private static void execOption(Scanner in, UserHandler fh, String option) {
		switch (option) {

		case "help":
			help();
			break;

		case "login":
			if (login(in, fh))
				System.out.println("User authenticated with success.");
				userSession(in, fh);
			else
				System.out.println("Invalid email or password.");
			break;

		case "register":
			if(register(in, fh))
				System.out.println("User registered with success.");
			else
				System.out.println("Invalid email or password.");
			break;

		default:
			System.out.println("Unknown Command. Type help to see the available commands.");
		}
	}

	private static void help() {
		System.out.println("login 		- Access the account registered.");
		System.out.println("register 	- Registers a new account.");
		System.out.println("help 		- Shows available commands.");
	}

	private static boolean login(Scanner in, UserHandler hl) {
		String args[] = parseLine(in.nextLine());
		if (args[0] == null || args[1] == null || args[2] != null)
			System.out.println("login (user email) (password)");

		return hl.login(args[0], args[1]);
	}

	private static boolean register(Scanner in, UserHandler hl) {
		String args[] = parseLine(in.nextLine());
		if (args[0] == null || args[1] == null || args[2] == null || args[3] != null)
			System.out.println("register (user name) (user email) (password)");

		return hl.register(args[0], args[1], args[2]);
	}

	private static String[] parseLine(String line) {
		String[] args = new String[10];
		Scanner scline = new Scanner(line);
		int nargs = 0;
		while (nargs < 10) {
			if (scline.hasNext())
				args[nargs++] = scline.next().trim();
			else
				args[nargs++] = null;
		}
		scline.close();
		return args;
	}

	private static String getUserCommand(Scanner in, String user) {
		System.out.print(user + ">");
		return in.nextLine().toLowerCase().trim();
	}

	private static void userSession(Scanner in, UserHandler hl) {
		String option = getUserCommand(in, hl.getUser());

		while (!option.equals("leave")) {
			execUserOptions(in, hl, option);
			option = getUserCommand(in, option);
		}
		System.out.println("Signed Out.");
	}

	private static void execUserOptions(Scanner in, UserHandler hl, String option) {
		switch (option) {

		case "add":
			add(in, hl);
			break;

		case "remove":
			removeProgram(in, hl);
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

	private static void add(Scanner input, UserHandler user) {
		System.out.print("Insert program name: ");
		String progName = input.nextLine();
		System.out.print("Insert ID: ");
		String ID = input.nextLine();
		System.out.print("Insert extra parameters: ");
		int extraNumber = input.nextInt();
		input.nextLine();
		String[] extra = null;
		if (extraNumber > 0) {
			extra = new String[extraNumber];
			for (int i = 0; i < extraNumber; i++) {
				extra[i] = input.nextLine();
			}
		}
		System.out.print("Insert password: ");
		String password = input.nextLine();

		user.add(progName, ID, extra, password);
		System.out.println("Program added.");
	}
//
//	private static void removeProgram(Scanner input, UserHandler user) {
//		System.out.print("Insert program name: ");
//		String progName = input.nextLine();
//		System.out.print("Insert ID: ");
//		String ID = input.nextLine();
//
//		user.remove(progName, ID);
//	}
//
//	private static void listAll(UserHandler user) {
//		Iterator<List<Program>> programs = user.getAllPrograms();
//
//		System.out.println();
//		while (programs.hasNext()) {
//			List<Program> program = programs.next();
//			printProgram(program.iterator());
//		}
//	}
//
//	private static void listAProgram(Scanner input, UserHandler user) {
//		System.out.println("Insert program name: ");
//		String progName = input.nextLine();
//		System.out.println();
//		printProgram(user.getAProgram(progName));
//
//	}
//
//	private static void printProgram(Iterator<Program> it) {
//		while (it.hasNext()) {
//			Program auxProgram = it.next();
//			System.out.println("Program: " + auxProgram.getProgName());
//			System.out.println("ID: " + auxProgram.getID());
//			String[] extra = auxProgram.getExtra();
//			if (extra != null)
//				for (int i = 0; i < extra.length; i++) {
//					System.out.print("extra: " + extra[i] + "\n");
//				}
//			System.out.println("password: " + auxProgram.getPassword());
//			System.out.println();
//		}
//	}
}
