package eepy.command;

import eepy.exception.EepyException;
import eepy.task.TaskList;
import eepy.ui.Ui;

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
            tasks.markTaskAsDone(taskNumber, markDone);

        } catch (NumberFormatException e) {
            Ui.showMessage("Invalid task number, please provide an integer.");
        }
    }
}
