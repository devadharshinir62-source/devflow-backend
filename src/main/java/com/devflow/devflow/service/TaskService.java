package com.devflow.devflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devflow.devflow.TaskNotFoundException;
import com.devflow.devflow.TaskStatistics;
import com.devflow.devflow.entity.Task;
import com.devflow.devflow.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // CREATE TASK
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // GET ALL TASKS
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // GET TASK BY ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(
                                "Task not found with id: " + id
                        )
                );
    }

    // UPDATE TASK
    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(
                                "Task not found with id: " + id
                        )
                );

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    // DELETE TASK
    public void deleteTask(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(
                    "Task not found with id: " + id
            );
        }

        taskRepository.deleteById(id);
    }

    // TASK STATISTICS
    public TaskStatistics getStatistics() {

        List<Task> tasks = taskRepository.findAll();

        long totalTasks = tasks.size();

        long todoTasks = tasks.stream()
                .filter(task -> "TODO".equalsIgnoreCase(task.getStatus()))
                .count();

        long inProgressTasks = tasks.stream()
                .filter(task -> "IN_PROGRESS".equalsIgnoreCase(task.getStatus()))
                .count();

        long completedTasks = tasks.stream()
                .filter(task -> "COMPLETED".equalsIgnoreCase(task.getStatus()))
                .count();

        long highPriorityTasks = tasks.stream()
                .filter(task -> "HIGH".equalsIgnoreCase(task.getPriority()))
                .count();

        long mediumPriorityTasks = tasks.stream()
                .filter(task -> "MEDIUM".equalsIgnoreCase(task.getPriority()))
                .count();

        long lowPriorityTasks = tasks.stream()
                .filter(task -> "LOW".equalsIgnoreCase(task.getPriority()))
                .count();

        return new TaskStatistics(
                totalTasks,
                todoTasks,
                inProgressTasks,
                completedTasks,
                highPriorityTasks,
                mediumPriorityTasks,
                lowPriorityTasks
        );
    }
}