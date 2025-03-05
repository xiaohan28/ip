package eepy.command;

import eepy.database.Database;
import eepy.exception.EepyException;
import eepy.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class MarkCommand extends Command{

    private final boolean markDone;

    public MarkCommand(boolean markDone) {
        this.markDone = markDone;
    };

    @Override
    public void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException {

        String command = markDone ? "mark" : "unmark";

        try {
            int taskNumber = Integer.parseInt(userInput.substring(command.length()).trim()) - 1; //since array start from 0

            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                System.out.println("Task number not within range.");
                return;
            }

            Task task = tasks.get(taskNumber);  // Avoid repeated get()

            if (markDone) {
                task.markAsDone();
                System.out.println("Well done! You've completed the following task:");
            } else {
                task.unmarkAsDone();
                System.out.println("Oh no! You have one additional task:");
            }

            System.out.println(" " + task);  // Print task status

            Database.saveTasks(tasks); // Save updated tasks

        } catch (NumberFormatException e) {
            System.out.println("Invalid task number, please provide an integer.");
        }
    }
};
