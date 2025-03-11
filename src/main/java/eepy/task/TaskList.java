package eepy.task;

import eepy.database.Database;
import eepy.ui.Ui;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
//        Ui.showMessage("Task added: " + task.getDescription());
        Database.saveTasks(this);
    }

    public void deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            Ui.showMessage("Invalid task index.");
            return;
        }
        Task removedTask = tasks.remove(index);
        Ui.showMessage("Task removed: " + removedTask.getDescription());
        Database.saveTasks(this);
    }

    public void markTaskAsDone(int index) {
        if (index < 0 || index >= tasks.size()) {
            Ui.showMessage("Invalid task index.");
            return;
        }
        Task task = tasks.get(index);
        task.markAsDone();
        Ui.showMessage("Task marked as done: " + task.getDescription());
        Database.saveTasks(this);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            Ui.showMessage("No tasks available.");
            return;
        }
        Ui.printSeparator();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        Ui.printSeparator();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.size();
    }

    public Task getTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return null;
        }
        return tasks.get(index);
    }
}
