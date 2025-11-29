package org.example.services;

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
}
