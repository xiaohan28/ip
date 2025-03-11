package eepy.command;

import eepy.task.*;
import eepy.ui.*;
import eepy.exception.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandParser {

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
                } else if (userInput.trim().isEmpty()) {
                    throw new EepyException("No command entered. Please type a command.");
                } else {
                    throw new EepyException("Invalid command: " + userInput + "." +
                            "\nPlease use 'todo', 'deadline', 'event', 'mark', 'unmark', or 'list'.");
                }
            } catch (EepyException e) {
                Ui.showMessage("Aw man! " + e.getMessage());
            }

            Ui.printSeparator();
            userInput = Ui.readUserInput(input);  // Read user input using Ui
            Ui.printSeparator();
        }
    }
}
