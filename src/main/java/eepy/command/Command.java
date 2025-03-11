package eepy.command;

import eepy.database.Database;
import eepy.task.TaskList;
import eepy.task.Task;
import eepy.exception.EepyException;
import eepy.ui.Ui;


import java.util.Scanner;

public abstract class Command {

    protected final String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public abstract void execute(String userInput, TaskList tasks, Scanner input) throws EepyException;

    protected void printTaskAdded(TaskList tasks) {
        if (!tasks.isEmpty()) {
            Task lastTask = tasks.getTask(tasks.size() - 1);
            Ui.showMessage("Task added: " + lastTask +
                    "\nNow you have " + tasks.size() + " tasks in the list.");
        }
        Database.saveTasks(tasks); //save newly added tasks
    }

    protected void printTaskRemoved(TaskList tasks, int taskToRemove) {
        Ui.showMessage("  Removed: " + tasks.getTask(taskToRemove) +
                "\nNow you have " + (tasks.size() - 1) + " tasks in the list.");
    }
}
