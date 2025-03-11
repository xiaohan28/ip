package eepy.command;

import eepy.exception.EepyException;
import eepy.task.*;
import eepy.task.ToDo;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoCommand extends Command{

    public ToDoCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {
        String description = userInput.substring(4).trim();
        if (description.isEmpty()) {
            throw new EepyException("No description entered.");
        }
        ToDo toDo = new ToDo(description);
        tasks.addTask(toDo);
        printTaskAdded(tasks);
    }
}
