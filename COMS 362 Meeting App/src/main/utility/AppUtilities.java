package main.utility;

import java.util.Scanner;

public class AppUtilities {

	//Opening and closing System.in scanners within a single session apparently causes issues.
	//we should use a single instance and close it when we close the application.
	private static Scanner inputScanner = new Scanner(System.in);


	/**
	 * The function issues a prompt provided as an argument.
	 * Then a scanner is created to take user input from a line of text.
	 * The user input is returned.
	 *
	 * @param prompt
	 *
	 * @return
	 */
	public static String collectInput(String prompt) {
		System.out.print(String.format("%s\t", prompt));
		String input = inputScanner.nextLine();
		return input;
	}

	/**
	 * Same as collectInput(...) but parses input as an int
	 */
	public static int collectInputAsInteger(String prompt) {
		String input = collectInput(prompt);
		return Integer.parseInt(input);
	}

	/**
	 * Call this when shutting down the app
	 */
	public static void closeInputScanner() {
		inputScanner.close();
	}
}
