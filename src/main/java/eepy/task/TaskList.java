package eepy.task;

import eepy.database.Database;
import eepy.exception.EepyException;
import eepy.ui.Ui;
import java.util.ArrayList;

/**
 * Manage a list of tasks, providing operations to add, remove,
 * modify and retrieve tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with an existing list of tasks.
     *
     * @param tasks The initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Checks if the task list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Retrieves the size of the task list.
     *
     * @return The number of tasks in the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Adds a task to the list and saves the updated list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        Database.saveTasks(this);
    }


    /**
     * Retrieves a task by its index.
     *
     * @param index The index of the task.
     * @return The task at the given index or null if out of bounds.
     */
    public Task getTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return null;
        }
        return tasks.get(index);
    }

    /**
     * Removes a task from the list by its index.
     *
     * @param index The index of the task to remove.
     */
    public void removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            Ui.showMessage("Invalid task index.");
            return;
        }
        tasks.remove(index);
        Database.saveTasks(this);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            Ui.showMessage("No tasks available.");
            return;
        }
        Ui.showMessage("To-Do Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Ui.showMessage((i + 1) + ": " + tasks.get(i));
        }
    }

    /**
     * Searches for tasks that contain the specified keyword in their description.
     *
     * @param keyword The keyword to search for within task descriptions.
     */
    public void findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }

        if (matchingTasks.isEmpty()) {
            Ui.showMessage("No matching tasks found.");
        } else {
            Ui.showMessage("Found it! Here are the matching tasks:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + matchingTasks.get(i));
            }
        }
    }


    /**
     * Displays the list of tasks.
     */
    public void markTaskAsDone(int index, boolean markDone) throws EepyException {
        if (index < 0 || index >= tasks.size()) {
            throw new EepyException("Task number not within range.");
        }
        Task task = tasks.get(index);

        if (markDone) {
            task.markAsDone();
            Ui.showMessage("Well done! You've completed the following task:");
        } else {
            task.unmarkAsDone();
            Ui.showMessage("Oh no! You have one additional task:");
        }
        Ui.showMessage(" " + task);
        Database.saveTasks(this);
    }
}
