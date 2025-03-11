package eepy.command;

import eepy.exception.EepyException;
import eepy.task.Event;
import eepy.task.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EventCommand extends Command {

    public EventCommand (String userInput) {
        super(userInput);
    }

    @Override
    public void execute(String userInput, TaskList tasks, Scanner input) throws EepyException {

        String description, from, to;
        String[] eventParts = userInput.substring(5).trim().split("/from|/to");

        if (eventParts.length == 3) {
            description = eventParts[0].trim();
            from = eventParts[1].trim();
            to = eventParts[2].trim();
            Event event = new Event(description, from, to);
            tasks.addTask(event);
            printTaskAdded(tasks);
        } else {
            throw new EepyException("Invalid event format. Use: event <description> /from <start> /to <end>");
        }
    }


}
