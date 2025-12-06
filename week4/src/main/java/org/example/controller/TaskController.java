package org.example.controller;

import org.example.classes.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.services.TaskService;

import java.util.List;

@Controller
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    @ResponseBody
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
//        return "Task added successfully";
    }

    @GetMapping("/filterByStatus/{status}")
    @ResponseBody
    public List<Task> getTasksByStatus(@PathVariable String status){
        return taskService.StatusFilteredTasks(status);
    }
}
