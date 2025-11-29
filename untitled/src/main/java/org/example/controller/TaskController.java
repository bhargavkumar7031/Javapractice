package org.example.controller;

import org.example.DTO.TaskDTO;
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
    public ResponseEntity<TaskDTO> getTask(@PathVariable int id) {
        Task t = taskService.getTask(id);
        TaskDTO taskDto = taskService.convertTaskToDTO(t);
        System.out.println(t);
        return ResponseEntity.status(200).body(taskDto);
    }

    @PostMapping("/addTask")
    public ResponseEntity<String> addtask(@RequestBody TaskDTO taskdto){
        Task t = taskService.convertDtoToTask(taskdto);
        taskService.addTask(t);
        return ResponseEntity.status(200).body("Task added successfully");
    }
}
`