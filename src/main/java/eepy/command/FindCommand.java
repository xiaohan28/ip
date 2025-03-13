package eepy.command;

import eepy.task.TaskList;
import eepy.exception.EepyException;

import java.util.Scanner;

/**
 * Command to find tasks containing a specific keyword.
 */
public class FindCommand extends Command {

    public FindCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {
        String keyword = userInput.substring("find".length()).trim();

        if (keyword.isEmpty()) {
            throw new EepyException("Please enter a keyword to search.");
        }

        tasks.findTasks(keyword); // Delegate search logic to TaskList
    }
}
