package com.devflow.devflow.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be empty")
    @Column(nullable = false, length = 1000)
    private String description;

    @NotBlank(message = "Status cannot be empty")
    @Column(nullable = false)
    private String status;

    @NotBlank(message = "Priority cannot be empty")
    @Column(nullable = false)
    private String priority;

    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Default constructor
    public Task() {
    }

    // Constructor
    public Task(String title, String description, String status,
                String priority, LocalDate dueDate) {

        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Automatically set creation time
    @jakarta.persistence.PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // Automatically update modification time
    @jakarta.persistence.PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Get ID
    public Long getId() {
        return id;
    }

    // Set ID
    public void setId(Long id) {
        this.id = id;
    }

    // Get Title
    public String getTitle() {
        return title;
    }

    // Set Title
    public void setTitle(String title) {
        this.title = title;
    }

    // Get Description
    public String getDescription() {
        return description;
    }

    // Set Description
    public void setDescription(String description) {
        this.description = description;
    }

    // Get Status
    public String getStatus() {
        return status;
    }

    // Set Status
    public void setStatus(String status) {
        this.status = status;
    }

    // Get Priority
    public String getPriority() {
        return priority;
    }

    // Set Priority
    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Get Due Date
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Set Due Date
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Get Created At
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Get Updated At
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}