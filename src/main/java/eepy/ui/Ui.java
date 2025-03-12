package eepy.ui;

import java.util.Scanner;

/**
 * Handles user interaction by displaying messages and reading inputs.
 */

public class Ui {

    private static final String SEPARATOR = "_____________________________________";

    /**
     * Prints a horizontal separator line.
     */
    public static void printSeparator() {
        System.out.println(SEPARATOR);
    }

    /**
     * Prints a welcome message when the program starts.
     */
    public static void showWelcomeMessage() {
        printSeparator();
        System.out.println("Hello! I'm Eepy" + "\n" + "Let's be productive today :>");
        printSeparator();
    }

    /**
     * Prints the goodbye message when the user exits.
     */
    public static void showGoodbyeMessage() {
        System.out.println("End of To-Do Tracker!" +
                        "\nHope to see you again soon :>");
        printSeparator();
    }

    /**
     * Reads user input from the console.
     *
     * @param input Scanner object to read input.
     * @return the user input as a string.
     */
    public static String readUserInput(Scanner input) {
        return input.nextLine();
    }

    /**
     * Display a message to the user.
     *
     * @param message The message to be displayed.
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }
}
