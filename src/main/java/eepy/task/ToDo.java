package eepy.task;

/**
 * Represents a to-do task with a description.
 */
public class ToDo extends Task {

    /**
     * Constructs a to-do task with a description.
     *
     * @param description The description of the to-do task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of the to-do task.
     *
     * @return The formatted string containing task details.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
