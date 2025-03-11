package eepy.command;

import eepy.task.*;
import eepy.exception.EepyException;
import eepy.ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class ListCommand extends Command{

    public ListCommand (String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException{
//        Ui.showMessage("To-Do Tasks:");
//        for (int i = 0; i < tasks.size(); i++) {
//            Ui.showMessage((i + 1) + ": " + tasks.getTask(i));
//        }
        tasks.listTasks();
    }
}
