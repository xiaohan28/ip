package eepy.command;

import eepy.exception.EepyException;
import eepy.task.Deadline;
import eepy.task.TaskList;

import java.util.Scanner;

/**
 * Represents a command to add a Deadline task.
 */
public class DeadlineCommand extends Command {

    /**
     * Constructs a DeadlineCommand with user input.
     *
     * @param userInput The full user input string.
     */
    public DeadlineCommand(String userInput) {
        super(userInput);
    }

    /**
     * Executes the command to add a Deadline task.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList where the task should be added.
     * @param input The Scanner for reading user input.
     * @throws EepyException If the input format is incorrect.
     */
    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {

        String description, by;
        String[] deadlineParts = userInput.substring(8).trim().split("/by ");

        if (deadlineParts.length == 2) {
            description = deadlineParts[0].trim();
            by = deadlineParts[1].trim();
            Deadline deadline = new Deadline(description, by);
            tasks.addTask(deadline);
            printTaskAdded(tasks);
        } else {
            throw new EepyException("Invalid deadline format. Use: deadline <description> /by <date>");
        }
    }

}
