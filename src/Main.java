import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print(">");
		String option = getCommand(in);
		while (!option.equals("exit")) {
			execOption(in, option);
		}
	}

	private static String getCommand(Scanner in) {
		return in.next().trim().toLowerCase();
	}
	
	private static void execOption(Scanner in, String option) {
		
		switch(option) {
		case "register":
			
			break;
		case "login":
		
			break;
		
		case "help":
			
			break;
			
		default:
			
		}
	}
}
