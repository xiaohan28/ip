package eepy.command;

import eepy.exception.EepyException;
import eepy.task.Deadline;
import eepy.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class DeadlineCommand extends Command {

    @Override
    public void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException {

        String description, by;
        String[] deadlineParts = userInput.substring(8).trim().split("/by");

        if (deadlineParts.length == 2) {
            description = deadlineParts[0].trim();
            by = deadlineParts[1].trim();
            Deadline deadline = new Deadline(description, by);
            tasks.add(deadline);
        } else {
            throw new EepyException("Invalid deadline format. Use: deadline <description> /by <date>");
        }
    }

    @Override
    protected void printTaskAdded(ArrayList<Task> deadline) {
        super.printTaskAdded(deadline);
    }
}
