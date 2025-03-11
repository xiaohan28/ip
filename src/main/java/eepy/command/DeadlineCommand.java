package eepy.command;

import eepy.exception.EepyException;
import eepy.task.Deadline;
import eepy.task.TaskList;

import java.util.Scanner;

public class DeadlineCommand extends Command {

    public DeadlineCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {

        String description, by;
        String[] deadlineParts = userInput.substring(8).trim().split("/by");

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
