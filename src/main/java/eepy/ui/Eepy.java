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

//    private static void printTaskAdded(ArrayList<Task> tasks) {
//        if (!tasks.isEmpty()) {
//            Task lastTask = tasks.get(tasks.size() - 1);
//            System.out.println("  Added: " + lastTask +
//                    "\nNow you have " + tasks.size() + " tasks in the list.");
//        }
//        Database.saveTasks(tasks); //save newly added tasks
//    }

//    private static void printTaskRemoved(ArrayList<Task> tasks, int taskToRemove) {
//        System.out.println("  Removed: " + tasks.get(taskToRemove) +
//                    "\nNow you have " + (tasks.size() - 1) + " tasks in the list.");
//    }


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

//    public static void toDoFormatter(String userInput, ArrayList<Task> tasks) throws EepyException {
//        String description = userInput.substring(4).trim();
//
//        if (description.isEmpty()) {
//            throw new EepyException("No description entered.");
//        }
//
//        ToDo toDo = new ToDo(description);
//        tasks.add(toDo);
//    }

//    public static void deadlineFormatter(String userInput, ArrayList<Task> tasks) throws EepyException {
//        String description, by;
//        String[] deadlineParts = userInput.substring(8).trim().split("/by");
//
//        if (deadlineParts.length == 2) {
//            description = deadlineParts[0].trim();
//            by = deadlineParts[1].trim();
//            Deadline deadline = new Deadline(description, by);
//            tasks.add(deadline);
//        } else {
//            throw new EepyException("Invalid deadline format. Use: deadline <description> /by <date>");
//        }
//    }

//    public static void eventFormatter(String userInput, ArrayList<Task> tasks) throws EepyException {
//        String description, from, to;
//        String[] eventParts = userInput.substring(5).trim().split("/from|/to");
//
//        if (eventParts.length == 3) {
//            description = eventParts[0].trim();
//            from = eventParts[1].trim();
//            to = eventParts[2].trim();
//            Event event = new Event(description, from, to);
//            tasks.add(event);
//        } else {
//            throw new EepyException("Invalid event format. Use: event <description> /from <start> /to <end>");
//        }
//    }

    public static void runToDoTracker (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = Database.loadTasks(); //load list from database

        printSeparator();
        System.out.println("Start To-Do List Tracker");
        printSeparator();

        String userInput = input.nextLine(); //initial input
        printSeparator();

        commandReader(userInput, tasks, input);
        System.out.println("End of To-Do Tracker, bye! Hope to see you again soon :>");
        printSeparator();
    }

    public static void main(String[] args) {
        printSeparator();
        System.out.println("Hello! I'm Eepy" + "\n" + "What can I do for you?");
        runToDoTracker(args);
    }
}
