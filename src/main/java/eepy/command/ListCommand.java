package eepy.command;

import eepy.task.Task;
import eepy.exception.EepyException;

import java.util.ArrayList;
import java.util.Scanner;

public class ListCommand extends Command{
    @Override
    public void execute(String userInput, ArrayList<Task> tasks, Scanner input) throws EepyException{
        System.out.println("To-Do Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    };
}
