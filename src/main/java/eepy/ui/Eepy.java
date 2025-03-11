package eepy.ui;

import eepy.task.*;
import eepy.database.*;
import eepy.command.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Eepy {

    public static void runToDoTracker (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = Database.loadTasks(); //load list from database

        Ui.showMessage("Start To-Do List Tracker");

        String userInput = Ui.readUserInput(input); //initial input

        CommandParser.parseCommands(userInput, tasks, input);
        Ui.showGoodbyeMessage();
    }

    public static void main(String[] args) {
        Ui.showWelcomeMessage();
        runToDoTracker(args);
    }
}
