package eepy.command;

import eepy.task.TaskList;
import eepy.exception.EepyException;
import eepy.ui.Ui;

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
            Ui.showMessage("Please enter a keyword to search.");
            return;
        }

        tasks.findTasks(keyword); // Delegate search logic to TaskList
    }
}
