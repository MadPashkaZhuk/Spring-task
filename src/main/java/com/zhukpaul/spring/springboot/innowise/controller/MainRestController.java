package com.zhukpaul.spring.springboot.innowise.controller;

import com.zhukpaul.spring.springboot.innowise.entity.Project;
import com.zhukpaul.spring.springboot.innowise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> showAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable int id) {
        return projectService.getProject(id);
    }

    @PostMapping("/projects")
    public Project saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
        return project;
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project) {
        projectService.saveProject(project);
        return project;
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return "Project with id = " + id + " was deleted";
    }


}
