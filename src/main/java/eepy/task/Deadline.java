package eepy.task;

/**
 * Represents a deadline task with a description and specific due date.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Retrieves the due date of the deadline task.
     *
     * @return The due date as a string.
     */
    public String getBy() {
        return by;
    }

    /**
     * Contructs a Deadline task with description and due date.
     *
     * @param description The description of the task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Retrieves the task type identifier for a deadline task
     *
     * @return "D" representing the task type Deadline.
     */
    @Override
    public String getTaskType() {
        return "D";
    }

    /**
     * Returns the deadline task as a string.
     *
     * @return The formatted string containing task details.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
