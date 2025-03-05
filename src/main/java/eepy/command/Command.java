package eepy.command;

import eepy.task.Task;
import eepy.exception.EepyException;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Command {
    public abstract void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException;
}
