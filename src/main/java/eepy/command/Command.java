package eepy.command;

import eepy.database.Database;
import eepy.task.Task;
import eepy.exception.EepyException;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Command {

    protected final String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public abstract void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException;

    protected void printTaskAdded(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            Task lastTask = tasks.get(tasks.size() - 1);
            System.out.println("  Added: " + lastTask +
                    "\nNow you have " + tasks.size() + " tasks in the list.");
        }
        Database.saveTasks(tasks); //save newly added tasks
    }

    protected void printTaskRemoved(ArrayList<Task> tasks, int taskToRemove) {
        System.out.println("  Removed: " + tasks.get(taskToRemove) +
                "\nNow you have " + (tasks.size() - 1) + " tasks in the list.");
    }
}
