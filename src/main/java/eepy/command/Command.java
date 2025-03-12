package eepy.command;

import eepy.database.Database;
import eepy.task.TaskList;
import eepy.task.Task;
import eepy.exception.EepyException;
import eepy.ui.Ui;


import java.util.Scanner;

/**
 * Represents an abstract command that can be executed within the application.
 * Each concrete command should extend this class and implement the execute method.
 */
public abstract class Command {

    protected final String userInput;

    /**
     * Constructs a Command object with the given user input.
     *
     * @param userInput The input string from the user.
     */
    public Command(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Executes the command.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList to operate on.
     * @param input The Scanner for reading user input.
     * @throws EepyException If there is an error executing the command.
     */
    public abstract void execute(String userInput, TaskList tasks, Scanner input) throws EepyException;

    /**
     * Prints a message when a task is successfully added and saves the updated task list.
     *
     * @param tasks The TaskList that contains the newly added task.
     */
    protected void printTaskAdded(TaskList tasks) {
        if (!tasks.isEmpty()) {
            Task lastTask = tasks.getTask(tasks.size() - 1);
            Ui.showMessage("Task added: " + lastTask +
                    "\nNow you have " + tasks.size() + " tasks in the list.");
        }
        Database.saveTasks(tasks); // Save newly added tasks
    }

    /**
     * Prints a message when a task is successfully removed.
     *
     * @param tasks The TaskList that contained the removed task.
     * @param taskToRemove The index of the task that was removed.
     */
    protected void printTaskRemoved(TaskList tasks, int taskToRemove) {
        Ui.showMessage("  Removed: " + tasks.getTask(taskToRemove) +
                "\nNow you have " + (tasks.size() - 1) + " tasks in the list.");
    }
}
