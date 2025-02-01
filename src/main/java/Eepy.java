package ip.src.main.java;
import java.util.Scanner;

public class Eepy {

    public static void toDoTracker (String[] args) {
        System.out.println("_____________________________________");
        System.out.println("Start To-Do List Tracker");
        System.out.println("_____________________________________");
        Scanner input = new Scanner(System.in);
        String[] userInputArray = new String[100];
        int inputCounter = 0;
        String userInput = input.nextLine(); //initial input
        System.out.println("_____________________________________");
        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) { //if "list" command, list the elements in the array
                for (int i = 0; i < inputCounter; i++) {
                    System.out.println((i + 1) + ":" + userInputArray[i]);
                }
            } else { //else add user input to the array and echo the input
                System.out.println("    Added: " + userInput);
                userInputArray[inputCounter] = userInput;
                inputCounter++;
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
