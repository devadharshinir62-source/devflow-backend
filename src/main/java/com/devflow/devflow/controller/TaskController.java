package com.devflow.devflow.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devflow.devflow.TaskStatistics;
import com.devflow.devflow.entity.Task;
import com.devflow.devflow.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(
    origins = {
        "https://devflow-frontend-a63thw8rc-devadharshini-r.vercel.app"
    }
)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                taskService.getTaskById(id)
        );
    }

    @GetMapping("/statistics")
    public ResponseEntity<TaskStatistics> getStatistics() {
        return ResponseEntity.ok(
                taskService.getStatistics()
        );
    }

    @PostMapping
    public ResponseEntity<Task> createTask(
            @Valid @RequestBody Task task) {

        return ResponseEntity.ok(
                taskService.createTask(task)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {

        return ResponseEntity.ok(
                taskService.updateTask(id, task)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }
}