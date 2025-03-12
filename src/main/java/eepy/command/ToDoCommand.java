package eepy.command;

import eepy.exception.EepyException;
import eepy.task.TaskList;
import eepy.task.ToDo;

import java.util.Scanner;

/**
 * Represents a command to add a to-do task.
 */
public class ToDoCommand extends Command{

    /**
     * Constructs a ToDoCommand with user input.
     *
     * @param userInput The full user input string.
     */
    public ToDoCommand(String userInput) {
        super(userInput);
    }

    /**
     * Executes the command to add a ToDo task.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList where the task should be added.
     * @param input The Scanner for reading user input.
     * @throws EepyException If no description is provided.
     */
    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {
        String description = userInput.substring(4).trim();
        if (description.isEmpty()) {
            throw new EepyException("No description entered.");
        }
        ToDo toDo = new ToDo(description);
        tasks.addTask(toDo);
        printTaskAdded(tasks);
    }
}
