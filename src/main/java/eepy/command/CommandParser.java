package eepy.command;

import eepy.task.TaskList;
import eepy.ui.Ui;
import eepy.exception.EepyException;

import java.util.Scanner;

/**
 * Parses and processes user commands by delegating them to the appropriate command handlers.
 */
public class CommandParser {

    /**
     * Parses user input and executes the corresponding command.
     *
     * @param userInput The command entered by the user.
     * @param tasks The task list to operate on.
     * @param input The scanner object for reading user input.
     */
    public static void parseCommands(String userInput, TaskList tasks, Scanner input) {
        while (!userInput.equalsIgnoreCase("bye")) {
            try {
                if (userInput.equalsIgnoreCase("list")) {
                    new ListCommand(userInput).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("mark")) {
                    new MarkCommand(userInput, true).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("unmark")) {
                    new MarkCommand(userInput, false).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    new DeadlineCommand(userInput).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("event")) {
                    new EventCommand(userInput).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("todo")) {
                    new ToDoCommand(userInput).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("remove")) {
                    new RemoveCommand(userInput).execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("find")) {
                    new FindCommand(userInput).execute(userInput, tasks, input);
                } else if (userInput.trim().isEmpty()) {
                    throw new EepyException("No command entered. Please type a command.");
                } else {
                    throw new EepyException("Invalid command: " + userInput + "." +
                            "\nPlease use 'todo', 'deadline', 'event', 'mark', 'unmark', 'remove', 'find' or 'list'.");
                }
            } catch (EepyException e) {
                Ui.showMessage("Aw man! " + e.getMessage());
            }

            Ui.printSeparator();
            userInput = Ui.readUserInput(input);  // Read user input using eepy.ui.Ui
            Ui.printSeparator();
        }
    }
}
