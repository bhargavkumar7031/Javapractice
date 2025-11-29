package org.example.controller;

import org.example.classes.Task;
import org.example.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        Task t = taskService.getTask(id);
        System.out.println(t);
        return ResponseEntity.status(200).body(t);
    }

    @PostMapping("/addTask")
    public ResponseEntity<String> addtask(@RequestBody Task task){
        taskService.addTask(task);
        return ResponseEntity.status(200).body("Task added successfully");
    }
}
