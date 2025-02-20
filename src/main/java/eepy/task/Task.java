package eepy.task;

public class Task implements TaskInterface{
    private final String description;
    private boolean isDone;

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    @Override
    public String getTaskType() {
        return "T"; //default type
    }

}
