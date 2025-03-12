package eepy.command;

import eepy.database.Database;
import eepy.exception.EepyException;
import eepy.task.TaskList;

import java.util.Scanner;

/**
 * Represents a command to remove a task from the task list.
 */
public class RemoveCommand extends Command {

    /**
     * Constructs a RemoveCommand with user input.
     *
     * @param userInput The full user input string.
     */
    public RemoveCommand (String userInput) {
        super(userInput);
    }

    /**
     * Executes the command to remove a task.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList containing tasks.
     * @param input The Scanner for reading user input.
     * @throws EepyException If the task number is out of range or invalid.
     */
    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {
        int taskToRemove = Integer.parseInt(this.userInput.substring("remove".length()).trim()) - 1;

        if (taskToRemove < 0 || taskToRemove >= tasks.size()) {
            throw new EepyException("Task number not within range.");
        }
        printTaskRemoved(tasks, taskToRemove);
        tasks.removeTask(taskToRemove);
        Database.saveTasks(tasks); // Save updates after removal
    }
}
