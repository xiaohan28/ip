package eepy.ui;

import eepy.task.TaskList;
import eepy.database.Database;
import eepy.command.*;

import java.util.Scanner;

public class Eepy {

    public static void runToDoTracker() {
        Scanner input = new Scanner(System.in);
        TaskList tasks = new TaskList(Database.loadTasks().getTasks()); //load list from database

        Ui.showMessage("Start To-Do List Tracker");
        Ui.printSeparator();

        String userInput = Ui.readUserInput(input); //initial input
        Ui.printSeparator();

        CommandParser.parseCommands(userInput, tasks, input);
        Ui.showGoodbyeMessage();
    }

    public static void main(String[] args) {
        Ui.showWelcomeMessage();
        runToDoTracker();
    }
}
