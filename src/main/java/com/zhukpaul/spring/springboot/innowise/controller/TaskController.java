package com.zhukpaul.spring.springboot.innowise.controller;

import com.zhukpaul.spring.springboot.innowise.entity.Task;
import com.zhukpaul.spring.springboot.innowise.exceptions.IncorrectDataHandler;
import com.zhukpaul.spring.springboot.innowise.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/projects/{proj_id}/tasks")
    public List<Task> getTasksForProject(@PathVariable int proj_id) {
        return taskService.getAllTasksForProject(proj_id);
    }

    @PostMapping("/projects/{proj_id}/tasks")
    public Task addTask(@PathVariable int proj_id, @RequestBody Task task) {
        return taskService.saveTaskForProject(proj_id, task);
    }

    @PutMapping("/projects/{proj_id}/tasks")
    public Task updateTask(@PathVariable int proj_id, @RequestBody Task task) {
        return taskService.saveTaskForProject(proj_id, task);
    }

    @DeleteMapping("/projects/{proj_id}/tasks/{task_id}")
    public String deleteTask(@PathVariable int proj_id, @PathVariable int task_id) {
        taskService.deleteTaskForProject(proj_id, task_id);
        return "Task with id = " + task_id + " was deleted in project with id = " + proj_id;
    }
}
