package eepy.command;

import eepy.task.TaskList;
import eepy.exception.EepyException;

import java.util.Scanner;

public class ListCommand extends Command{

    public ListCommand (String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException{
        tasks.listTasks();
    }
}
