package com.devflow.devflow;

public class TaskStatistics {

    private long totalTasks;
    private long todoTasks;
    private long inProgressTasks;
    private long completedTasks;

    private long highPriorityTasks;
    private long mediumPriorityTasks;
    private long lowPriorityTasks;

    public TaskStatistics() {
    }

    public TaskStatistics(
            long totalTasks,
            long todoTasks,
            long inProgressTasks,
            long completedTasks,
            long highPriorityTasks,
            long mediumPriorityTasks,
            long lowPriorityTasks
    ) {
        this.totalTasks = totalTasks;
        this.todoTasks = todoTasks;
        this.inProgressTasks = inProgressTasks;
        this.completedTasks = completedTasks;
        this.highPriorityTasks = highPriorityTasks;
        this.mediumPriorityTasks = mediumPriorityTasks;
        this.lowPriorityTasks = lowPriorityTasks;
    }

    public long getTotalTasks() {
        return totalTasks;
    }

    public long getTodoTasks() {
        return todoTasks;
    }

    public long getInProgressTasks() {
        return inProgressTasks;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public long getHighPriorityTasks() {
        return highPriorityTasks;
    }

    public long getMediumPriorityTasks() {
        return mediumPriorityTasks;
    }

    public long getLowPriorityTasks() {
        return lowPriorityTasks;
    }
}