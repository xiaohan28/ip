package eepy.ui;

import eepy.task.*;
import eepy.exception.*;
import eepy.database.*;
import eepy.command.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Eepy {

    private static final String SEPARATOR = "_____________________________________";
    public static void printSeparator() {
        System.out.println(SEPARATOR);
    }



    private static void commandReader(String userInput, ArrayList<Task> tasks, Scanner input) {
        while (!userInput.equalsIgnoreCase("bye")) {
            try {
                if (userInput.equalsIgnoreCase("list")) { //if "list" command, list the elements in the array
                    ListCommand listCommand = new ListCommand(userInput);
                    listCommand.execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("mark")) {
                    MarkCommand markCommand = new MarkCommand(userInput,true);
                    markCommand.execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("unmark")) {
                    MarkCommand markCommand = new MarkCommand(userInput,false);
                    markCommand.execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    DeadlineCommand deadlineCommand = new DeadlineCommand(userInput);
                    deadlineCommand.execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("event")) {
                    EventCommand eventCommand = new EventCommand(userInput);
                    eventCommand.execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("todo")) {
                    ToDoCommand toDoCommand = new ToDoCommand(userInput);
                    toDoCommand.execute(userInput, tasks, input);
                } else if (userInput.toLowerCase().startsWith("remove")) {
                    RemoveCommand removeCommand = new RemoveCommand(userInput);
                    removeCommand.execute(userInput, tasks, input);
                } else if (userInput.trim().isEmpty()) {
                    throw new EepyException("No command entered. Please type a command.");
                } else {
                    throw new EepyException("Invalid command: " + userInput + "." +
                            "\nPlease use 'todo', 'deadline', 'event', 'mark', 'unmark', or 'list'.");
                }
            } catch (EepyException e) {
                System.out.println("Aw man! " + e.getMessage());
            }

            printSeparator();
            userInput = input.nextLine();
            printSeparator();
        }
    }


    public static void runToDoTracker (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = Database.loadTasks(); //load list from database

        printSeparator();
        System.out.println("Start To-Do List Tracker");
        printSeparator();

        String userInput = input.nextLine(); //initial input
        printSeparator();

        CommandParser.parseCommands(userInput, tasks, input);
        System.out.println("End of To-Do Tracker, bye! Hope to see you again soon :>");
        printSeparator();
    }

    public static void main(String[] args) {
        printSeparator();
        System.out.println("Hello! I'm Eepy" + "\n" + "What can I do for you?");
        runToDoTracker(args);
    }
}
