package eepy.ui;

import eepy.task.TaskList;
import eepy.database.Database;
import eepy.command.CommandParser;

import java.util.Scanner;

/**
 * Main entry point for the Eepy To-DoList Tracker application.
 * This class initialises the application, loadsre saved tasks, and
 * handles user interaction via command parsing.
 */

public class Eepy {
    /**
     * Runs the To-Do List Tracker application.
     * Initialise the task list, interacts with the user and processes commands.
     */
    public static void runToDoTracker() {
        Scanner input = new Scanner(System.in);

        // Load tasks from the database in eepy.txt
        TaskList tasks = new TaskList(Database.loadTasks().getTasks());

        Ui.showMessage("Start To-Do List Tracker");
        Ui.printSeparator();

        // Read initial user input
        String userInput = Ui.readUserInput(input); //initial input
        Ui.printSeparator();

        // Process user commands using a parser
        CommandParser.parseCommands(userInput, tasks, input);

        Ui.showGoodbyeMessage();
    }

    /**
     * The main method of the application.
     * Displays a welcome message and starts the task tracker.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Ui.showWelcomeMessage();
        runToDoTracker();
    }
}
