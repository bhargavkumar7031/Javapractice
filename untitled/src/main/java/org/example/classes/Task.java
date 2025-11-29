package org.example.classes;

import org.springframework.stereotype.Component;

@Component
public class Task {
    private int taskId;
    private String name;
    private String priority;
    private String status;
    private User userId;

    public Task() {};

    public Task(int taskId, String status, String priority, String name) {
        this.taskId = taskId;
        this.status = status;
        this.priority = priority;
        this.name = name;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}
