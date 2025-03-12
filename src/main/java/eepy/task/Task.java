package eepy.task;

/**
 * Represents a generic task with a description and completion status.
 */
public class Task {
    private final String description;
    private boolean isDone;

    /**
     * Retrieves the description of the task.
     *
     * @return The task description as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the task is marked as done.
     *
     * @return True if the task is completed, represented by [X], false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Constructs a Task with the given description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Retrieves the status icon representing whether the task is done.
     *
     * @return "X" if the task is done, otherwise a space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks the task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void unmarkAsDone() {
        isDone = false;
    }

    /**
     * Retrieves the task type identifier.
     *
     * @return "T" representing To Do task as the default type.
     */
    public String getTaskType() {
        return "T";
    }

    /**
     * Returns the string representation of the task.
     *
     * @return The formatted string containing task details.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

}
