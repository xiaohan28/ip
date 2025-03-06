package eepy.command;

import eepy.database.Database;
import eepy.exception.EepyException;
import eepy.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveCommand extends Command {

    public RemoveCommand (String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException {
        int taskToRemove = Integer.parseInt(this.userInput.substring("remove".length()).trim()) - 1;

        if (taskToRemove < 0 || taskToRemove >= tasks.size()) {
            throw new EepyException("Task number not within range.");
        }
        printTaskRemoved(tasks, taskToRemove);
        tasks.remove(taskToRemove);
        Database.saveTasks(tasks); //save updates after removal
    }
}
