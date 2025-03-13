package eepy.command;

import eepy.task.TaskList;
import eepy.ui.Ui;

import java.util.Scanner;

/**
 * Represents a command to mark or unmark a task as done.
 */
public class MarkCommand extends Command{

    private final boolean markDone;

    /**
     * Constructs a MarkCommand with user input and mark status.
     *
     * @param userInput The full user input string.
     * @param markDone True if marking as done, false if unmarking.
     */
    public MarkCommand(String userInput, boolean markDone) {
        super(userInput);
        this.markDone = markDone;
    }

    /**
     * Executes the command to mark or unmark a task as done.
     *
     * @param userInput The original user input.
     * @param tasks The TaskList containing tasks.
     * @param input The Scanner for reading user input.
     */
    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) {

        String command = markDone ? "mark" : "unmark";

        try {
            int taskNumber = Integer.parseInt(userInput.substring(command.length()).trim()) - 1; //since array start from 0
            tasks.markTaskAsDone(taskNumber, markDone);

        } catch (NumberFormatException e) {
            Ui.showMessage("Invalid task number, please provide an integer.");
        }
    }
}
