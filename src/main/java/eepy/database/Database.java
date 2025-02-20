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
            String taskData;
            for (Task task : tasks) {
                if (task instanceof Deadline) {
                    Deadline deadline = (Deadline) task;
                    taskData = deadline.getDescription() + "/by" + deadline.getBy();
                } else if (task instanceof Event) {
                    Event event = (Event) task;
                    taskData = event.getDescription() + "/from" + event.getFrom() + "/to" + event.getTo();
                } else {
                    taskData = task.getDescription();
                }
                fw.write(task.getTaskType() + "|" + (task.isDone() ? "1" : "0") +
                        "|" + taskData + "\n");
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

        String taskType = taskParts[0];
        boolean isDone = taskParts[1].equals("1");
        String description = taskParts[2];

        Task task;
        if (taskType.equals("T")) {
            task = new ToDo(description);
        } else if (taskType.equals("D")) {
            String[] deadlineFormat = description.split("/by", 2); //limit split into 2 only
            if (deadlineFormat.length < 2) return null;
            String deadlineDescription = deadlineFormat[0];
            String by = deadlineFormat[1];
            task = new Deadline(deadlineDescription, by);
        } else if (taskType.equals("E")) {
            String[] eventFormat = description.split("/from|/to", 3);
            if (eventFormat.length < 3) return null;
            String eventDescription = eventFormat[0];
            String from = eventFormat[1];
            String to = eventFormat[2];
            task = new Event(eventDescription, from, to);
        } else {
            return null;
        }

        if (isDone) {
            task.markAsDone();
        }

        return task;
    }


}

