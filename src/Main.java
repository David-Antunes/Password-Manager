import java.util.Scanner;

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
			login(in, fh);
			break;

		case "register":
			register(in, fh);
			break;

		default:
			System.out.println("Unknown Command. Type help to see the available commands.");
		}
	}

	private static void help() {
		System.out.println("login 		- access the account registered.");
		System.out.println("register 	- Registers a new account.");
		System.out.println("help 		- Shows available commands.");
	}

	private static void login(Scanner in, UserHandler hl) {
		String line = in.nextLine();
		if (line.isBlank())
			in = new Scanner(line);
		System.out.println("login (user ID) (password)");
	}

	private static void register(Scanner in, UserHandler hl) {

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

//	private static String getUserCommand(Scanner in, User user) {
//		System.out.print(user.getEmail() + PROMPT);
//		return in.nextLine().toLowerCase().trim();
//	}
//
//	private static void userSession(Scanner in, FileHandling fh, User user) {
//		String option = getUserCommand(in, user);
//
//		while (!option.equals("leave")) {
//			execUserOptions(in, user, option);
//			option = getUserCommand(in, user);
//		}
//		fh.saveUser();
//		System.out.println("Signed Out.");
//	}
//
//	private static void execUserOptions(Scanner in, User user, String option) {
//		switch (option) {
//
//		case "add":
//			add(in, user);
//			break;
//
//		case "remove":
//			removeProgram(in, user);
//			break;
//
//		case "listprogram":
//			listAProgram(in, user);
//			break;
//
//		case "listall":
//			listAll(user);
//			break;
//
//		default:
//			System.out.println(UNKNOWN_COMMAND);
//
//		}
//
//	}
//
//	private static void add(Scanner input, User user) {
//		System.out.print("Insert program name: ");
//		String progName = input.nextLine();
//		System.out.print("Insert ID: ");
//		String ID = input.nextLine();
//		System.out.print("Insert extra parameters: ");
//		int extraNumber = input.nextInt();
//		input.nextLine();
//		String[] extra = null;
//		if (extraNumber > 0) {
//			extra = new String[extraNumber];
//			for (int i = 0; i < extraNumber; i++) {
//				extra[i] = input.nextLine();
//			}
//		}
//		System.out.print("Insert password: ");
//		String password = input.nextLine();
//
//		user.add(progName, ID, extra, password);
//		System.out.println("Program added.");
//	}
//
//	private static void removeProgram(Scanner input, User user) {
//		System.out.print("Insert program name: ");
//		String progName = input.nextLine();
//		System.out.print("Insert ID: ");
//		String ID = input.nextLine();
//
//		user.remove(progName, ID);
//	}
//
//	private static void listAll(User user) {
//		Iterator<List<Program>> programs = user.getAllPrograms();
//
//		System.out.println();
//		while (programs.hasNext()) {
//			List<Program> program = programs.next();
//			printProgram(program.iterator());
//		}
//	}
//
//	private static void listAProgram(Scanner input, User user) {
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
