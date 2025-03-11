package eepy.command;

import eepy.database.Database;
import eepy.exception.EepyException;
import eepy.task.*;
import eepy.ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class MarkCommand extends Command{

    private final boolean markDone;

    public MarkCommand(String userInput, boolean markDone) {
        super(userInput);
        this.markDone = markDone;
    };

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {

        String command = markDone ? "mark" : "unmark";

        try {
            int taskNumber = Integer.parseInt(userInput.substring(command.length()).trim()) - 1; //since array start from 0

            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                Ui.showMessage("Task number not within range.");
                return;
            }

            Task task = tasks.getTask(taskNumber);  // Avoid repeated get()

            if (markDone) {
                task.markAsDone();
                Ui.showMessage("Well done! You've completed the following task:");
            } else {
                task.unmarkAsDone();
                Ui.showMessage("Oh no! You have one additional task:");
            }

            Ui.showMessage(" " + task);  // Print task status

            Database.saveTasks(tasks); // Save updated tasks

        } catch (NumberFormatException e) {
            Ui.showMessage("Invalid task number, please provide an integer.");
        }
    }
}
