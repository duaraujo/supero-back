package com.superoback.controller;

import com.superoback.dto.TaskDTO;
import com.superoback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    public TaskDTO save(@RequestBody TaskDTO task) {
        return taskService.save(task.toModel());
    }

    @PutMapping
    public TaskDTO update(@RequestBody TaskDTO task) {
        return taskService.save(task.toModel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(taskService.findOne(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        taskService.delete(id);
    }

}
