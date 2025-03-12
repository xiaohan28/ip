package eepy.task;

/**
 * Represents an event task with a description, start and end time.
 */
public class Event extends Task{
    protected String from;
    protected String to;

    /**
     * Retrieves the start time of the event.
     *
     * @return The start time as a string.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Retrieves the end time of the event.
     *
     * @return The end time as a string.
     */
    public String getTo() {
        return to;
    }

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Retrieves the task type identifier for an event task.
     *
     * @return "E" representing the task type Event.
     */
    @Override
    public String getTaskType() {
        return "E";
    }

    /**
     * Returns the string representation of the event task.
     *
     * @return The formatted string containing task details.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
