package com.superoback.controller;

import com.superoback.dto.TaskDTO;
import com.superoback.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "*")
@Api(tags = "Task endpoints")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @ApiOperation("Returns task list")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    @ApiOperation("Save task to database")
    public TaskDTO save(@RequestBody TaskDTO task) {
        return taskService.save(task.toModel());
    }

    @PutMapping
    @ApiOperation("Update task to database")
    public TaskDTO update(@RequestBody TaskDTO task) {
        return taskService.save(task.toModel());
    }

    @GetMapping("/{id}")
    @ApiOperation("Find task in the database")
    public ResponseEntity<?> findOne(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(taskService.findOne(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete task from database")
    public void delete(@PathVariable(value = "id") long id) {
        taskService.delete(id);
    }

}
