package ip.src.main.java;//package ip.src.main.java;

import java.util.Scanner;
import java.util.ArrayList;

public class Eepy {

    public static void printSeparator() {
        System.out.println("_____________________________________");
    }

    public static void updateTaskStatus(String userInput, ArrayList<Task> tasks, boolean markDone) {
        try {
            String command = markDone ? "mark" : "unmark";
            int taskNumber = Integer.parseInt(userInput.substring(command.length()).trim()) - 1;
            //minus 1 so that number start with 0 instead of 1
            if (taskNumber >= 0 && taskNumber < tasks.size()) {
                if (markDone) {
                    tasks.get(taskNumber).markAsDone();
                    System.out.println("Well done! You've completed the following task:");
                } else {
                    tasks.get(taskNumber).unmarkAsDone();
                    System.out.println("Oh no! You have one additional task:");
                }
                System.out.println(" " + tasks.get(taskNumber));
            } else {
                System.out.println("Task number not within range.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid task number, please provide an integer.");
        }
    }

    public static void runToDoTracker (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>(); //user input array (dynamic)

        printSeparator();
        System.out.println("Start To-Do List Tracker");
        printSeparator();

        String userInput = input.nextLine(); //initial input
        printSeparator();

        while (!userInput.equalsIgnoreCase("bye")) {
            if (userInput.equalsIgnoreCase("list")) { //if "list" command, list the elements in the array
                System.out.println("To-Do Tasks:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ":" + tasks.get(i));
                }
            } else if (userInput.toLowerCase().startsWith("mark")) {
                updateTaskStatus(userInput, tasks, true);
            } else if (userInput.toLowerCase().startsWith("unmark")) {
                updateTaskStatus(userInput, tasks, false);
            } else { //else add user input to the array and echo the input
                System.out.println("    Added: " + userInput);
                tasks.add(new Task(userInput));
            } //continue accepting input after 'list' or 'add'
            printSeparator();
            userInput = input.nextLine();
            printSeparator();
        }
        System.out.println("End of To-Do Tracker, bye! Hope to see you again soon :>");
        printSeparator();
    }

    public static void main(String[] args) {
        printSeparator();
        System.out.println("Hello! I'm Eepy" + "\n" + "What can I do for you?");
        runToDoTracker(args);
    }
}
