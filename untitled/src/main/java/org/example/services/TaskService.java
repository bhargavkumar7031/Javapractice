package org.example.services;

import org.example.sql.TasksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TasksDAO tasksDAO;


}
