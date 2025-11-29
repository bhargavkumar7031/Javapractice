package org.example.services;

import org.example.DTO.TaskDTO;
import org.example.classes.Task;
import org.example.sql.TasksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TasksDAO tasksDAO;

    public Task getTask(int id) {
        return tasksDAO.readTask(id);
    }

    public void addTask(Task task) {
        tasksDAO.addTask(task);
    }

    public TaskDTO convertTaskToDTO(Task task) {
        TaskDTO taskDto = new TaskDTO();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setName(task.getName());
        taskDto.setPriority(task.getPriority());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }

    public Task convertDtoToTask(TaskDTO taskDto) {
        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setName(taskDto.getName());
        task.setPriority(taskDto.getPriority());
        task.setStatus(taskDto.getStatus());
        return task;
    }
}
