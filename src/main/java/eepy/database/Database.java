package eepy.database;

import eepy.task.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class Database{
    private static final String RELATIVE_FILE_PATH = "../../../data/eepy.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        try {
            FileWriter fw = new FileWriter(RELATIVE_FILE_PATH);
            for (Task task : tasks) {
                fw.write((task.isDone() ? "1" : "0") + "|" + task.getDescription() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " +e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(RELATIVE_FILE_PATH);

        if (!file.exists()) {
            return tasks;
        }

        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                String taskLine = s.nextLine();
                Task task = parseTask(taskLine);
                if (task != null) {
                    tasks.add(task);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return tasks;
    }

    private static Task parseTask(String taskLine) {
        String[] taskParts = taskLine.split("\\|");

        if (taskParts.length < 3) {
            return null;  //there is no isDone status
        }

        boolean isDone = taskParts[0].equals("1");
        String description = taskParts[1];
        Task task = new Task(description); //default isDone is false
        if (isDone) {
            task.markAsDone();
        }
        return task;
    }


}

