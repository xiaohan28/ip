package ip.src.main.java;
import java.util.Scanner;

public class Eepy {

    public static void toDoTracker (String[] args) {
        Scanner input = new Scanner(System.in);
        Task[] tasks = new Task[100]; //user input array
        int taskCounter = 0;

        System.out.println("_____________________________________");
        System.out.println("Start To-Do List Tracker");
        System.out.println("_____________________________________");
        String userInput = input.nextLine(); //initial input
        System.out.println("_____________________________________");

        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) { //if "list" command, list the elements in the array
                System.out.println("To-Do Tasks:");
                for (int i = 0; i < taskCounter; i++) {
                    System.out.println((i + 1) + ":" + tasks[i].displayTask());
                }
            } else if (userInput.startsWith("mark")) {
                try {
                    int taskNumber = Integer.parseInt(userInput.substring(5).trim()) - 1;
                    //minus 1 so that number start with 0 instead of 1
                    if (taskNumber >= 0 && taskNumber < taskCounter) {
                        tasks[taskNumber].markAsDone();
                        System.out.println("Well done! You've completed the following task:");
                        System.out.println("  " + tasks[taskNumber].displayTask());
                    } else {
                        System.out.println("Task number not within range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid task number, please provide an integer.");
                }
            } else if (userInput.startsWith("unmark")) {
                try {
                    int taskNumber = Integer.parseInt(userInput.substring(7).trim()) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCounter) {
                        tasks[taskNumber].unmarkAsDone();
                        System.out.println("Oh no! You have one additional task:");
                        System.out.println("  " + tasks[taskNumber].displayTask());
                    } else {
                        System.out.println("Task number not within range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid task number, please provide an integer.");
                }
            } else { //else add user input to the array and echo the input
                System.out.println("    Added: " + userInput);
                tasks[taskCounter] = new Task(userInput);
                taskCounter++;
            } //continue accepting input after 'list' or 'add'
            System.out.println("_____________________________________");
            userInput = input.nextLine();
            System.out.println("_____________________________________");
        }
        System.out.println("End of To-Do Tracker, bye! Hope to see you again soon :>");
        System.out.println("_____________________________________");
    }

    public static void main(String[] args) {
        System.out.println("_____________________________________");
        System.out.println("Hello! I'm Eepy" + "\n" + "What can I do for you?");
        toDoTracker(args);
    }
}
