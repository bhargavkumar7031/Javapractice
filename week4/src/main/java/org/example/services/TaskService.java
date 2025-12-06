package org.example.services;

import org.example.classes.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.TasksRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    public Task addTask(Task task){
        return tasksRepository.save(task);
    }

    public List<Task> StatusFilteredTasks(String status){
        return tasksRepository.findByStatus(status);
    }
}
