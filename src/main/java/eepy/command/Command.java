package eepy.command;

import eepy.database.Database;
import eepy.task.Task;
import eepy.exception.EepyException;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Command {
    public abstract void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException;

    protected void printTaskAdded(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            Task lastTask = tasks.get(tasks.size() - 1);
            System.out.println("  Added: " + lastTask +
                    "\nNow you have " + tasks.size() + " tasks in the list.");
        }
        Database.saveTasks(tasks); //save newly added tasks
    }
}
