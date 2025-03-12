package eepy.command;

import eepy.task.TaskList;
import eepy.exception.EepyException;

import java.util.Scanner;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command{

    /**
     * Constructs a ListCommand with user input.
     *
     * @param userInput The full user input string.
     */
    public ListCommand (String userInput) {
        super(userInput);
    }

    /**
     * Executes the command to list all tasks.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList containing tasks.
     * @param input The Scanner for reading user input.
     * @throws EepyException If an error occurs during execution.
     */
    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException{
        tasks.listTasks();
    }
}
