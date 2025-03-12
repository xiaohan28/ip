package eepy.command;

import eepy.exception.EepyException;
import eepy.task.Event;
import eepy.task.TaskList;

import java.util.Scanner;

/**
 * Represents a command to add an Event task.
 */
public class EventCommand extends Command {

    /**
     * Constructs an EventCommand with user input.
     *
     * @param userInput The full user input string.
     */
    public EventCommand (String userInput) {
        super(userInput);
    }

    /**
     * Executes the command to add an Event task.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList where the task should be added.
     * @param input The Scanner for reading user input.
     * @throws EepyException If the input format is incorrect.
     */
    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {

        String description, from, to;
        String[] eventParts = userInput.substring(5).trim().split("/from|/to");

        if (eventParts.length == 3) {
            description = eventParts[0].trim();
            from = eventParts[1].trim();
            to = eventParts[2].trim();
            Event event = new Event(description, from, to);
            tasks.addTask(event);
            printTaskAdded(tasks);
        } else {
            throw new EepyException("Invalid event format. Use: event <description> /from <start> /to <end>");
        }
    }


}
