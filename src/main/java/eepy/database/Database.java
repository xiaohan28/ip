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

    public static ArrayList<Task> readFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(RELATIVE_FILE_PATH);

        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                String taskLine = s.nextLine();
                tasks.add(new Task(taskLine));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return tasks;
    }

    public static void appendToFile(String textToAppend){
        try {
            FileWriter fw = new FileWriter(RELATIVE_FILE_PATH, true);
            fw.append(textToAppend).append("\n");
//          fw.close(); --> fw closes automatically after try block completes
        } catch(IOException e) {
            System.out.println("Error appending to file:" + e.getMessage());
        }

    }
}

