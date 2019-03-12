package main.utility;

import java.util.Scanner;

public class AppUtilities {

    /**
     * The function issues a prompt provided as an argument.
     * Then a scanner is created to take user input from a line of text.
     * The user input is returned.
     * @param prompt
     * @return
     */
    public static String collectInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(String.format("%s\t",prompt));
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    /**
     * Same as collectInput(...) but parses input as an int
     */
    public static int collectInputAsInteger(String prompt){
        String input = collectInput(prompt);
        return Integer.parseInt(input);
    }
}
